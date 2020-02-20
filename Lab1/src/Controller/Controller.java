package Controller;

import View.ProgramView;

public class Controller {

    private int option;
    private ProgramView start;
    private InputStream input;

    public Controller() {
        start = new ProgramView();
        input = new InputStream();
    }

    public void run() {
        start.show();
        input.option();
    }

    public void setOption(String option) {
        Validator validator = new Validator();
        while (!validator.checkOption(option)) {
            System.out.println("Невірно введені дані. Будь ласка, оберіть одну з опцій 1 або 2.");
            input.option();
        }
        this.option = Integer.parseInt(option);
    }
}
