package model.service;

import controller.Converter;
import model.Input;
import model.dao.BookDAO;
import model.dao.UserDAO;
import model.user.User;
import util.Tools;
import view.AdminView;

public class Service {

    User user;
    private Input input;
    private AdminView view;
    private UserDAO userDAO;
    private BookDAO bookDAO;
    private Converter bookConverter;
    private Tools tools;


    public void execute() {

    }

    void searchBy() {

    }

    void exit() {

    }

    public int defineOption(int n) {
        return 0;
    }

}
