package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Sensor;
import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
    Sensor findBySensorCode(String code);
    List<Sensor> findByLocation_Region(String region);
}
