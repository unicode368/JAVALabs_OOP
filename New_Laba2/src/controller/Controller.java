package controller;

import controller.Autorization.ReaderRegistration;
import controller.Autorization.UserAutorization;
import model.Input;
import model.ObjectType;
import model.exceptions.BlockedUserException;
import model.exceptions.InvalidLoginInfo;
import model.exceptions.InvalidOptionException;
import util.Tools;
import view.GeneralView;

import java.util.ArrayList;

public class Controller {

    private GeneralView view;
    private Input input;
    private Converter book_converter;
    private UserAutorization userAutorization;
    private Tools tools;
    private ReaderRegistration readerRegistration;


    public Controller() {
        view = new GeneralView();
        input = new Input();
        book_converter = new Converter(ObjectType.BOOK);
        userAutorization = new UserAutorization();
        tools = new Tools();
        readerRegistration = new ReaderRegistration();
    }

    public void show() {
        while (true) {
            view.print(view.WELCOME);
            switch (defineOption(6)) {
                case 0:
                    System.exit(0);
                case 1: sign_up();
                    break;
                case 2: login();
                    break;
                case 3: view.show(book_converter);
                    break;
                case 4:
                    break;
            }
        }
    }

    public void login() {
        while (true) {
            String[] loginAndPassword = getLoginAndPassword();
            try {
                userAutorization.login(loginAndPassword[0], loginAndPassword[1]);
            } catch (InvalidLoginInfo e) {
                view.printError(e.getMessage());
                continue;
            } catch (BlockedUserException e) {
                view.printError(e.getMessage());
                System.exit(1);
            }
            break;
        }
    }

    //not done yet
    public void sign_up() {
        while (true) {
            String[] loginAndPassword = getLoginAndPassword();
            try {
                readerRegistration.signup(loginAndPassword[0], loginAndPassword[1]);
            } catch (InvalidLoginInfo e) {
                view.printError(e.getMessage());
                continue;
            }
            break;
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
        view.print(view.LOGIN);
        String login = input.getUserInput();
        loginPassword[0] = login;
        view.print(view.PASSWORD);
        String password = input.getUserInput();
        loginPassword[1] = password;
        return loginPassword;
    }


}
