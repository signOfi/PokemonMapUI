package com.anthony.pokemon.modelJson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class PokemonSpeciesInfoJSON {

    private PokemonSpeciesJSON species;

    @JsonProperty("species")
    public PokemonSpeciesJSON getSpecies() {
        return species;
    }
}
