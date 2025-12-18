package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.SensorReading;
import com.example.demo.service.SensorReadingService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/readings")
@Tag(name = "Sensor Readings")
public class SensorReadingController {

    private final SensorReadingService service;

    public SensorReadingController(SensorReadingService service) {
        this.service = service;
    }

    @PostMapping("/{sensorId}")
    public SensorReading submit(@PathVariable Long sensorId,
                                @RequestBody SensorReading reading) {
        return service.submitReading(sensorId, reading);
    }

    @GetMapping("/sensor/{sensorId}")
    public List<SensorReading> getBySensor(@PathVariable Long sensorId) {
        return service.getReadingsBySensor(sensorId);
    }

    @GetMapping("/{id}")
    public SensorReading getById(@PathVariable Long id) {
        return service.getReading(id);
    }
}
