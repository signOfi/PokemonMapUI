package com.anthony.pokemon.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "pokemon_id")
    private Integer pokemonId;

    @Column (name = "name")
    private String name;

    @OneToMany(mappedBy = "pokemon")
    Set<Encounter> encounters = new HashSet<>();

}
