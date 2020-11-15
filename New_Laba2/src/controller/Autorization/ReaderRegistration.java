package controller.Autorization;

import controller.Validator;
import model.Action;
import model.dao.UserDAO;
import model.service.ReaderService;
import model.user.Reader;
import model.user.User;
import util.Tools;

public class ReaderRegistration {

    private UserDAO dao;
    private Tools tools;
    private ReaderService readerService;

    public ReaderRegistration() {
        dao = new UserDAO();
        tools = new Tools();
    }

    public void signup(String login, String password) {
        User found = tools.searchUser(login, password, dao.getAll());
        Validator.validateLoginAndPassword(found, Action.SIGNUP);
        dao.getAll().add(found);
        readerService = new ReaderService((Reader) found);
        readerService.execute();
    }
}
