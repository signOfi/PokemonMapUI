package com.anthony.pokemon.service;

import com.anthony.pokemon.model.Pokemon;
import com.anthony.pokemon.repository.PokemonRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class PokemonService {

    private final PokeAPIService pokeAPIService;

    private final PokemonRepository pokemonRepository;

    public PokemonService(PokeAPIService pokeAPIService, PokemonRepository pokemonRepository) {
        this.pokeAPIService = pokeAPIService;
        this.pokemonRepository = pokemonRepository;
    }

    public Pokemon getByName(String name) {
        return pokemonRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Pokemon not found"));
    }

    /* Get all Pokémon from 1-493, just the poke~dex id: pokemon name */
    public void savePokemonNamesToDatabase() {
        for (int i = 1; i <= 493; i++) {
            try {
                String name = pokeAPIService.getPokemonSpeciesName(i);
                Pokemon pokemon = new Pokemon();
                pokemon.setPokemonId(i);
                pokemon.setName(name);
                pokemonRepository.save(pokemon);
            } catch (Exception e) {
                System.out.println("Failed to fetch data for Pokemon ID " + i + ": " + e.getMessage());
            }
        }
    }

    @Transactional
    public void deleteAllPokemon() {
        pokemonRepository.deleteAll();
    }

}
