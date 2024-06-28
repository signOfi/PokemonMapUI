package com.anthony.pokemon.controller;

import com.anthony.pokemon.dto.EncounterDTO;
import com.anthony.pokemon.model.Encounter;
import com.anthony.pokemon.repository.EncounterRepository;
import com.anthony.pokemon.service.DatabaseSetupService;
import com.anthony.pokemon.service.EncounterService;
import com.anthony.pokemon.service.LocationService;
import com.anthony.pokemon.service.PokemonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class PokemonController {

    private final PokemonService pokemonService;
    private final DatabaseSetupService databaseSetupService;
    private final EncounterService encounterService;
    private final LocationService locationService;

    public PokemonController(PokemonService pokemonService,
                             DatabaseSetupService databaseSetupService, EncounterService encounterService,
                             LocationService locationService) {
        this.pokemonService = pokemonService;
        this.databaseSetupService = databaseSetupService;
        this.encounterService = encounterService;
        this.locationService = locationService;
    }

    @GetMapping("/pokemon/encounters")
    public List<EncounterDTO> getAllEncounters() {
        return encounterService.getAllEncounterDTOs();
    }



    /* *************************  *************************  */
    /* SETUP for PKMN table, location, and encounter */
    /* *************************   ************************* */
    @GetMapping("/pokemon/bigRequest")
    public void getAllPokemonNames() {
        pokemonService.savePokemonNamesToDatabase();
    }
    @GetMapping("/pokemon/setupLocations")
    public void getAllPokemonLocations() {
        locationService.initializeLocations();
    }
    @GetMapping("pokemon/setupEncounters")
    public void pokemonSetup() {
        databaseSetupService.setupEncounters();
    }


    /* ************************* */
    /* Delete all Functionality */
    /* ************************* */
    @GetMapping("/pokemon/deleteAllPokemon")
    public void deleteAllPokemon() {
        pokemonService.deleteAllPokemon();
    }
    @GetMapping("/pokemon/deleteEncounters")
    public void cleanEncounter() {
        encounterService.cleanEncounterTable();
    }
    @GetMapping("pokemon/deleteLocations")
    public void deleteLocations() {
        locationService.deleteAllLocations();
    }



}
