package com.example.JavaLab4.model.dao;

import com.example.JavaLab4.model.user.User;

import java.util.ArrayList;

public class UserDAO implements DAO {

    private UserBase userBase;

    public UserDAO() {
        userBase = new UserBase();
    }

    @Override
    public ArrayList<User> getAll() {
        return userBase.getUsers();
    }

    public void add(User user) {
        userBase.getUsers().add(user);
    }

    @Override
    public User get(int i) {
        return userBase.getUsers().get(i);
    }

    @Override
    public void set() {

    }
}
