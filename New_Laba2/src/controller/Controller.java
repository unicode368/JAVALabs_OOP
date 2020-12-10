package controller;


import model.Input;
import model.exceptions.InvalidOptionException;
import view.ProgramView;

import java.util.ArrayList;

public class Controller {

    private ProgramView view;
    private Input input;


    public Controller() {
        view = new ProgramView();
        input = new Input();
    }

    int defineOption(int start, int end) {
        ArrayList<Integer> options = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            options.add(i);
        }
        while (true) {
            String userOption = input.getUserInput();
            try {
                Validator.checkOption(userOption, options);
            } catch (InvalidOptionException e) {
                view.printError(e.getMessage());
                continue;
            }
            return Integer.parseInt(userOption);
        }
    }

}
