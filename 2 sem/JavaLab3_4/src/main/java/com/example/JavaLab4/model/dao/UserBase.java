package com.example.JavaLab4.model.dao;

import com.example.JavaLab4.model.Date;
import com.example.JavaLab4.model.Order;
import com.example.JavaLab4.model.user.Reader;
import com.example.JavaLab4.model.user.User;
import com.example.JavaLab4.model.user.UserType;

import java.util.ArrayList;

public class UserBase {

     private static ArrayList<User> users;

     public UserBase() {
         if (users == null) {
             users = new ArrayList<>();
             User admin = new User(1,"admin", "admin", UserType.ADMIN);
             users.add(admin);
             User librarian = new User(2,"librarian", "librarian", UserType.LIBRARIAN);
             users.add(librarian);
             ArrayList<Order> orders = new ArrayList<>();
             Reader reader = new Reader( 3,"reader", "reader", orders);
             orders.add(new Order(3, 2,
                     2, new Date("08.1.2021"), new Date("21.1.2021")));
             orders.add(new Order(3, 2,
                     4, new Date("06.1.2021"), new Date("17.1.2021")));
             orders.add(new Order(3, 2,
                     1, new Date("02.1.2021"), new Date("30.1.2021")));
             reader.setOrders(orders);
             users.add(reader);
         }
    }

    public void add(User user) {

    }

    public ArrayList<User> getUsers() {
        return users;
    }

}
