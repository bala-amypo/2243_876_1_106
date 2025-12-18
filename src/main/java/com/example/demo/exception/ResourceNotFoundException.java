package com.example.demo.exception;

// Minimal exception to satisfy all services
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
