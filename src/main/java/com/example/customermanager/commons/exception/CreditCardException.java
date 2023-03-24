package com.example.customermanager.commons.exception;

public class CreditCardException extends Exception {

    private final int code;
    private final String message;

    public CreditCardException(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }
}
