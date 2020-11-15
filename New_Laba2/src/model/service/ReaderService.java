package model.service;

import controller.Validator;
import model.Input;
import model.exceptions.InvalidOptionException;
import model.user.Reader;
import view.ReaderView;

import java.util.ArrayList;

public class ReaderService extends Service {

    private Reader reader;
    private ReaderView view;
    private Input input;
//    private BookDAO dao;

    public ReaderService(Reader reader
          //  , BookDAO dao
    ) {
        this.reader = reader;
        view = new ReaderView();
        input = new Input();
//        this.dao = dao;
    }

    public void execute() {
        while (true) {
            view.print(view.READER_WELCOME);
            int option = defineOption(2);
            switch (option) {
                case 1: break;
                case 2: break;
            }
            if (option == 0) {
                break;
            }
        }
    }

    void orderBook() {

    }

    public int defineOption(int end) {
        ArrayList<Integer> options = new ArrayList<>();
        for (int i = 0; i <= end; i++) {
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
