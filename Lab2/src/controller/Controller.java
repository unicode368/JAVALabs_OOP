package controller;

import model.BusinessLogic;
import model.entity.Time;
import model.exceptions.InvalidFinalDestinationException;
import model.exceptions.InvalidOptionException;
import model.exceptions.InvalidTimeException;
import view.ProgramView;
import model.entity.Entity;

public class Controller {

    private ProgramView view;
    private Input input;
    private BusinessLogic businessLogic;

    public Controller() {
        input = new Input();
        view = new ProgramView();
        businessLogic = new BusinessLogic();
    }

    public void run() {
        printAllTrains(businessLogic.getList());
        while (true) {
            view.show();
            switch (defineOption()) {
                case 0: System.exit(0);
                case 1: sendResult(businessLogic.getTrainsWithGeneralPlaces(),1 );
                break;
                case 2: sendResult(businessLogic.searchByPlaceAndTime(defineTime(),
                        defineFinalDestination()), 2);
                break;
            }
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


    public void sendResult(Entity[] result, int option) {
        Converter converter = new Converter(result);
        switch (option) {
            case 1: view.result(view.TRAINS_WITH_GENERAL_PLACES, converter);
            break;
            case 2: view.result(view.SEARCHED_BY_PLACE_AND_TIME, converter);
            break;
            default: view.result(view.TRAIN_LIST, converter);
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