package com.array.onlineshopspring.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private String resourceName;
    private String enteredValue;
    private Integer value;
    private String login;
    private String email;
    private List orders;

    public ResourceNotFoundException(String resourceName, String enteredValue, Integer value) {
        super(String.format("%s with id %s not found: %d", resourceName, enteredValue, value));
        this.resourceName = resourceName;
        this.enteredValue = enteredValue;
        this.value = value;
    }

    public ResourceNotFoundException(String resourceName, String email) {
        super(String.format("%s with email \"%s\" not found", resourceName, email));
        this.resourceName = resourceName;
        this.email = email;
    }

    public ResourceNotFoundException(String email) {
        super(String.format("The entered email is not valid: \"%s\"", email));
        this.email = email;
    }
}
