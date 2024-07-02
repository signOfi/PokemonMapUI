package com.anthony.pokemon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocationDTO {
    private Long id;
    private String name;
    private List<EncounterDTO> encounters;
    private String description;
}

