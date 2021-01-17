package model.service;

import controller.Validator;
import model.Book;
import model.dao.Storage;
import model.exceptions.InvalidOptionException;
import model.user.User;
import view.LibrarianView;

import java.util.ArrayList;
import java.util.Scanner;

public class LibrarianService extends Service {

    private User librarian;
    private LibrarianView view;
 //   private UserDAO dao;

    public LibrarianService(User librarian) {
        this.librarian = librarian;
        view = new LibrarianView();
//        this.dao = dao;
    }

    public void execute() {
        while (true) {
            view.printMessage(view.LIBRARIAN_WELCOME);
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
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i <= end; i++) {
            options.add(i);
        }
        while (true) {
            String userOption = scanner.nextLine();
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
