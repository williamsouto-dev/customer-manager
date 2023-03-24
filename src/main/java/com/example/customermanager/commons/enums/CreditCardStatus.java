package com.example.customermanager.commons.enums;

import lombok.Getter;

@Getter
public enum CreditCardStatus {

    ACTIVE("A"),
    INACTIVE("I"),
    DEFAULTER("D"),
    BLOCKED("B");

    private final String status;

    CreditCardStatus(String status) {
        this.status = status;
    }
}
