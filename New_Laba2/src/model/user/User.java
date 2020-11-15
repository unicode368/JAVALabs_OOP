package model.user;

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
}
