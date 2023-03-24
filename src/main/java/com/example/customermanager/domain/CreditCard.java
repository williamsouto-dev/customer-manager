package com.example.customermanager.domain;

import com.example.customermanager.commons.ObjectValidator;
import com.example.customermanager.commons.enums.CreditCardStatus;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@SuperBuilder
@Getter
@ToString
public class CreditCard extends BaseDomain {

    @NotNull
    private final Long idtCustomer;

    @NotNull
    private final Long idtAccount;

    @NotBlank
    private final String printedName;

    @NotNull
    @Min(1)
    private final BigDecimal limit;

    @NotNull
    private final LocalDateTime expiration;

    private String number;
    private String cvv;
    private CreditCardStatus status;
    private Account account;
    private Customer customer;

    public CreditCard check() {
        ObjectValidator.validate(this);
        return this;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setStatus(CreditCardStatus status) {
        this.status = status;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
