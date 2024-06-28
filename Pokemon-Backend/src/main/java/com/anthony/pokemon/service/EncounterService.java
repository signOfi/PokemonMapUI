package com.anthony.pokemon.service;

import com.anthony.pokemon.dto.EncounterDTO;
import com.anthony.pokemon.exception.LocationNotFoundException;
import com.anthony.pokemon.exception.PokemonNotFoundException;
import com.anthony.pokemon.model.Encounter;
import com.anthony.pokemon.repository.EncounterRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EncounterService {

    private final EncounterRepository encounterRepository;

    public EncounterService(EncounterRepository encounterRepository) {
        this.encounterRepository = encounterRepository;
    }

    @Transactional
    public void createAndSaveEncounter(Encounter encounter) {
        if (encounter.getLocation() == null) {
            throw new LocationNotFoundException("Location not found");
        }
        if (encounter.getPokemon() == null) {
            throw new PokemonNotFoundException("Pokemon not found");
        }
        encounterRepository.save(encounter);
    }

    @Transactional
    public void cleanEncounterTable() {
        encounterRepository.deleteAll();
    }

    public List<EncounterDTO> getAllEncounterDTOs() {
        List<Encounter> encounters = (List<Encounter>) encounterRepository.findAll();
        return encounters.stream().map(EncounterDTO::fromEntity).collect(Collectors.toList());
    }
}
