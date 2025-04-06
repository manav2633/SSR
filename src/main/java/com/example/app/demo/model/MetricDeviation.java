package com.example.app.demo.model;


import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Data
@Entity
public class MetricDeviation {
    @Id
    private String metricId;
    private String description;
    private String subQuestion;
    private String beforeVerification;
    private String afterVerification;
    private String remark;
}