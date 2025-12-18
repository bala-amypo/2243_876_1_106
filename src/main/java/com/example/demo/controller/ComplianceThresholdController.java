package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.service.ComplianceThresholdService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/thresholds")
@Tag(name = "Thresholds")
public class ComplianceThresholdController {

    private final ComplianceThresholdService service;

    public ComplianceThresholdController(ComplianceThresholdService service) {
        this.service = service;
    }

    @PostMapping
    public ComplianceThreshold create(@RequestBody ComplianceThreshold threshold) {
        return service.createThreshold(threshold);
    }

    @GetMapping
    public List<ComplianceThreshold> getAll() {
        return service.getAllThresholds();
    }

    @GetMapping("/{id}")
    public ComplianceThreshold getById(@PathVariable Long id) {
        return service.getThreshold(id);
    }

    @GetMapping("/type/{sensorType}")
    public ComplianceThreshold getBySensorType(@PathVariable String sensorType) {
        return service.getThresholdBySensorType(sensorType);
    }
}
