package com.example.demo.entity;

import jarkata.persistence.*;

@Entity
public class SensorReading {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@ManyToOne
private Sensor sensor;


private Double readingValue;


private LocalDateTime readingTime = LocalDateTime.now();


private String status;
}