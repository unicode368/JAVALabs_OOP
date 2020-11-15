package controller.Autorization;

import controller.Validator;
import model.dao.UserDAO;
import model.user.Admin;
import model.user.Librarian;
import model.user.Reader;
import model.user.User;
import model.service.AdminService;
import model.service.LibrarianService;
import model.service.ReaderService;
import model.service.Service;
import util.Tools;

public class UserAutorization {

    private UserDAO dao;
    private Tools tools;
    private Service service;

    public UserAutorization() {
        dao = new UserDAO();
        tools = new Tools();
    }

    public void login(String login, String password) {
        User found = tools.searchUser(login, password, dao.getAll());
        Validator.validateLoginAndPassword(found);
        switch (found.getRole()) {
            case LIBRARIAN:
                service = new LibrarianService((Librarian) found);
                service.execute();
                break;
            case READER:
                service = new ReaderService((Reader) found);
                service.execute();
                break;
            case ADMIN:
                service = new AdminService((Admin) found, dao);
                service.execute();
                break;
        }
    }

    public void logout(String login, String password) {

    }


}
