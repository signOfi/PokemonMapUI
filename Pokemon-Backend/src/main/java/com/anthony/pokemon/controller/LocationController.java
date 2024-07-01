package com.anthony.pokemon.controller;

import com.anthony.pokemon.dto.LocationDTO;
import com.anthony.pokemon.exception.LocationNotFoundException;
import com.anthony.pokemon.model.EncounterMethod;
import com.anthony.pokemon.model.GameVersion;
import com.anthony.pokemon.model.TimeOfEncounter;
import com.anthony.pokemon.service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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

    /* http://localhost:8080/pokemon/encounters/13?encounterMethod=SURFING */
    @GetMapping ("/encounters/{locationId}")
    ResponseEntity<List<LocationDTO>> getEncountersByMethod(
            @PathVariable Long locationId,
            @RequestParam(required = false)EncounterMethod encounterMethod,
            @RequestParam(required = false) Set<TimeOfEncounter> timeOfEncounter) {
        try {
            List<LocationDTO> encounters = locationService.getEncountersByMethodAndTimeAndVersion(
                    locationId,
                    encounterMethod,
                    timeOfEncounter);
            return ResponseEntity.ok().body(encounters);
        } catch (LocationNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
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
