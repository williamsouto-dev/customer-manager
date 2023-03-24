package com.example.customermanager.adapter.in.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CreditCardRequest {

    private final Long idtCustomer;
    private final Long idtAccount;
    private final String printedName;
    private final BigDecimal limit;
    private final LocalDateTime expiration;
}
