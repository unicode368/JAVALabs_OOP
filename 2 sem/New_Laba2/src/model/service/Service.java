package model.service;

import model.Book;
import model.ObjectType;
import model.dao.BookDAO;
import model.dao.UserDAO;
import model.user.User;
import util.Tools;

public class Service {

    User user;
    private UserDAO userDAO;
    private BookDAO bookDAO;
    private Tools<Book> bookTools;
    private Tools<User> userTools;

    public Service() {
        userDAO = new UserDAO();
        bookDAO = new BookDAO();
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
}
