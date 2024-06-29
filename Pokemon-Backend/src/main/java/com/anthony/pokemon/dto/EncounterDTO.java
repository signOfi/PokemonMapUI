package com.anthony.pokemon.dto;

import com.anthony.pokemon.model.Encounter;
import com.anthony.pokemon.model.EncounterMethod;
import com.anthony.pokemon.model.GameVersion;
import com.anthony.pokemon.model.TimeOfEncounter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EncounterDTO {
    private Long id;
    private String pokemonName;
    private Integer minLevel;
    private Integer maxLevel;
    private Set<TimeOfEncounter> timeOfEncounter;
    private Double encounterRate;
    private EncounterMethod encounterMethod;
    private Set<GameVersion> versions;
    private String locationName;
    private String subLevel;

    public EncounterDTO(Long id, String name, Integer minLevel, Integer maxLevel, Set<TimeOfEncounter> timeOfEncounter, Double encounterRate, EncounterMethod encounterMethod, Set<GameVersion> versions) {
        this.id = id;
        this.pokemonName = name;
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
        this.timeOfEncounter = timeOfEncounter;
        this.encounterRate = encounterRate;
        this.encounterMethod = encounterMethod;
        this.versions = versions;
    }
    public EncounterDTO(Long id, String pokemonName, Integer minLevel, Integer maxLevel, Set<TimeOfEncounter> timeOfEncounter, Double encounterRate, EncounterMethod encounterMethod, Set<GameVersion> versions, String locationName) {
        this.id = id;
        this.pokemonName = pokemonName;
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
        this.timeOfEncounter = timeOfEncounter;
        this.encounterRate = encounterRate;
        this.encounterMethod = encounterMethod;
        this.versions = versions;
        this.locationName = locationName;
    }
}
