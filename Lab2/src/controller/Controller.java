package controller;

import model.BusinessLogic;
import model.entity.Time;
<<<<<<< Updated upstream
=======
<<<<<<<< Updated upstream:Lab2/src/controller/Controller.java
import model.exceptions.InvalidFinalDestinationException;
import model.exceptions.InvalidOptionException;
import model.exceptions.InvalidTimeException;
========
>>>>>>>> Stashed changes:Lab1/src/controller/Controller.java
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
            switch (defineOption(input.getUserInput())) {
=======
            switch (defineOption()) {
>>>>>>> Stashed changes
                case 0: System.exit(0);
                case 1: sendResult(businessLogic.getTrainsWithGeneralPlaces(),1 );
                break;
                case 2: sendResult(businessLogic.searchByPlaceAndTime(defineTime(),
                        defineFinalDestination()), 2);
                break;
            }
        }
    }

<<<<<<< Updated upstream
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

=======
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


>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
=======
<<<<<<<< Updated upstream:Lab2/src/controller/Controller.java
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
========
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======
>>>>>>>> Stashed changes:Lab1/src/controller/Controller.java
>>>>>>> Stashed changes
        }
        return destination;
    }

    public Time defineTime() {
<<<<<<< Updated upstream
=======
<<<<<<<< Updated upstream:Lab2/src/controller/Controller.java
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
========
>>>>>>> Stashed changes
        askForMessages("time");
        String time = input.getUserInput();
        while (!Validator.isTimeFormat(time)) {
            invalidInput("invalid time");
            time = input.getUserInput();
<<<<<<< Updated upstream
=======
>>>>>>>> Stashed changes:Lab1/src/controller/Controller.java
>>>>>>> Stashed changes
        }
        return new Time(time);
    }

    public void printAllTrains(Entity[] list) {
        Converter converter = new Converter(list);
        view.result(view.TRAIN_LIST, converter);
    }

}
