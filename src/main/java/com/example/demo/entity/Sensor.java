package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sensors")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String sensorCode;

    private String sensorType;

    @ManyToOne
    private Location location;

    private LocalDateTime installedAt;

    private Boolean isActive = true;

    @OneToMany(mappedBy = "sensor")
    private List<SensorReading> readings;

    public Sensor() {}

    public Sensor(String sensorCode, String sensorType,
                  Location location, LocalDateTime installedAt,
                  Boolean isActive) {
        this.sensorCode = sensorCode;
        this.sensorType = sensorType;
        this.location = location;
        this.installedAt = installedAt;
        this.isActive = isActive;
    }

    public Long getId() { return id; }
    public String getSensorCode() { return sensorCode; }
    public String getSensorType() { return sensorType; }
    public Location getLocation() { return location; }
    public LocalDateTime getInstalledAt() { return installedAt; }
    public Boolean getIsActive() { return isActive; }

    public void setId(Long id) { this.id = id; }
    public void setSensorCode(String sensorCode) { this.sensorCode = sensorCode; }
    public void setSensorType(String sensorType) { this.sensorType = sensorType; }
    public void setLocation(Location location) { this.location = location; }
    public void setInstalledAt(LocalDateTime installedAt) { this.installedAt = installedAt; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
}
