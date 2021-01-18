package com.example.JavaLab4.model.user;

import java.util.Objects;

public class User {

    private int id;
    private String login;
    private String password;
    private UserType role;
    private boolean blocked;

    public User(int id, String login, String password,
                UserType role, boolean blocked) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.blocked = blocked;
    }

    public User(int id, String login, String password,
                UserType role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        blocked = false;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public UserType getRole() {
        return role;
    }

    public int getId() {
        return id;
    }

    public boolean getBlocked() {
        return blocked;
    }

    public void setBlocked() {
        blocked = !blocked;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        User user = (User) o;
        return Objects.equals(getLogin(), user.getLogin()) &&
                Objects.equals(getPassword(), user.getPassword());
    }

}
