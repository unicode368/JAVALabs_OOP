package model.dao;

import model.user.Admin;
import model.user.Librarian;
import model.user.Reader;
import model.user.User;

import java.util.ArrayList;

public class UserBase {

    private static ArrayList<User> users;

     public UserBase() {
         if (users == null) {
             users = new ArrayList<>();
             Admin admin = new Admin("admin", "admin");
             users.add(admin);
             Reader reader = new Reader("reader", "reader");
             users.add(reader);
             Librarian librarian = new Librarian("librarian", "librarian");
             users.add(librarian);
         }
    }

    public void add(User user) {

    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User getUser(String login, String password) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getLogin().equals(login) &&
                         users.get(i).getPassword().equals(password)) {
                return users.get(i);
            }
        }
        return null;
    }

}
