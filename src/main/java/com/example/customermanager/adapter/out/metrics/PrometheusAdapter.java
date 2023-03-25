package com.example.customermanager.adapter.out.metrics;

import com.example.customermanager.application.out.IPrometheusAdapter;
import com.example.customermanager.commons.enums.MetricType;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrometheusAdapter implements IPrometheusAdapter {

    private final MeterRegistry registry;

    @Override
    public void count(MetricType metricType) {
        registry.counter(metricType.getType()).increment();
    }

    @Override
    public void count(MetricType metricType, String... tags) {
        registry.counter(metricType.getType(), tags).increment();
    }
}
