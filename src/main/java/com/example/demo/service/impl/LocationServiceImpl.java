package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Location;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LocationRepository;
import com.example.demo.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository repository;

    public LocationServiceImpl(LocationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Location createLocation(Location location) {
        if (location.getRegion() == null) {
            throw new IllegalArgumentException("region required");
        }
        location.setCreatedAt(LocalDateTime.now());
        return repository.save(location);
    }

    @Override
    public Location getLocation(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    @Override
    public List<Location> getAllLocations() {
        return repository.findAll();
    }
}
