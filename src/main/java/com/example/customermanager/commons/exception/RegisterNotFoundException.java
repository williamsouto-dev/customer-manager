package com.example.customermanager.commons.exception;

public class RegisterNotFoundException extends Exception {

    private final int code;
    private final String message;

    public RegisterNotFoundException(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }
}
