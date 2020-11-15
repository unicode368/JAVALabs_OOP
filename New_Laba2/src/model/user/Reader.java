package model.user;

public class Reader extends User{

    private int fine;

    public Reader(String login, String password) {
        super(login, password, UserType.READER);
        fine = 0;
    }

    public int getFine() {
        return fine;
    }

    public void setFine() {

    }

}
