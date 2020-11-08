package model.user;

import model.Book;
import model.Storage;

public class Librarian extends User {

    Librarian(String login, String password) {
        super(login, password, Librarian.class.getName());
    }


}
