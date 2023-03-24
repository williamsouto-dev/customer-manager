package com.example.customermanager.adapter.in.controller.dto;

import com.example.customermanager.commons.enums.CustomerStatus;
import com.example.customermanager.domain.Account;
import com.example.customermanager.domain.Address;
import lombok.Builder;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
public class CustomerResponse implements Serializable {

    private final Long id;
    private final String name;
    private final String fullName;
    private final String genre;
    private final LocalDateTime dateBirth;
    private final String educationalLevel;
    private final String motherName;
    private final Address address;
    private final String phone;
    private final String document;
    private final List<Account> listAccount;
    private final CustomerStatus status;
}
