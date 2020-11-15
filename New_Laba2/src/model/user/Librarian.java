package model.user;

public class Librarian extends User {

    public Librarian(String login, String password) {
        super(login, password, UserType.LIBRARIAN);
    }


}
