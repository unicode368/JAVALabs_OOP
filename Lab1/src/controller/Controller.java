package controller;

import model.BusinessLogic;
import view.ProgramView;
import model.entity.Entity;

public class Controller {

    private int option;
    private InputStream input;
    private Validator validator;
    private ProgramView view;

    public Controller() {
        input = new InputStream();
        validator = new Validator();
        view = new ProgramView();
    }

    public void run() {
        while (true) {
            view.show();
            setOption(input.option());
            if (option == 0) {
                System.exit(0);
            }
            new BusinessLogic().execute(option);
        }

    }



    public void setOption(String userOption) {
        while (!validator.checkOption(userOption)) {
            view.wrongOption();
            userOption = input.option();
        }
        option = Integer.parseInt(userOption);
    }

    public void askForMessages(String message) {
        switch (message) {
            case "array size": view.arraySize();
            break;
            case "time": view.time();
            break;
            case "final destination": view.finalDestination();
            break;
            default: view.invalidAction();
            break;
        }
    }

    public String validateArraySize(String size) {
        while (!validator.checkArraySize(size)) {
            invalidInput("invalid array size");
            size = input.option();
        }
        return size;
    }

    public String validateFinalDestination(String destination) {
        while (!validator.isCity(destination)) {
            invalidInput("invalid final destination");
            destination = input.option();
        }
        return destination;
    }

    public String validateTime(String time) {
        while (!validator.isTimeFormat(time)) {
            invalidInput("invalid time");
            time = input.option();
        }
        return time;
    }


    public void sendResult(Entity[] result, int option) {
        OutputStream output = new OutputStream(result);
        view.result(option, output);
    }

    public void invalidInput(String input) {
        switch (input) {
            case "invalid array size": view.invalidArraySize();
                break;
            case "invalid time": view.invalidTime();
                break;
            case "invalid final destination": view.finalDestination();
                break;
            default: view.invalidAction();
                break;
        }

    }

}
