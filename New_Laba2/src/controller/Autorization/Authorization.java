package controller.Autorization;

import model.user.User;

public interface Authorization {
    User login(String login, String password);
    void logout(String login, String password);
}
