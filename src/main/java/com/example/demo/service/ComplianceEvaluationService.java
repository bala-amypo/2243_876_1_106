package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplianceEvaluationService {

    private final SensorReadingRepository readingRepo;
    private final ComplianceThresholdRepository thresholdRepo;
    private final ComplianceLogRepository logRepo;

    public ComplianceEvaluationService(
            SensorReadingRepository r,
            ComplianceThresholdRepository t,
            ComplianceLogRepository l) {

        this.readingRepo = r;
        this.thresholdRepo = t;
        this.logRepo = l;
    }

    public ComplianceLog evaluateReading(Long readingId) {

        SensorReading reading = readingRepo.findById(readingId)
                .orElseThrow(() -> new ResourceNotFoundException("Reading"));

        ComplianceThreshold threshold =
                thresholdRepo.findBySensorType(reading.getSensor().getSensorType());

        if (threshold == null) {
            throw new ResourceNotFoundException("Threshold");
        }

        String status =
                (reading.getReadingValue() < threshold.getMinValue()
                        || reading.getReadingValue() > threshold.getMaxValue())
                        ? threshold.getSeverityLevel()
                        : "NORMAL";

        reading.setStatus(status);

        ComplianceLog log = new ComplianceLog();
        log.setSensorReading(reading);
        log.setThresholdUsed(threshold);
        log.setStatusAssigned(status);

        return logRepo.save(log);
    }

    public List<ComplianceLog> getLogsByReading(Long readingId) {
        return List.of(logRepo.findBySensorReading_Id(readingId));
    }

    public ComplianceLog getLog(Long id) {
        return logRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Log"));
    }
}
