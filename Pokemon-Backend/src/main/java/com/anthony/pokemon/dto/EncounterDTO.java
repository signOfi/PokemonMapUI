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
}
