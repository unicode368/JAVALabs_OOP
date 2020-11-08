package controller.Autorization;

import controller.Validator;
import model.user.User;
import model.user.UserBase;

public class UserAutorization implements Authorization {

    private UserBase userBase;

    public UserAutorization(UserBase userBase) {
        this.userBase = userBase;
    }

    @Override
    public User login(String login, String password) {
        Validator.validateLoginAndPassword(login, password, userBase);
        return userBase.getUser(login, password);
    }

    @Override
    public void logout(String login, String password) {

    }


}
