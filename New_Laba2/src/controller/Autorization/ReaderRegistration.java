package controller.Autorization;

import controller.Validator;
import model.Action;
import model.dao.UserDAO;
import model.service.ReaderService;
import model.user.Reader;
import model.user.User;
import model.user.UserType;
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
        Validator.validateLoginAndPassword(tools.searchUser(login,
                password, dao.getAll()), Action.SIGNUP);
        Reader new_user = new Reader(login, password);
        dao.getAll().add(new_user);
        readerService = new ReaderService(new_user);
        readerService.execute();
    }
}
