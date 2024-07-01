package com.anthony.pokemon.service;

import com.anthony.pokemon.dto.EncounterDTO;
import com.anthony.pokemon.exception.PokemonNotFoundException;
import com.anthony.pokemon.model.Encounter;
import com.anthony.pokemon.repository.EncounterRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EncounterService {

    private final EncounterRepository encounterRepository;

    public EncounterService(EncounterRepository encounterRepository) {
        this.encounterRepository = encounterRepository;
    }

    @Transactional
    public void cleanEncounterTable() {
        encounterRepository.deleteAll();
    }

    @Transactional
    public List<Encounter> getAllEncounters() {
        return (List<Encounter>) encounterRepository.findAll();
    }

}

