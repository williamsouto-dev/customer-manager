package com.example.customermanager.adapter.out.kafka.dto;

import com.example.customermanager.domain.Document;
import lombok.Data;

@Data
public class AnalysisEvent {

    private Long idtCustomer;
    private String storage;
    private String fileName;
    private String hash;
    private String pathFile;

    public static AnalysisEvent from(Document document) {
        AnalysisEvent analysisEvent = new AnalysisEvent();
        analysisEvent.idtCustomer = document.getIdtCustomer();
        analysisEvent.storage = document.getStorage();
        analysisEvent.fileName = document.getFileName();
        analysisEvent.hash = document.getHash();
        analysisEvent.pathFile = document.getPathFile();
        return analysisEvent;
    }
}
