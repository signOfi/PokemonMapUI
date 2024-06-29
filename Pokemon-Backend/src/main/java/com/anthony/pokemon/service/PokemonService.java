package com.anthony.pokemon.service;

import com.anthony.pokemon.exception.PokemonNotFoundException;
import com.anthony.pokemon.model.Pokemon;
import com.anthony.pokemon.repository.PokemonRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
                .orElseThrow(() -> new PokemonNotFoundException("Pokemon not found" + name));
    }

    public void savePokemonNamesToDatabase() {

        /* Ensure uniqueness in data base */
        List<Pokemon> currentPokemonList = pokemonRepository.findAll();
        Set<Integer> set = new HashSet<>();
        for (Pokemon pokemon : currentPokemonList)
            set.add(pokemon.getPokemonId());

        for (int i = 1; i <= 493; i++) {
            if (!set.contains(i)) {
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
    }

    @Transactional
    public void deleteAllPokemon() {
        pokemonRepository.deleteAll();
    }

}
