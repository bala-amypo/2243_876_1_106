package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ComplianceLog;
import com.example.demo.service.ComplianceEvaluationService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/compliance")
@Tag(name = "Compliance Evaluation")
public class ComplianceEvaluationController {

    private final ComplianceEvaluationService service;

    public ComplianceEvaluationController(ComplianceEvaluationService service) {
        this.service = service;
    }

    @PostMapping("/evaluate/{readingId}")
    public ComplianceLog evaluate(@PathVariable Long readingId) {
        return service.evaluateReading(readingId);
    }

    @GetMapping("/reading/{readingId}")
    public List<ComplianceLog> getByReading(@PathVariable Long readingId) {
        return service.getLogsByReading(readingId);
    }

    @GetMapping("/{id}")
    public ComplianceLog getById(@PathVariable Long id) {
        return service.getLog(id);
    }
}
