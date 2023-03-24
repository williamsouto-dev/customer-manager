package com.example.customermanager.commons.enums;

import lombok.Getter;

@Getter
public enum MetricType {

    COUNTER_REQUEST_CREATE_CUSTOMER("counter_request_create_customer", "Total count requests create customer."),
    COUNTER_REQUEST_CRATE_CREDITCARD("counter_request_create_creditcard", "Total count requests create customer."),
    COUNTER_ANALYSIS_STATUS("counter_analysis_status", "Total count analysis by status");

    private final String type;
    private final String description;

    MetricType(String type, String description) {
        this.type = type;
        this.description = description;
    }
}
