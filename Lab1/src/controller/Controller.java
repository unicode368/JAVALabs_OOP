package controller;

import model.BusinessLogic;
import model.DataSource;
import View.ProgramView;

public class Controller {

    private int option;
    private ProgramView start;
    private InputStream input;
    private Validator validator;
    private ProgramView view;
    private BusinessLogic choosenTask;
    private DataSource dataSource;

    public Controller() {
        start = new ProgramView();
        input = new InputStream();
        validator = new Validator();
        view = new ProgramView();
        choosenTask = new BusinessLogic();
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
}
