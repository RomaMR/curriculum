package com.curriculum.exception;

public class AuthenticationException  extends RuntimeException {

    private String value;

    public AuthenticationException(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}