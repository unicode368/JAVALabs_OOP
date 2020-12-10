package model.service;

import controller.Converter;
import controller.Validator;
import model.*;
import model.dao.BookDAO;
import model.dao.UserDAO;
import model.exceptions.InvalidDataException;
import model.exceptions.InvalidOptionException;
import model.user.Admin;
import model.user.User;
import model.user.UserType;
import util.Tools;
import view.AdminView;

import java.util.ArrayList;

public class AdminService extends Service {

    private Admin admin;
    private Input input;
    private AdminView view;
    private UserDAO userDAO;
    private BookDAO bookDAO;
    private Converter bookConverter;
    private Converter userConverter;
    private Tools tools;

    public AdminService(Admin admin) {
        this.admin = admin;
        input = new Input();
        view = new AdminView();
        userDAO = new UserDAO();
        userConverter = new Converter(ObjectType.USER);
        bookDAO = new BookDAO();
        bookConverter = new Converter(ObjectType.BOOK);
        tools = new Tools();
    }

    public void execute() {
        while (true) {
            view.printMessage(view.ADMIN_WELCOME);
            int option = defineOption(0,6);
            switch (option) {
                case 1: addBook();
                    break;
                case 2: deleteBook();
                    break;
                case 3:
                    break;
                case 4: createLibrarian();
                    break;
                case 5: break;
                case 6: changeUserStatus();
                    break;
                case 7: break;
            }
            if (option == 0) {
                break;
            }
        }
    }

    public int defineOption(int start, int end) {
        ArrayList<Integer> options = new ArrayList<>();
        for (int i = start; i <= end; i++) {
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

    public String[] getBookInfo() {
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
    }

    public void addBook() {
        String[] info = getBookInfo();
        Book book = new Book(info[0],info[1],info[2], new Date(info[3]));
        bookDAO.add(book);
        view.show(view.BOOK_LIST, bookConverter);
    }

    public void deleteBook() {
        view.printMessage(view.BOOK_LIST);
        view.show(view.BOOK_LIST, bookConverter);
        view.printMessage(view.BOOK_NUMBER);
        int number = defineOption(1, bookDAO.getAll().size()) - 1;
        bookDAO.delete(number);
        view.printMessage(view.BOOK_LIST);
        view.show(view.BOOK_LIST, bookConverter);
    }

    public void editBook() {

    }

    public void createLibrarian() {
        view.show(view.USER_LIST, userConverter);
        String[] info = getLoginAndPassword();
        userDAO.add(new User(info[0], info[1], UserType.LIBRARIAN));
        view.show(view.USER_LIST, userConverter);
    }

    public void deleteLibrarian() {
        view.printMessage(view.USER_LIST);
/*        view.execute(userConverter);
        view.print(view.BOOK_NUMBER);
        int number = defineOption(1, bookDAO.getAll().size()) - 1;
        bookDAO.delete(number);
        view.print(view.BOOK_LIST);
        view.execute(bookConverter);*/
    }

    public void changeUserStatus() {
        view.printMessage(view.USER_LIST);
        view.show(view.USER_LIST, userConverter);
        view.printMessage(view.USER_EDIT);
        int number = defineOption(1, userDAO.getAll().size()) - 1;
        userDAO.get(number).setBlocked();
        view.printMessage(view.USER_LIST);
        view.show(view.USER_LIST, userConverter);
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
}
