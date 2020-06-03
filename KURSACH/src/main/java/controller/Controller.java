package controller;

import model.BusinessLogic;
import model.Input;
import model.entity.Entity;
import model.entity.Time;
import model.exceptions.InvalidFileTypeException;
import model.exceptions.InvalidFinalDestinationException;
import model.exceptions.InvalidOptionException;
import model.exceptions.InvalidTimeException;
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


    public Controller() {
        try {
            logger.info("Запуск додатку...");
            input = new Input();
            view = new ProgramView();
            businessLogic = new BusinessLogic();
            dataManager = new DataManager();

        } catch (IOException|NumberFormatException e) {
            logger.fatal("не вдалось запустити додаток - {}", e.getMessage());
            view.printError(view.FILE_NOT_READ);
            System.exit(1);
        }
    }

    public void run() {
        logger.info("Друк наявних поїздів");
        printAllTrains(checkData(businessLogic.getList()));
        while (true) {
            view.show();
            switch (defineOption()) {
                case 0: System.exit(0);
                case 1: getResult(businessLogic.getTrainsWithGeneralPlaces(),1 );
                break;
                case 2: getResult(businessLogic.searchByPlaceAndTime(defineTime(),
                        defineFinalDestination()), 2);
                break;
            }
        }
    }

    public Entity[] checkData(Entity[] data) {
        try {
            for (Entity train : data) {
                Validator.isPositive(Integer.parseInt(train.getTrainNumber()));
                Validator.isCity(train.getFinalDestination());
                Validator.isTimeFormat(train.getDepartureTime().toString());
                Validator.isPositive(train.getSitsNumber()[0]);
                Validator.isPositive(train.getSitsNumber()[1]);
                Validator.isPositive(train.getSitsNumber()[2]);
                Validator.isPositive(train.getSitsNumber()[3]);
            }
        } catch (InvalidTimeException |
                InvalidFinalDestinationException |
                NegativeArraySizeException|
                NumberFormatException e) {
            logger.fatal("не вдалось прочитати файл", e.getMessage());
            view.printError(view.FILE_NOT_READ);
            System.exit(1);
        }
        return data;
    }

    public String getFileLocation(String userFile) {
        while (true) {
            try {
                Validator.checkFormat(userFile.substring(userFile.lastIndexOf("\\")));
            } catch (InvalidFileTypeException e) {
                view.printError(e.getMessage());
                continue;
            }
            return userFile.replace("\\","/");
        }
    }


    public int defineOption() {
        while (true) {
            String userOption = input.getUserInput();
            try {
                Validator.checkOption(userOption);
            } catch (InvalidOptionException e) {
                view.printError(e.getMessage());
                continue;
            }
            return Integer.parseInt(userOption);
        }
    }


    public void getResult(Entity[] result, int option) {
        Converter converter = new Converter(result);
        switch (option) {
            case 1:
                view.result(view.TRAINS_WITH_GENERAL_PLACES, converter);
                saveToFileOrNot(result);
                break;
            case 2:
                view.result(view.SEARCHED_BY_PLACE_AND_TIME, converter);
                saveToFileOrNot(result);
                break;
        }

    }

    public void saveToFileOrNot(Entity[] result) {
        view.printMessage(view.SAVE_TO_FILE_OFFER);
        while (true) {
            try {
                String response = input.getUserInput();
                Validator.checkYesOrNoOptions(response);
                if (response.equals("так")) {
                    view.printMessage(view.NEW_FILE_LOCATION);
                    String location = input.getUserInput();
                    view.printMessage(view.FILE_NAME);
                    String name = input.getUserInput();

                    dataManager.writeDataToFile(getFileLocation(location
                            + "\\" + name), result);
                    view.printMessage(view.RESULT);
                }
            } catch (IOException e) {
                view.printError(view.FILE_NOT_WRITTEN);
                System.exit(1);
            } catch (InvalidOptionException e) {
                view.printError(e.getMessage());
                continue;
            }
            break;
        }
    }


    public String defineFinalDestination() {
        view.printMessage(view.FINAL_DESTINATION);
        while (true) {
            String destination = input.getUserInput();
            try {
                Validator.isCity(destination);
            } catch (InvalidFinalDestinationException e) {
                view.printError(e.getMessage());
                continue;
            }
            return destination;
        }
    }


    public Time defineTime() {
        view.printMessage(view.TIME);
        while (true) {
            String time = input.getUserInput();
            try {
                Validator.isTimeFormat(time);
            } catch (InvalidTimeException e) {
                view.printError(e.getMessage());
                continue;
            }
            return new Time(time);
        }
    }

    public void printAllTrains(Entity[] list) {
        Converter converter = new Converter(list);
        view.result(view.TRAIN_LIST, converter);
    }

}