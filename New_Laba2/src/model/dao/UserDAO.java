package model.dao;

import model.user.User;

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


    @Override
    public User get(int i) {
        return null;
    }

    @Override
    public void set() {

    }
}
