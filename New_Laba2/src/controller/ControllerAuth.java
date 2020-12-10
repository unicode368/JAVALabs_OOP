package controller;

import model.Input;

import view.GeneralView;
import view.ProgramView;


public  class ControllerAuth extends Controller {

    private ProgramView view;
    private Input input;


    public ControllerAuth() {
        view = new ProgramView();
        input = new Input();
    }


    String[] getLoginAndPassword() {
        String[] loginPassword = new String[2];
        view.printMessage(view.LOGIN);
        String login = input.getUserInput();
        loginPassword[0] = login;
        view.printMessage(view.PASSWORD);
        String password = input.getUserInput();
        loginPassword[1] = password;
        return loginPassword;
    }
}
