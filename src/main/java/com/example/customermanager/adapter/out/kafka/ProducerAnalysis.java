package com.example.customermanager.adapter.out.kafka;

import com.example.customermanager.adapter.out.kafka.dto.AnalysisEvent;
import com.example.customermanager.application.out.IFraudAnalysisIntegration;
import com.example.customermanager.domain.Document;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProducerAnalysis implements IFraudAnalysisIntegration {

    @Value("${spring.kafka.producer.topic}")
    private String topic;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void sendAnalysis(Document document) {
        log.info("ProducerAnalysis.sendAnalysis document={}", document);

        try {
            AnalysisEvent message = AnalysisEvent.from(document);
            this.kafkaTemplate.send(topic, message);
            this.kafkaTemplate.flush();
        } catch (Exception e) {
            log.error("ProducerAnalysis.sendAnalysis error send message kafka. error={}", e.getMessage());
        }
    }
}
