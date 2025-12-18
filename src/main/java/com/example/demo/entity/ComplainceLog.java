package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ComplianceLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private SensorReading sensorReading;

    @ManyToOne
    private ComplianceThreshold thresholdUsed;

    private String statusAssigned;

    private String remarks;

    private LocalDateTime loggedAt = LocalDateTime.now();
}
