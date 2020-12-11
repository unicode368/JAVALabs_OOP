package controller;

import controller.Autorization.ReaderRegistration;
import controller.Autorization.UserAutorization;
import model.ObjectType;
import model.exceptions.BlockedUserException;
import model.exceptions.InvalidLoginInfo;
import model.service.LibrarianService;
import model.service.ReaderService;
import model.service.Service;
import model.user.Reader;
import model.user.User;
import model.user.UserType;
import view.GeneralView;

import java.util.Scanner;

public class GeneralController extends Controller {

    private GeneralView view;
    private Converter book_converter;
    private UserAutorization userAutorization;
    private ReaderRegistration readerRegistration;
    private Service service;


    public GeneralController() {
        view = new GeneralView();
        book_converter = new Converter(ObjectType.BOOK);
        userAutorization = new UserAutorization();
        readerRegistration = new ReaderRegistration();
        service = new Service();
    }

    public void execute() {
        while (true) {
            view.print(view.WELCOME);
            switch (defineOption(0,4)) {
                case 0:
                    System.exit(0);
                case 1: sign_up();
                    break;
                case 2: login();
                    break;
                case 3: view.show(book_converter);
                    break;
                case 4:
                    break;
            }
        }
    }

    private void login() {
        while (true) {
            String[] loginAndPassword = getLoginAndPassword();
            try {
                userAutorization.login(loginAndPassword[0], loginAndPassword[1]);
            } catch (InvalidLoginInfo e) {
                view.printError(e.getMessage());
                continue;
            } catch (BlockedUserException e) {
                view.printError(e.getMessage());
                System.exit(1);
            }
            break;
        }
        User found = service.getUserTools().search(
                new User(getLoginAndPassword()[0],
                        getLoginAndPassword()[1]), service.getUserDAO().getAll());
        Validator.validateLoginAndPassword(found, "login");
        switch (found.getRole()) {
            case LIBRARIAN:
                service = new LibrarianService(found);
                service.execute();
                break;
            case READER:
                service = new ReaderService((Reader) found);
                service.execute();
                break;
            case ADMIN:
                AdminController controller = new AdminController(found);
                controller.execute();
                break;
        }
    }

    private void sign_up() {
        String[] loginAndPassword;
        while (true) {
            loginAndPassword = getLoginAndPassword();
            try {
                readerRegistration.signup(loginAndPassword[0], loginAndPassword[1]);
            } catch (InvalidLoginInfo e) {
                view.printError(e.getMessage());
                continue;
            }
            break;
        }
        User newUser = service.getUserTools().search(
                new User(getLoginAndPassword()[0],
                        getLoginAndPassword()[1]), service.getUserDAO().getAll());
        Validator.validateLoginAndPassword(newUser, "signup");
        Reader new_user = (Reader) new User(loginAndPassword[0],
                loginAndPassword[1], UserType.READER);
        service.getUserDAO().getAll().add(new_user);
//        readerService = new ReaderService(new_user);
//        readerService.execute();
    }

    private String[] getLoginAndPassword() {
        Scanner scan = new Scanner(System.in);
        String[] loginPassword = new String[2];
        view.printMessage(view.LOGIN);
        String login = scan.nextLine();
        loginPassword[0] = login;
        view.printMessage(view.PASSWORD);
        String password = scan.nextLine();
        loginPassword[1] = password;
        return loginPassword;
    }

}
