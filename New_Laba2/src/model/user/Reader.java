package model.user;

public class Reader extends User{

    private int fine;

    Reader(String login, String password) {
        super(login, password, Reader.class.getName());
        fine = 0;
    }

    public int getFine() {
        return fine;
    }

    public void setFine() {

    }

}
