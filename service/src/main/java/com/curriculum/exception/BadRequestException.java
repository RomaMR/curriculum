package com.curriculum.exception;

public class BadRequestException  extends RuntimeException {

    private String value;

    public BadRequestException(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}