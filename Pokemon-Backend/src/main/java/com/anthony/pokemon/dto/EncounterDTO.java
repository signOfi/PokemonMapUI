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

    /* Static method to convert Entity to DTO */
    public static EncounterDTO fromEntity(Encounter encounter) {
        EncounterDTO dto = new EncounterDTO();
        dto.setId(encounter.getId());
        dto.setPokemonName(encounter.getPokemon().getName());
        dto.setMinLevel(encounter.getMinLevel());
        dto.setMaxLevel(encounter.getMaxLevel());
        dto.setTimeOfEncounter(encounter.getTimeOfEncounter());
        dto.setEncounterRate(encounter.getEncounterRate());
        dto.setEncounterMethod(encounter.getEncounterMethod());
        dto.setVersions(encounter.getVersions());
        dto.setLocationName(encounter.getLocation().getName());
        return dto;
    }

}
