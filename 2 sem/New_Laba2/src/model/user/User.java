package model.user;

import java.util.Objects;

public class User {

    private String login;
    private String password;
    private UserType role;
    private boolean blocked;

    public User(String login, String password,
                UserType role) {
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

    public boolean getBlocked() {
        return blocked;
    }

    public void setBlocked() {
        blocked = !blocked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getLogin(), user.getLogin()) &&
                Objects.equals(getPassword(), user.getPassword());
    }

}
