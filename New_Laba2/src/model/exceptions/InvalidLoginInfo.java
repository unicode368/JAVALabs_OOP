package model.exceptions;

public class InvalidLoginInfo extends RuntimeException {
    public InvalidLoginInfo(String message) {
        super(message);
    }
}
