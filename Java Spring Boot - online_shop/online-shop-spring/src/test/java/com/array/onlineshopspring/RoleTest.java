package com.array.onlineshopspring;

import lombok.*;

@Getter
@ToString
public enum RoleTest {

    ADMIN("admin"),
    USER("user");
    private final String role;

    RoleTest(String role) {
        this.role = role;
    }

    public String getAuthority() {
        return role;
    }
}
