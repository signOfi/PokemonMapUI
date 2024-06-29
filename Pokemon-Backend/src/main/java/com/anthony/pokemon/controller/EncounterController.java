package com.anthony.pokemon.controller;

import com.anthony.pokemon.dto.EncounterDTO;
import com.anthony.pokemon.service.EncounterSetupService;
import com.anthony.pokemon.service.EncounterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class EncounterController {

    private final EncounterService encounterService;
    private final EncounterSetupService encounterSetupService;

    public EncounterController(EncounterService encounterService, EncounterSetupService encounterSetupService) {
        this.encounterService = encounterService;
        this.encounterSetupService = encounterSetupService;
    }

    /* Sets all encounters statically */
    @GetMapping("/setupEncounters")
    public void pokemonSetup() {
        encounterSetupService.setupEncounters();
    }

    @GetMapping("/setupEncounterDTO")
    public ResponseEntity<List<EncounterDTO>> getAllEncounters() {
        List<EncounterDTO> encounters = encounterService.getAllEncountersAsDTOs();
        return ResponseEntity.ok(encounters);
    }

}
