package com.example.customermanager.adapter.in.controller.dto;

import lombok.Getter;
import lombok.ToString;
import java.time.LocalDateTime;

@Getter
@ToString
public class DocumentResponse {

    private Long id;
    private String storage;
    private String fileName;
    private String hash;
    private String pathFile;
    private Boolean flgSend;
    private LocalDateTime datCrate;
    private LocalDateTime datUpdate;
}
