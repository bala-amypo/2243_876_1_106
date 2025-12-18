package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Location;
import com.example.demo.entity.Sensor;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.SensorRepository;
import com.example.demo.service.SensorService;

@Service
public class SensorServiceImpl implements SensorService {

    private final SensorRepository sensorRepository;
    private final LocationRepository locationRepository;

    // REQUIRED constructor order
    public SensorServiceImpl(SensorRepository sensorRepository,
                             LocationRepository locationRepository) {
        this.sensorRepository = sensorRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public Sensor createSensor(Long locationId, Sensor sensor) {

        if (sensor.getSensorType() == null) {
            throw new IllegalArgumentException("sensorType");
        }

        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        sensor.setLocation(location);
        sensor.setInstalledAt(LocalDateTime.now());
        sensor.setActive(true);

        return sensorRepository.save(sensor);
    }

    @Override
    public Sensor getSensor(Long id) {
        return sensorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    @Override
    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }
}
