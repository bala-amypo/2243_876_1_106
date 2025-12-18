package com.example.demo.service;

import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ComplianceThresholdRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplianceThresholdService {

    private final ComplianceThresholdRepository repo;

    public ComplianceThresholdService(ComplianceThresholdRepository repo) {
        this.repo = repo;
    }

    public ComplianceThreshold createThreshold(ComplianceThreshold t) {
        return repo.save(t);
    }

    public ComplianceThreshold getThreshold(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Threshold"));
    }

    public ComplianceThreshold getThresholdBySensorType(String sensorType) {
        ComplianceThreshold t = repo.findBySensorType(sensorType);
        if (t == null) {
            throw new ResourceNotFoundException("Threshold");
        }
        return t;
    }

    public List<ComplianceThreshold> getAllThresholds() {
        return repo.findAll();
    }
}
