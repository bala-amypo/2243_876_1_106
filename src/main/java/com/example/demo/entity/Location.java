package com.example.demo.entity;

import jarkata.persistence.*;

@Entity
public class Location {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(unique = true)
private String locationName;


private String description;


private String region;


private LocalDateTime createdAt = LocalDateTime.now();
}