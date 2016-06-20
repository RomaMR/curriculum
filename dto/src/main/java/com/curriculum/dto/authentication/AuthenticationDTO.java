package com.curriculum.dto.authentication;

public class AuthenticationDTO {
    
    private String email;

    private String password;

    public AuthenticationDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}
