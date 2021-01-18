package com.example.JavaLab4.model.dao;

import com.example.JavaLab4.model.user.Reader;
import com.example.JavaLab4.model.user.User;
import com.example.JavaLab4.model.user.UserType;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO implements DAO {

    private Connection db;

    public UserDAO() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        db = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library",
                "postgres", "Sobak@234");
    }

    @Override
    public ArrayList<User> getAll() throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        Statement statement = db.createStatement();
        ResultSet query = statement.executeQuery("SELECT * FROM users");
        while (query.next()) {
            if (query.getString("role").equals("librarian")) {
                users.add(new User(query.getInt("id"),
                        query.getString("login"),
                        query.getString("password"),
                        UserType.LIBRARIAN,
                        query.getBoolean("blocked")));
            } else if (query.getString("role").equals("admin")) {
                users.add(new User(query.getInt("id"),
                        query.getString("login"),
                        query.getString("password"),
                        UserType.ADMIN,
                        query.getBoolean("blocked")));
            } else {
                users.add(new Reader(query.getInt("id"),
                        query.getString("login"),
                        query.getString("password"),
                        query.getBoolean("blocked")));
            }
        }
        return users;
    }

    public void add(User user) {
//        userBase.getUsers().add(user);
    }

    @Override
    public User get(int i) {
//        return userBase.getUsers().get(i);
        return null;
    }

    public User get(String login, String password) throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        String query = "SELECT * FROM users WHERE login=? AND password=?";
        PreparedStatement ps = db.prepareStatement(query);
        ps.setString(1, login);
        ps.setString(2, password);
        ResultSet user = ps.executeQuery();
        while (user.next()) {
            if (user.getString("role").equals("librarian")) {
                users.add(new User(user.getInt("id"),
                        user.getString("login"),
                        user.getString("password"),
                        UserType.LIBRARIAN,
                        user.getBoolean("blocked")));
            } else if (user.getString("role").equals("admin")) {
                users.add(new User(user.getInt("id"),
                        user.getString("login"),
                        user.getString("password"),
                        UserType.ADMIN,
                        user.getBoolean("blocked")));
            } else {
                    users.add(new Reader(user.getInt("id"),
                            user.getString("login"),
                            user.getString("password"),
                            user.getBoolean("blocked")));
            }
        }
        return users.get(0);
    }

    @Override
    public void set() {

    }
}
