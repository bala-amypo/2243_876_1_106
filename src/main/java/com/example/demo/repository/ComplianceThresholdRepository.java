package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.ComplianceThreshold;

public interface ComplianceThresholdRepository extends JpaRepository<ComplianceThreshold, Long> {
    ComplianceThreshold findBySensorType(String type);
}
