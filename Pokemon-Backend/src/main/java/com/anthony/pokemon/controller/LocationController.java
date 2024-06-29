package com.anthony.pokemon.controller;

import com.anthony.pokemon.dto.LocationDTO;
import com.anthony.pokemon.exception.LocationNotFoundException;
import com.anthony.pokemon.service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    /* Set up all static locations in region */
    @GetMapping("/initializeLocations")
    public ResponseEntity<Void> initializeLocations() {
        locationService.initializeLocations();
        return ResponseEntity.ok().build();
    }

    /* Read operation that gets ALL location DTOs */
    @GetMapping("/getAllLocationDTOs")
    public ResponseEntity<List<LocationDTO>> getAllLocations() {
        List<LocationDTO> locationDTOs = locationService.getAllLocationDTOs();
        return ResponseEntity.ok(locationDTOs);
    }

    /* Read Operation that gets a singular location DTO */
    @GetMapping("/getLocationDTO/{name}")
    public ResponseEntity<LocationDTO> getLocation(@PathVariable String name) {
        try {
            LocationDTO locationDTO = locationService.getLocationDTOByName(name);
            return ResponseEntity.ok(locationDTO);
        } catch (LocationNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
