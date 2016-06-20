package com.curriculum.dto.authentication;

public class AuthorizationDTO {

    private String id;

    private String fullName;

    private String role;

    public AuthorizationDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(final String role) {
        this.role = role;
    }
}
