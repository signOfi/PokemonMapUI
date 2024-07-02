package com.anthony.pokemon.controller;

import com.anthony.pokemon.service.EncounterSetupService;
import com.anthony.pokemon.service.EncounterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class EncounterController {

    private final EncounterSetupService encounterSetupService;

    public EncounterController(EncounterService encounterService, EncounterSetupService encounterSetupService) {
        this.encounterSetupService = encounterSetupService;
    }

    /* Sets all encounters statically */
    @GetMapping("/setupEncounters")
    public void pokemonSetup() {
        encounterSetupService.setupEncounters();
    }

}
