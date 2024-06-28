package com.anthony.pokemon.repository;

import com.anthony.pokemon.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Optional<Pokemon> findByName(String name);
}
