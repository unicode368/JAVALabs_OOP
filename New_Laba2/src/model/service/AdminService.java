package model.service;

import controller.Converter;
import controller.Validator;
import model.Book;
import model.Date;
import model.Input;
import model.ObjectType;
import model.dao.BookDAO;
import model.dao.UserDAO;
import model.exceptions.InvalidDataException;
import model.exceptions.InvalidLoginInfo;
import model.exceptions.InvalidOptionException;
import model.user.Admin;
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

    public AdminService(Admin admin, UserDAO userDAO) {
        this.admin = admin;
        input = new Input();
        view = new AdminView();
        this.userDAO = userDAO;
        bookDAO = new BookDAO();
        bookConverter = new Converter(ObjectType.BOOK);
        userConverter = new Converter(ObjectType.USER);
        tools = new Tools();
    }

    public void execute() {
        while (true) {
            view.print(view.ADMIN_WELCOME);
            int option = defineOption(6);
            switch (option) {
                case 1: addBook();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4: break;
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

    public int defineOption(int end) {
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

    public String[] getBookInfo() {
        String[] info = new String[4];
        view.print(view.BOOK_NAME);
        info[0] = input.getUserInput();
        view.print(view.BOOK_AUTHOR);
        info[1] = input.getUserInput();
        view.print(view.BOOK_EDITION);
        info[2] = input.getUserInput();
        view.print(view.BOOK_DATA);
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
        Book book = new Book(info[0],info[1],info[2],new Date(info[3]));
        bookDAO.add(book);
        view.show(bookConverter);
    }

    public void deleteBook() {

    }

    public void editBook() {

    }

    public void createLibrarian() {
        view.show(userConverter);
        String[] info = getLoginAndPassword();
        tools.searchUser(info[0],info[1] , userDAO.getAll()).setBlocked();
        view.show(userConverter);
    }

    public void deleteLibrarian() {

    }

    public void changeUserStatus() {
        view.show(userConverter);
        while (true) {
            String[] info = getLoginAndPassword();
            try {
                Validator.validateLoginAndPassword(tools.searchUser(info[0], info[1], userDAO.getAll()));
            } catch (InvalidLoginInfo e) {
                view.printError(e.getMessage());
                continue;
            }
            tools.searchUser(info[0],info[1] , userDAO.getAll()).setBlocked();
            view.show(userConverter);
            break;
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
