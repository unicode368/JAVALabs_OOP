package controller;

import model.Book;
import model.ObjectType;
import model.dao.BookDAO;
import model.dao.UserDAO;
import model.exceptions.InvalidDataException;
import model.exceptions.InvalidOptionException;
import model.service.AdminService;
import model.user.User;
import util.Tools;
import view.AdminView;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminController extends Controller {

    private User admin;
    private AdminView view;
    private Converter bookConverter;
    private Converter userConverter;
    private AdminService adminService;

    public AdminController(User admin) {
        this.admin = admin;
        view = new AdminView();
        userConverter = new Converter(ObjectType.USER);
        bookConverter = new Converter(ObjectType.BOOK);
        adminService = new AdminService();
    }

    public void execute() {
        while (true) {
            view.printMessage(view.ADMIN_WELCOME);
            int option = defineOption(0,6);
            switch (option) {
                case 1: view.show(view.BOOK_LIST, bookConverter);
                    adminService.addBook(getBookInfo());
                    view.show(view.BOOK_LIST, bookConverter);
                    break;
                case 2: view.printMessage(view.BOOK_LIST);
                    view.show(view.BOOK_LIST, bookConverter);
                    view.printMessage(view.BOOK_NUMBER);
                    adminService.deleteBook(defineOption(1,
                            adminService.getUserDAO().getAll().size()) - 1);
                    view.printMessage(view.BOOK_LIST);
                    view.show(view.BOOK_LIST, bookConverter);
                    break;
                case 3:
                    break;
                case 4:
                    //createLibrarian();
                    break;
                case 5: break;
                case 6:
                    //changeUserStatus();
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
        Scanner scanner = new Scanner(System.in);
        for (int i = start; i <= end; i++) {
            options.add(i);
        }
        while (true) {
            String userOption = scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);
        String[] info = new String[4];
        view.printMessage(view.BOOK_NAME);
        info[0] = scanner.nextLine();
        view.printMessage(view.BOOK_AUTHOR);
        info[1] = scanner.nextLine();
        view.printMessage(view.BOOK_EDITION);
        info[2] = scanner.nextLine();
        view.printMessage(view.BOOK_DATA);
        while (true) {
            String data = scanner.nextLine();
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
}
