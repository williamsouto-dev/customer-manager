package com.example.customermanager.adapter.in.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
public class CreditCardResponse {

    private final Long idtCustomer;
    private final Long idtAccount;
    private final String printedName;
    private final BigDecimal limit;
    private final LocalDateTime expiration;
    private String number;

    @ToString.Include(name = "number")
    private String sensitiveFieldMasker() {
        return getMask();
    }

    public void applyMaskfieldNumber() {
        this.number = getMask();
    }

    private String getMask() {
        return "**** **** **** ".concat(number.substring(11));
    }
}
