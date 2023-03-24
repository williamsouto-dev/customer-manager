package com.example.customermanager.application.out;

import com.example.customermanager.domain.Document;

public interface IFraudAnalysisIntegration {

    void sendAnalysis(Document document);
}
