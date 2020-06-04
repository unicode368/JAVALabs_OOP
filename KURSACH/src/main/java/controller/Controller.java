package controller;

import model.BusinessLogic;
import model.Input;
import model.entity.Entity;
import model.entity.Time;
import model.exceptions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import view.ProgramView;

import java.io.IOException;

public class Controller {

    private final static Logger logger = LogManager.getLogger("controller");
    private ProgramView view;
    private Input input;
    private BusinessLogic businessLogic;
    private DataManager dataManager;
    private boolean en;


    public Controller() {
        try {
            logger.info("Запуск додатку...");
            input = new Input();
            view = new ProgramView();
            chooseLanguage();
            businessLogic = new BusinessLogic();
            logger.info("Файл прочитано.");
            dataManager = new DataManager();
        } catch (IOException|NumberFormatException e) {
            logger.fatal("не вдалось запустити додаток - {}", e.getMessage());
            view.printError("file.not.read");
            System.exit(1);
        }
    }

    private void chooseLanguage() {
        logger.debug("Вибір мови...");
        view.printMessage("language");
        while (true) {
            String userOption = input.getUserInput();
            try {
                Validator.checkLanguage(userOption);
            } catch (InvalidOptionException e) {
                logger.error("помилка - {}. Повторне введення...", (e.getMessage()).split("\\.")[0]);
                view.printError(e.getMessage());
                continue;
            }
            if (Integer.parseInt(userOption) == 2) {
                view.changeDefaultLanguage("en", "EN");
                en = true;
                logger.info("Обрана мова - {}", "en");
            }
            break;
        }
    }

    public void run() {
        printAllTrains(checkData(businessLogic.getList()));
        logger.info("Друк наявних поїздів...");
        while (true) {
            view.show();
            switch (defineOption()) {
                case 0: logger.info("Обрано опцію 0. Завершення роботи...");
                    System.exit(0);
                case 1: logger.info("Обрано опцію 1. Пошук поїздів із загальними місцями...");
                    getResult(businessLogic.getTrainsWithGeneralPlaces(),"за загальними місцями" );
                break;
                case 2: logger.info("Обрано опцію 2. Запит додаткової інформації...");
                    getResult(businessLogic.searchByPlaceAndTime(defineTime(),
                            defineFinalDestination()), "за часом та пунктом призначення");
                break;
            }
        }
    }

    private Entity[] checkData(Entity[] data) {
        int i = 1;
        logger.debug("Валідація даних, отриманих з файлу...");
        try {
            for (Entity train : data) {
                logger.trace("Валідація " + i + "-го" + " поїзда...");
                logger.trace("Валідація номера потягу...");
                Validator.isPositive(Integer.parseInt(train.getTrainNumber()));
                logger.trace("Валідація пункту призначення...");
                Validator.isCity(train.getFinalDestination());
                logger.trace("Валідація часу відправлення...");
                Validator.isTimeFormat(train.getDepartureTime().toString());
                logger.trace("Валідація к-сті загальних місць...");
                Validator.isPositive(train.getSitsNumber()[0]);
                logger.trace("Валідація к-сті плацкартних місць...");
                Validator.isPositive(train.getSitsNumber()[1]);
                logger.trace("Валідація к-сті купе-місць...");
                Validator.isPositive(train.getSitsNumber()[2]);
                logger.trace("Валідація к-сті СВ-місць...");
                Validator.isPositive(train.getSitsNumber()[3]);
            }
            logger.info("Валідацію даних завершено.");
        } catch (InvalidTimeException |
                InvalidFinalDestinationException |
                NegativeNumberOfSitsException|
                NumberFormatException e) {
            logger.fatal("Не вдалось прочитати файл - {}", e.getMessage());
            view.printError("file.not.read");
            System.exit(1);
        }
        return data;
    }

