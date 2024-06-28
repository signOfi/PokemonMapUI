package com.anthony.pokemon.modelJson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class PokemonSpeciesJSON {
    private String name;
    private String url;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }
}
