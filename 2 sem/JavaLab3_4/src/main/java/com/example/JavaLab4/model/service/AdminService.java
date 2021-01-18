package com.example.JavaLab4.model.service;

import com.example.JavaLab4.model.*;
import com.example.JavaLab4.model.dao.BookDAO;
import com.example.JavaLab4.model.dao.UserDAO;
import com.example.JavaLab4.model.user.User;
import com.example.JavaLab4.model.user.UserType;
import com.example.JavaLab4.util.CredentialsRandomizer;
import com.example.JavaLab4.util.Tools;

import java.sql.SQLException;


public class AdminService extends Service {

    private UserDAO userDAO;
    private BookDAO bookDAO;
    private Tools<Book> bookTools;
    private Tools<User> userTools;

    public AdminService() throws SQLException, ClassNotFoundException {
        userDAO = new UserDAO();
        bookDAO = new BookDAO();
        bookTools = new Tools<>(ObjectType.BOOK);
        userTools = new Tools<>(ObjectType.USER);
    }

    public void addBook(String[] data) {
        String[] info = data;
/*       Book book = new Book(bookDAO.getAll().size() + 1,
                info[0],info[1], info[2], new Date(info[3]));
        bookDAO.add(book);*/
    }

    public void deleteBook(int number) {
        bookDAO.delete(number);
    }

    public void editBook() {

    }

    public void createLibrarian() {
        String[] info = CredentialsRandomizer.generateCredentials();
//        userDAO.add(new User(userDAO.getAll().size() + 1, info[0], info[1], UserType.LIBRARIAN));
    }

    public void deleteLibrarian() {
//        view.printMessage(view.USER_LIST);
/*        view.execute(userConverter);
        view.print(view.BOOK_NUMBER);
        int number = defineOption(1, bookDAO.getAll().size()) - 1;
        bookDAO.delete(number);
        view.print(view.BOOK_LIST);
        view.execute(bookConverter);*/
    }

    public void changeUserStatus(int number) {
        userDAO.get(number).setBlocked();
    }

    public UserDAO getUserDAO() {
        return super.getUserDAO();
    }

}