    private String getFileLocation(String userFile) {
        try {
            Validator.checkFormat(userFile.substring(userFile.lastIndexOf("\\")));
        } catch (InvalidFileTypeException e) {
            view.printError(e.getMessage());
        }
        return userFile.replace("\\","/");
    }


    private int defineOption() {
        logger.debug("Введення користувачем опції...");
        while (true) {
            String userOption = input.getUserInput();
            try {
                Validator.checkOption(userOption);
            } catch (InvalidOptionException e) {
                logger.error("помилка - {}. Повторне введення...", (e.getMessage()).split("\\.")[0]);
                view.printError(e.getMessage());
                continue;
            }
            return Integer.parseInt(userOption);
        }
    }


    public void getResult(Entity[] result, String option) {
        logger.info("Пошук поїздів за запитом завершено.");
        Converter converter = new Converter(result);
        switch (option) {
            case "за загальними місцями":
                logger.debug("Вивід поїздів з наявними загальними місцями...");
                view.result("trains.with.general.places", converter);
                saveToFileOrNot(result);
                break;
            case "за часом та пунктом призначення":
                logger.debug("Вивід поїздів, які відправляються після заданого " +
                        "часу та до вказаного пункту призначення...");
                view.result("searched.by.place.and.time", converter);
                saveToFileOrNot(result);
                break;
        }
        logger.info("Запит виконано.");
    }

    private void saveToFileOrNot(Entity[] result) {
        logger.info("Очікування рішення користувача щодо збереження результату в файл...");
        view.printMessage("save.to.file.offer");
        String final_response;
        while (true) {
            try {
                String response = input.getUserInput();
                Validator.checkYesOrNoOptions(response);
                final_response = response;
            } catch (InvalidOptionException e) {
                logger.error("Введено значення, відмінне від так або ні. Повторна спроба...");
                view.printError(e.getMessage());
                continue;
            }
            break;
        }
        while (true) {
            try {
                if (final_response.equals((en) ? "yes" : "так")) {
                    logger.debug("Обрано так. Введення шляху до нового файлу...");
                    if (result.length == 0) {
                        logger.warn("УВАГА!Відсутні дані для запису в файл.");
                    }
                    view.printMessage("new.file.location");
                    String location = input.getUserInput();
                    logger.info("Введення ім'я нового файлу...");
                    view.printMessage("file.name");
                    String name = input.getUserInput();
                    dataManager.writeDataToFile(getFileLocation(location
                            + "\\" + name), result);
                    logger.info("Файл записано.");
                    view.printMessage("result");
                }
                logger.debug("Обрано ні. Повернення до меню...");
            } catch (IOException e) {
                logger.error("Введено некоректний шлях або ім'я файлу. Повторна спроба...");
                view.printError("file.not.written");
                continue;
            }
            break;
        }
    }


    private String defineFinalDestination() {
        logger.debug("Введення пункту призначення користувачем...");
        view.printMessage("final.destination");
        while (true) {
            String destination = input.getUserInput();
            try {
                Validator.isCity(destination);
            } catch (InvalidFinalDestinationException e) {
                logger.error("помилка - {}. Повторне введення...", e.getMessage().split("\\.")[0]);
                view.printError(e.getMessage());
                continue;
            }
            logger.trace("Користувач ввів пункт призначення.");
            return destination;
        }
    }


    private Time defineTime() {
        logger.debug("Введення часу користувачем...");
        view.printMessage("time");
        while (true) {
            String time = input.getUserInput();
            try {
                Validator.isTimeFormat(time);
            } catch (InvalidTimeException e) {
                logger.error("помилка - {}. Повторне введення...", e.getMessage().split("\\.")[0]);
                view.printError(e.getMessage());
                continue;
            }
            logger.trace("Користувач ввів час.");
            logger.info("Пошук поїздів, які відправляються після " +
                    "заданого часу та до заданого пункту призначення...");
            return new Time(time);
        }
    }

    private void printAllTrains(Entity[] list) {
        Converter converter = new Converter(list);
        view.result("train.list", converter);
    }

}