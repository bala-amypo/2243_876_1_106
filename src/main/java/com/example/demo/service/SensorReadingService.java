package com.example.demo.service;

import com.example.demo.entity.Sensor;
import com.example.demo.entity.SensorReading;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SensorReadingRepository;
import com.example.demo.repository.SensorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SensorReadingService {

    private final SensorReadingRepository readingRepo;
    private final SensorRepository sensorRepo;

    public SensorReadingService(SensorReadingRepository r, SensorRepository s) {
        this.readingRepo = r;
        this.sensorRepo = s;
    }

    public SensorReading submitReading(Long sensorId, SensorReading reading) {
        Sensor sensor = sensorRepo.findById(sensorId)
                .orElseThrow(() -> new ResourceNotFoundException("Sensor"));

        reading.setSensor(sensor);
        reading.setReadingTime(LocalDateTime.now());
        return readingRepo.save(reading);
    }

    public SensorReading getReading(Long id) {
        return readingRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reading"));
    }

    public List<SensorReading> getReadingsBySensor(Long sensorId) {
        return readingRepo.findBySensor_Id(sensorId);
    }
}
