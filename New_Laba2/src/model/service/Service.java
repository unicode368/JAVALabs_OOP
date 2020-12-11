package model.service;

import controller.Converter;
import model.dao.BookDAO;
import model.dao.UserDAO;
import model.user.User;
import util.Tools;
import view.AdminView;
import view.GeneralView;

import java.awt.print.Book;

public class Service {

    User user;
    private UserDAO userDAO;
    private BookDAO bookDAO;
    private Tools<Book> bookTools;
    private Tools<User> userTools;

    public Service() {
        userDAO = new UserDAO();
        bookDAO = new BookDAO();
        bookTools = new Tools<>();
        userTools = new Tools<>();
    }

    public void execute() {

    }

    void searchBy() {

    }

    void exit() {

    }

    public Tools<Book> getBookTools() {

    }




}
