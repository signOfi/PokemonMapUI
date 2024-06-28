package com.anthony.pokemon.repository;

import com.anthony.pokemon.model.Encounter;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EncounterRepository extends CrudRepository<Encounter, Long> {
    List<Encounter> findByLocationName(String locationName);
    List<Encounter> findByPokemonName(String pokemonName);
}
