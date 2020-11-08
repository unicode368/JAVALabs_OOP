package model.user;

import model.Book;

public class Admin extends User{

    Admin(String login, String password) {
        super(login, password, Admin.class.getName());
    }


 }
