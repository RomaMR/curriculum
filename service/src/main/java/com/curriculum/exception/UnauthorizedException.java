package com.curriculum.exception;

public class UnauthorizedException extends RuntimeException {

    private String value;

    public UnauthorizedException(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
