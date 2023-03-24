package com.example.customermanager.domain;

import com.example.customermanager.commons.ObjectValidator;
import com.example.customermanager.commons.enums.CustomerStatus;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

@SuperBuilder
@Getter
@ToString
public class Customer extends BaseDomain {

    @Size(min = 2)
    @NotBlank
    private final String name;

    @NotBlank
    @Size(min = 2)
    private final String fullName;

    @NotBlank
    @Size(min = 2, max = 10)
    private final String genre;

    @NotNull
    private final LocalDateTime dateBirth;

    @NotBlank
    @Size(min = 10)
    private final String educationalLevel;

    @NotBlank
    @Size(min = 2)
    private final String motherName;

    @NotNull
    private Address address;

    @NotBlank
    @Size(min = 11)
    private final String phone;

    @NotBlank
    @Size(min = 2)
    private final String document;

    @NotNull
    private List<Account> listAccount;

    private CustomerStatus status;

    public Customer check() {
        listAccount.forEach(Account::check);
        address.check();

        ObjectValidator.validate(this);
        return this;
    }

    public void setStatus(CustomerStatus status) {
        this.status = status;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setAccount(List<Account> listAccount) {
        this.listAccount = listAccount;
    }
}
