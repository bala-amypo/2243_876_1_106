package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SensorReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Sensor sensor;

    private Double readingValue;

    private LocalDateTime readingTime;

    private String status;

    @PrePersist
    void validate() {
        if (readingValue == null) {
            throw new IllegalArgumentException("readingvalue");
        }
        if (readingTime.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("future");
        }
    }
}
