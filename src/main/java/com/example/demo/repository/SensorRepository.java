package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Long> {

    Optional<Sensor> findBySensorCode(String code);

    List<Sensor> findByLocation_Region(String region);
}
