package com.example.customermanager.application.out;

import com.example.customermanager.commons.enums.MetricType;

public interface IPrometheusAdapter {

    void registerCount(MetricType metricType);

    void registerCount(MetricType metricType, String... tags);
}
