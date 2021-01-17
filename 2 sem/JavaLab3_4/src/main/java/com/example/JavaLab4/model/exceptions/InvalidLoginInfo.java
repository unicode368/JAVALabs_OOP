package com.example.JavaLab4.model.exceptions;

public class InvalidLoginInfo extends RuntimeException {
    public InvalidLoginInfo(String message) {
        super(message);
    }
}
