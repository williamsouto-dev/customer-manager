package com.example.customermanager.adapter.in.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
@AllArgsConstructor
public class CustomerRequest {

    private final String name;
    private final String fullName;
    private final String genre;
    private final LocalDateTime dateBirth;
    private final String educationalLevel;
    private final String motherName;
    private final AddressRequest address;
    private final String phone;
    private final String document;
    private final List<AccountRequest> listAccount;
}
