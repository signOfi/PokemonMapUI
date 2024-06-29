package com.anthony.pokemon.controller;

import com.anthony.pokemon.service.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    /* Gets data need from the POKE API takes about 2 minutes  */
    @GetMapping("/pokeAPIRequest")
    public void getAllPokemonNames() {
        pokemonService.savePokemonNamesToDatabase();
    }

    @GetMapping("/deleteAllPokemon")
    public void deleteAllPokemon() {
        pokemonService.deleteAllPokemon();
    }



}
