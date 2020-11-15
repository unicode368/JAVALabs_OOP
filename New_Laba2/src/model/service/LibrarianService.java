package model.service;

import controller.Validator;
import model.Book;
import model.Input;
import model.dao.Storage;
import model.exceptions.InvalidOptionException;
import model.user.Librarian;
import view.LibrarianView;

import java.util.ArrayList;

public class LibrarianService extends Service {

    private Librarian librarian;
    private LibrarianView view;
    private Input input;
 //   private UserDAO dao;

    public LibrarianService(Librarian librarian
            //,
                            //UserDAO dao
                            ) {
        this.librarian = librarian;
        view = new LibrarianView();
        input = new Input();
//        this.dao = dao;
    }

    public void execute() {
        while (true) {
            view.print(view.LIBRARIAN_WELCOME);
            int option = defineOption(1);
            switch (option) {
                case 1: break;
            }
            if (option == 0) {
                break;
            }
        }
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

    public void giveBook(Storage storage, Book book) {

    }

}
