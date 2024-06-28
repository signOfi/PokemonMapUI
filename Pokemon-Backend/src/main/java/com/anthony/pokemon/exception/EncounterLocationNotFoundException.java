package com.anthony.pokemon.exception;

public class EncounterLocationNotFoundException extends RuntimeException {
    public EncounterLocationNotFoundException(String message) {
        super(message);
    }
}
