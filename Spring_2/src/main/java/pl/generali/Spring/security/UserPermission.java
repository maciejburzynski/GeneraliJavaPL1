package pl.generali.Spring.security;

import lombok.Getter;

@Getter
public enum UserPermission {
    REST_API_READ("rest-api:read"),
    TOKEN_READ("rest-api:read"),
    REST_API_WRITE("rest-api:write");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }
}
