package com.example.customermanager.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import java.time.LocalDateTime;

@SuperBuilder
@Data
public class BaseDomain {

    private Long id;
    private LocalDateTime datCreate;
    private LocalDateTime datUpdate;
}
