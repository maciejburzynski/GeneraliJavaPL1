package pl.generali.Spring.security;

import lombok.Data;

@Data
public class AuthLoginRequest {

    private String username;
    private String password;

}
