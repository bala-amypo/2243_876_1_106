package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "compliance_threshold")
public class ComplianceThreshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String sensorType;

    @Column(nullable = false)
    private Double minValue;

    @Column(nullable = false)
    private Double maxValue;

    @Column(nullable = false)
    private String severityLevel;

    private LocalDateTime createdAt = LocalDateTime.now();

    // ===== VALIDATION =====
    @PrePersist
    @PreUpdate
    public void validate() {

        if (sensorType == null || sensorType.isBlank()) {
            throw new IllegalArgumentException("sensorType");
        }

        if (minValue == null || maxValue == null) {
            throw new IllegalArgumentException("minvalue");
        }

        if (minValue >= maxValue) {
            throw new IllegalArgumentException("minvalue");
        }

        if (severityLevel == null || severityLevel.isBlank()) {
            throw new IllegalArgumentException("severity required");
        }
    }

    // ===== GETTERS & SETTERS =====
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public Double getMinValue() {
        return minValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(String severityLevel) {
        this.severityLevel = severityLevel;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
