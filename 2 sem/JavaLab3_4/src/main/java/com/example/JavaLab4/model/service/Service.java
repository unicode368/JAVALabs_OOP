package com.example.JavaLab4.model.service;

import com.example.JavaLab4.model.*;
import com.example.JavaLab4.model.dao.BookDAO;
import com.example.JavaLab4.model.dao.UserDAO;
import com.example.JavaLab4.model.user.User;
import com.example.JavaLab4.util.Tools;

import java.sql.SQLException;

public class Service {

    private UserDAO userDAO;
    private BookDAO bookDAO;
    private Tools<Book> bookTools;
    private Tools<User> userTools;

    public Service() throws SQLException, ClassNotFoundException {
        bookDAO = new BookDAO();
        userDAO = new UserDAO();
        bookTools = new Tools<>(ObjectType.BOOK);
        userTools = new Tools<>(ObjectType.USER);
    }

    public void execute() {

    }

    void searchBy() {

    }


    public Tools<Book> getBookTools() {
        return bookTools;
    }

    public Tools<User> getUserTools() {
        return userTools;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public BookDAO getBookDAO() {
        return bookDAO;
    }
}
