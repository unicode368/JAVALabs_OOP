package controller;

import model.BusinessLogic;
import model.DataSource;
import view.ProgramView;
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

    public void askForData(int option) {
        dataSource = new DataSource();
        view.arraySize();
        String size = input.option();
        while (!validator.checkArraySize(size)) {
            size = input.option();
        }
        choosenTask.setList(dataSource.generateArray(Integer.parseInt(size)));
    }

    public void sendResult(Entity[] result, int option) {
        output.setList(result);
        view.result(option, output);
    }

    public void invalidArraySize() {
        view.invalidArraySize();
    }
}
