package com.example.customermanager.commons.enums;

import lombok.Getter;

@Getter
public enum CustomerStatus {

    ACTIVE("A"),
    INACTIVE("I"),
    DEFAULTER("D"),
    BLOCKED("B");

    private final String status;

    CustomerStatus(String status) {
        this.status = status;
    }
}
