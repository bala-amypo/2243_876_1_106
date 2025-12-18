package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.ComplianceLog;

public interface ComplianceLogRepository extends JpaRepository<ComplianceLog, Long> {
    ComplianceLog findBySensorReading_Id(Long id);
}
