package com.example.customermanager.domain;

import com.example.customermanager.commons.ObjectValidator;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuperBuilder
@Getter
public class Address extends BaseDomain {

    @NotBlank
    @Size(min = 2)
    private final String street;

    @Min(0)
    @NotNull
    private final Integer number;

    @NotBlank
    @Size(min = 2)
    private final String district;

    @NotBlank
    @Size(min = 2)
    private final String city;

    @NotBlank
    @Size(min = 2)
    private final String state;

    private Long idtCustomer;

    public void check() {
        ObjectValidator.validate(this);
    }
}
