package com.anthony.pokemon.util;

import com.anthony.pokemon.model.Encounter;

import java.util.*;

/* This class ensures uniqueness among the encounter entries */
public class EncounterManager {

    private final Set<String> set = new HashSet<>();

    public EncounterManager(List<Encounter> currentEncounters) {
        for (Encounter encounter : currentEncounters) {
            set.add(generateKey(encounter));
        }
    }

    public boolean containsEncounter(Encounter encounter) {
        String key = generateKey(encounter);
        return set.contains(key);
    }

    private String generateKey(Encounter encounter) {

        if (encounter == null || encounter.getPokemon() == null || encounter.getLocation() == null)
            throw new IllegalArgumentException("Encounter, Pokemon, or Location cannot be null.");


        return encounter.getPokemon().getId() + ":" + encounter.getMinLevel() + ":" +
                encounter.getMaxLevel() + ":" + encounter.getEncounterMethod() + ":" +
                encounter.getLocation().getId();
    }

}
