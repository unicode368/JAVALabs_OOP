package controller;

import model.BusinessLogic;
import model.DataSource;
import View.ProgramView;
import model.Entity;

public class Controller {

    private int option;
    private ProgramView start;
    private InputStream input;
    private Validator validator;
    private ProgramView view;
    private BusinessLogic choosenTask;
    private DataSource dataSource;
    private OutputStream output;

    public Controller() {
        start = new ProgramView();
        input = new InputStream();
        validator = new Validator();
        view = new ProgramView();
        choosenTask = new BusinessLogic();
        output = new OutputStream();
    }

    public void run() {
        start.show();
        setOption(input.option());
        choosenTask.execute(option);
    }



    public void setOption(String userOption) {
        while (!validator.checkOption(userOption)) {
            view.wrongOption();
            userOption = input.option();
        }
        option = Integer.parseInt(userOption);
    }

    public void askForData() {
        view.arraySize();
        while (!validator.checkOption(input.option())) {
        }
    }

    public void sendResult(Entity[] result) {
        output.setList(result);
        view.result(option);
    }

    public void invalidArraySize(String errorType) {
        switch (errorType) {
            case "not numeric": view.notNumeric();
            break;
            case "negative number": view.negativeNumber();
            break;
            case "not inrteger": view.notInteger();

        }
    }
}
