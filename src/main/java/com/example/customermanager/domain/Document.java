package com.example.customermanager.domain;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@ToString
public class Document extends BaseDomain {

    private Long idtCustomer;
    private String storage;
    private String fileName;
    private String hash;
    private String pathFile;
    private Boolean flgSend;
}
