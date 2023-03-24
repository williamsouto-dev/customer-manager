package com.example.customermanager.adapter.in.controller.dto;

import com.example.customermanager.commons.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AccountRequest {

    private final AccountType type;
    private final String username;
    private final String password;
    private final String email;
}
