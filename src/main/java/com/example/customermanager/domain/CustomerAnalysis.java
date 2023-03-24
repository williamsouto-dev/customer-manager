package com.example.customermanager.domain;

import com.example.customermanager.commons.ObjectValidator;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@ToString
public class CustomerAnalysis {

    @NotNull
    private Long idtCustomer;

    @NotNull
    private Boolean status;

    public CustomerAnalysis check() {
        ObjectValidator.validate(this);
        return this;
    }
}
