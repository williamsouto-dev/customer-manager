package com.example.customermanager.application.out;

import com.example.customermanager.commons.enums.MetricType;

public interface IPrometheusAdapter {

    void count(MetricType metricType);

    void count(MetricType metricType, String... tags);
}
