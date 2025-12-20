package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "compliance_thresholds")
public class ComplianceThreshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String sensorType;

    private Double minValue;
    private Double maxValue;

    private String severityLevel;

    private LocalDateTime createdAt;

    public ComplianceThreshold() {}

    public ComplianceThreshold(String sensorType, Double minValue,
                               Double maxValue, String severityLevel,
                               LocalDateTime createdAt) {
        this.sensorType = sensorType;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.severityLevel = severityLevel;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public String getSensorType() { return sensorType; }
    public Double getMinValue() { return minValue; }
    public Double getMaxValue() { return maxValue; }
    public String getSeverityLevel() { return severityLevel; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setSensorType(String sensorType) { this.sensorType = sensorType; }
    public void setMinValue(Double minValue) { this.minValue = minValue; }
    public void setMaxValue(Double maxValue) { this.maxValue = maxValue; }
    public void setSeverityLevel(String severityLevel) { this.severityLevel = severityLevel; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
