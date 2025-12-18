package com.example.demo.entity;

import jarkata.persistence.*;

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