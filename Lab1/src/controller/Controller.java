package controller;

import model.BusinessLogic;
import model.entity.Time;
import view.ProgramView;
import model.entity.Entity;

public class Controller {

    private ProgramView view;
    private Input input;
    private BusinessLogic businessLogic;

    public Controller() {
        input = new Input();
        view = new ProgramView();
        businessLogic = new BusinessLogic(defineSize());
    }

    public void run() {
        printAllTrains(businessLogic.getList());
        while (true) {
            view.show();
            switch (defineOption(input.getUserInput())) {
                case 0: System.exit(0);
                case 1: sendResult(businessLogic.getTrainsWithGeneralPlaces(),1 );
                break;
                case 2: sendResult(businessLogic.searchByPlaceAndTime(defineTime(),
                        defineFinalDestination()), 2);
                break;
            }
        }
    }

    public int defineOption(String userOption) {
        while (!Validator.checkOption(userOption)) {
            view.printMessage(view.WRONG_OPTION);
            userOption = input.getUserInput();
        }
        return Integer.parseInt(userOption);
    }

    public void askForMessages(String message) {
        switch (message) {
            case "array size": view.printMessage(view.ARRAY_SIZE);
            break;
            case "time": view.printMessage(view.TIME);
            break;
            case "final destination": view.printMessage(view.FINAL_DESTINATION);
            break;
            default: view.printMessage(view.INVALID_ACTION);
            break;
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

    public void invalidInput(String input) {
        switch (input) {
            case "invalid array size": view.printMessage(view.INVALID_ARRAY_SIZE);
                break;
            case "invalid time": view.printMessage(view.INVALID_TIME);
                break;
            case "invalid final destination": view.printMessage(view.INVALID_DESTINATION);
                break;
            default: view.printMessage(view.INVALID_ACTION);
                break;
        }
    }

    public int defineSize() {
        askForMessages("array size");
        String size = input.getUserInput();
        while (!Validator.checkArraySize(size)) {
            invalidInput("invalid array size");
            size = input.getUserInput();
        }
        return Integer.parseInt(size);
    }

    public String defineFinalDestination() {
        askForMessages("final destination");
        String destination = input.getUserInput();
        while (!Validator.isCity(destination)) {
            invalidInput("invalid final destination");
            destination = input.getUserInput();
        }
        return destination;
    }

    public Time defineTime() {
        askForMessages("time");
        String time = input.getUserInput();
        while (!Validator.isTimeFormat(time)) {
            invalidInput("invalid time");
            time = input.getUserInput();
        }
        return new Time(time);
    }

    public void printAllTrains(Entity[] list) {
        Converter converter = new Converter(list);
        view.result(view.TRAIN_LIST, converter);
    }

}
