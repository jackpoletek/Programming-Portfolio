//package com.array.onlineshopspring.request;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.ToString;
//
//import java.util.Objects;
//
//@Getter
//@AllArgsConstructor
//@ToString
//public class RegistrationRequest {
//
//    private final String firstName;
//    private final String lastName;
//    private final String email;
//    private final String login;
//    private final String userPassword;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof RegistrationRequest that)) return false;
//        return firstName.equals(that.firstName) && lastName.equals(that.lastName) && email.equals(that.email) && login.equals(that.login) && userPassword.equals(that.userPassword);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(firstName, lastName, email, login, userPassword);
//    }
//}
