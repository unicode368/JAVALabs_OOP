package controller;


import model.exceptions.InvalidOptionException;
import view.ProgramView;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    private ProgramView view;


    public Controller() {
        view = new ProgramView();
    }

    int defineOption(int start, int end) {
        ArrayList<Integer> options = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        for (int i = start; i <= end; i++) {
            options.add(i);
        }
        while (true) {
            String userOption = scan.nextLine();
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
