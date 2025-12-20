package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String locationName;

    private String description;

    private String region;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "location")
    private List<Sensor> sensors;

    public Location() {}

    public Location(String locationName, String description,
                    String region, LocalDateTime createdAt) {
        this.locationName = locationName;
        this.description = description;
        this.region = region;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public String getLocationName() { return locationName; }
    public String getDescription() { return description; }
    public String getRegion() { return region; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setLocationName(String locationName) { this.locationName = locationName; }
    public void setDescription(String description) { this.description = description; }
    public void setRegion(String region) { this.region = region; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
