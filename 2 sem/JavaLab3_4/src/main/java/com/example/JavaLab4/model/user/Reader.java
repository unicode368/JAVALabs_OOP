package com.example.JavaLab4.model.user;

import com.example.JavaLab4.model.Order;

import java.util.ArrayList;

public class Reader extends User {

    private int fine;
    private ArrayList<Order> orders;

    public Reader(int id, String login,
                  String password, boolean blocked) {
        super(id, login, password, UserType.READER, blocked);
        fine = 0;
    }

    public int getFine() {
        return fine;
    }

    public void setFine() {

    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }
}
