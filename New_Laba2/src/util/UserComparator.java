package util;

import model.user.User;

public class UserComparator {

    public int compare(Object o1, Object o2) {
        return 0;
    }

    public boolean equal(String login, String password, User u1) {
        if (u1.getLogin().equals(login) &&
                u1.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
