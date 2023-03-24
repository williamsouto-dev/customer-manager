package com.example.customermanager.domain;

import com.example.customermanager.commons.ObjectValidator;
import com.example.customermanager.commons.enums.AccountType;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@SuperBuilder
public class Account extends BaseDomain {

    @NotNull
    private final AccountType type;

    @NotBlank
    @Size(min = 2)
    private final String username;

    @NotBlank
    @Size(min = 2)
    private final String password;

    @NotBlank
    @Size(min = 2)
    private final String email;

    private Customer customer;
    private Long idtCustomer;
    private Boolean active;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setIdtCustomer(Long idtCustomer) {
        this.idtCustomer = idtCustomer;
    }

    public void check() {
        ObjectValidator.validate(this);
    }
}
