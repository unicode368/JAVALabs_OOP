package model.user;

public class Admin extends User{

    public Admin(String login, String password) {
        super(login, password, UserType.ADMIN);
    }


 }
