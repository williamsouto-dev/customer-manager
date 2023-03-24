package com.example.customermanager.commons.enums;

import lombok.Getter;

@Getter
public enum ErrorException {

    REGISTER_NOT_FOUND("Register not found", 3000),
    CREDIT_CARD_ERROR("Error create credit card", 4000),
    ERROR_APPLY_SECURITY("Error applying security", 4001);

    private final String message;
    private final int code;

    ErrorException(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
