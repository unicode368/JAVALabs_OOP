package controller;

import controller.Autorization.UserAutorization;
import model.Input;
import model.Storage;
import model.exceptions.BlockedUserException;
import model.exceptions.InvalidDataException;
import model.exceptions.InvalidLoginInfo;
import model.exceptions.InvalidOptionException;
import model.user.Librarian;
import model.user.Reader;
import model.user.User;
import model.user.UserBase;
import view.ProgramView;

import java.util.ArrayList;

public class Controller {

/*    private ProgramView view;
    private Input input;
    private UserAutorization userAutorization;
    private Storage storage;
    private Converter book_converter;
    private Converter user_converter;
    private UserBase userBase;*/

    public Controller() {
/*        view = new ProgramView();
        input = new Input();
        storage = new Storage();
        userBase = new UserBase();
        userAutorization = new UserAutorization(userBase);
        book_converter = new Converter(storage.getBooks());
        user_converter = new Converter(userBase.getUsers());*/
    }

    /*public void run() {
        while (true) {
            view.printMessage(view.WELCOME);
            switch (defineOption(5)) {
                case 0: System.exit(0);
                case 1:
                    break;
                case 2: login();
                    break;
                case 3: break;
                case 4: break;
                case 5: break;
            }
        }
    }

    private int defineOption(int end) {
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

    private String[] getLoginAndPassword() {
        String[] loginPassword = new String[2];
        view.printMessage(view.LOGIN);
        String login = input.getUserInput();
        loginPassword[0] = login;
        view.printMessage(view.PASSWORD);
        String password = input.getUserInput();
        loginPassword[1] = password;
        return loginPassword;
    }

    private void login() {
        String[] loginAndPassword = getLoginAndPassword();
        User user = null;
        while (true) {
            try {
                user = userAutorization.login(loginAndPassword[0],
                        loginAndPassword[1]);
            } catch (InvalidLoginInfo e) {
                view.printError(e.getMessage());
                continue;
            } catch (BlockedUserException e) {
                view.printError(e.getMessage());
                System.exit(1);
            }
            break;
        }
        if (user.getRole().equals(Reader.class.getName())) {
            while (true) {
                view.printMessage(view.ADMIN_WELCOME);
                int option = defineOption(1);
                switch (option) {
                    case 1: String[] info = getBookInfo();
                        storage.add(info);
                        view.result(view.BOOK_LIST, book_converter);
                        break;
                }
                if (option == 0) {
                    break;
                }
            }
        } else if (user.getRole().equals(Librarian.class.getName())) {
            while (true) {
                view.printMessage(view.ADMIN_WELCOME);
                int option = defineOption(2);
                switch (option) {
                    case 1: String[] info = getBookInfo();
                        storage.add(info);
                        view.result(view.BOOK_LIST, book_converter);
                        break;
                    case 2: view.result(view.BOOK_LIST, book_converter);
                        view.printMessage(view.BOOK_NUMBER);
                        storage.remove(
                                defineOption(storage.getBooks().size()) - 1);
                        view.result(view.BOOK_LIST, book_converter);
                        break;
                }
                if (option == 0) {
                    break;
                }
            }
        } else {
            while (true) {
                view.printMessage(view.ADMIN_WELCOME);
                int option = defineOption(7);
                switch (option) {
                    case 1: String[] info = getBookInfo();
                        storage.add(info);
                        view.result(view.BOOK_LIST, book_converter);
                        break;
                    case 2: view.result(view.BOOK_LIST, book_converter);
                        view.printMessage(view.BOOK_NUMBER);
                        storage.remove(
                            defineOption(storage.getBooks().size()) - 1);
                        view.result(view.BOOK_LIST, book_converter);
                        break;
                    case 3: view.result(view.BOOK_LIST, book_converter);
                        view.printMessage(view.BOOK_EDIT);
                        storage.edit(
                                defineOption(storage.getBooks().size()) - 1,
                                getBookInfo());
                        view.result(view.BOOK_LIST, book_converter);
                        break;
                    case 4: break;
                    case 5: break;
                    case 6: view.result(view.USER_LIST, user_converter);
                        view.printMessage(view.USER_EDIT);
                        userBase.getUsers().get(
                                defineOption(userBase.getUsers().size()) - 1).setBlocked();
                        view.result(view.USER_LIST, user_converter);
                        break;
                }
                if (option == 0) {
                    break;
                }
            }
        }
    }

    private String[] getBookInfo() {
        String[] info = new String[4];
        view.printMessage(view.BOOK_NAME);
        info[0] = input.getUserInput();
        view.printMessage(view.BOOK_AUTHOR);
        info[1] = input.getUserInput();
        view.printMessage(view.BOOK_EDITION);
        info[2] = input.getUserInput();
        view.printMessage(view.BOOK_DATA);
        while (true) {
            String data = input.getUserInput();
            try {
                Validator.isDataFormat(data);
            } catch (InvalidDataException e) {
                view.printError(e.getMessage());
                continue;
            }
            info[3] = data;
            return info;
        }
    }*/


}
