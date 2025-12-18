package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Sensor;
import com.example.demo.service.SensorService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/sensors")
@Tag(name = "Sensors")
public class SensorController {

    private final SensorService service;

    public SensorController(SensorService service) {
        this.service = service;
    }

    @PostMapping("/{locationId}")
    public Sensor create(@PathVariable Long locationId,
                         @RequestBody Sensor sensor) {
        return service.createSensor(locationId, sensor);
    }

    @GetMapping
    public List<Sensor> getAll() {
        return service.getAllSensors();
    }

    @GetMapping("/{id}")
    public Sensor getById(@PathVariable Long id) {
        return service.getSensor(id);
    }
}
