package com.example.customermanager.adapter.in.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddressRequest {

    private final String street;
    private final Integer number;
    private final String district;
    private final String city;
    private final String state;
}
