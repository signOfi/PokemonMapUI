package com.anthony.pokemon.service;

import com.anthony.pokemon.modelJson.PokemonSpeciesInfoJSON;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class PokeAPIService {

    private final RestTemplate restTemplate;

    public PokeAPIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getPokemonSpeciesName(int id) {
        String url = UriComponentsBuilder
                .fromUriString("https://pokeapi.co/api/v2/pokemon/")
                .path(String.valueOf(id))
                .toUriString();

        PokemonSpeciesInfoJSON speciesInfo = restTemplate.getForObject(url, PokemonSpeciesInfoJSON.class);
        return speciesInfo != null ? speciesInfo.getSpecies().getName() : "Unknown Pokemon";
    }
}
