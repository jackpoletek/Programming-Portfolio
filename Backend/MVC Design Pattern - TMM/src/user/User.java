package user;

import registerStrategy.RegisterStrategy;
import validator.InputValidator;

import java.util.Objects;

public abstract class User {

    private int id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    RegisterStrategy registerStrategy;
    private final InputValidator inputValidator = new InputValidator();

    public void executeRegister(User user) {
        registerStrategy.register(user);
    }

    public void changeRegisterBehavior(RegisterStrategy rb) {
        registerStrategy = rb;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User {" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getLogin().equals(user.getLogin()) && getPassword().equals(user.getPassword()) && getFirstName().equals(user.getFirstName()) && getLastName().equals(user.getLastName()) && getEmail().equals(user.getEmail());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getPassword(), getFirstName(), getLastName(), getEmail());
    }
}
