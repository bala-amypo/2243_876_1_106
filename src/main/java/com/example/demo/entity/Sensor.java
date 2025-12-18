package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String sensorCode;

    private String sensorType;

    @ManyToOne
    private Location location;

    private LocalDateTime installedAt = LocalDateTime.now();

    private Boolean isActive = true;

    @PrePersist
    void validate() {
        if (sensorType == null || sensorType.isBlank()) {
            throw new IllegalArgumentException("sensorType");
        }
    }
}
