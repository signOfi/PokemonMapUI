package com.anthony.pokemon.service;

import com.anthony.pokemon.dto.EncounterDTO;
import com.anthony.pokemon.exception.PokemonNotFoundException;
import com.anthony.pokemon.model.Encounter;
import com.anthony.pokemon.repository.EncounterRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Transactional
    public List<EncounterDTO> getAllEncountersAsDTOs() {
        Iterable<Encounter> encounters = encounterRepository.findAll();
        List<EncounterDTO> dtos = new ArrayList<>();
        for (Encounter encounter : encounters)
            dtos.add(convertToDTO(encounter));

        return dtos;
    }

    private EncounterDTO convertToDTO(Encounter encounter) {
        if (encounter == null) {
            throw new PokemonNotFoundException("Encounter not found");
        }
        EncounterDTO dto = new EncounterDTO();
        dto.setId(encounter.getId());
        dto.setPokemonName(encounter.getPokemon().getName());
        dto.setMinLevel(encounter.getMinLevel());
        dto.setMaxLevel(encounter.getMaxLevel());
        dto.setTimeOfEncounter(encounter.getTimeOfEncounter());
        dto.setEncounterRate(encounter.getEncounterRate());
        dto.setEncounterMethod(encounter.getEncounterMethod());
        dto.setVersions(encounter.getVersions());
        return dto;
    }
}
