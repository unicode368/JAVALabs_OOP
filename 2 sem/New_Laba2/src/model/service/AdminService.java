package model.service;

import model.*;
import model.dao.BookDAO;
import model.dao.UserDAO;
import model.user.User;
import model.user.UserType;
import util.CredentialsRandomizer;
import util.Tools;


public class AdminService extends Service {

    private UserDAO userDAO;
    private BookDAO bookDAO;
    private Tools<Book> bookTools;
    private Tools<User> userTools;

    public AdminService() {
        userDAO = new UserDAO();
        bookDAO = new BookDAO();
        bookTools = new Tools<>(ObjectType.BOOK);
        userTools = new Tools<>(ObjectType.USER);
    }

    public void addBook(String[] data) {
        String[] info = data;
        Book book = new Book(info[0],info[1], info[2], new Date(info[3]));
        bookDAO.add(book);
    }

    public void deleteBook(int number) {
        bookDAO.delete(number);
    }

    public void editBook() {

    }

    public void createLibrarian() {
        String[] info = CredentialsRandomizer.generateCredentials();
        userDAO.add(new User(info[0], info[1], UserType.LIBRARIAN));
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
