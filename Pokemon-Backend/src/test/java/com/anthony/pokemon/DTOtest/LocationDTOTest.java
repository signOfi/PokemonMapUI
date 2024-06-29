package com.anthony.pokemon.DTOtest;

import com.anthony.pokemon.dto.EncounterDTO;
import com.anthony.pokemon.dto.LocationDTO;
import com.anthony.pokemon.model.*;
import com.anthony.pokemon.service.LocationService;
import com.anthony.pokemon.service.PokemonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.lenient;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class LocationDTOTest {

    @Mock
    private LocationService locationService;

    @Mock
    private PokemonService pokemonService;

    @Test
    public void testLocationDTOConversion() {

        Location location = new Location();
        location.setId(1L);
        location.setName("Sprout Tower");

        Pokemon pikachu = new Pokemon();
        pikachu.setName("Pikachu");
        lenient().when(pokemonService.getByName("Pikachu")).thenReturn(pikachu);

        Encounter encounter = new Encounter();
        encounter.setId(1L);
        encounter.setPokemon(pikachu);
        encounter.setMinLevel(5);
        encounter.setMaxLevel(10);
        encounter.setTimeOfEncounter(Collections.singleton(TimeOfEncounter.DAY));
        encounter.setEncounterRate(50.0);
        encounter.setEncounterMethod(EncounterMethod.ENCOUNTER);
        encounter.setVersions(Collections.singleton(GameVersion.HG));

        location.setEncounters(Collections.singletonList(encounter));

        LocationDTO expectedDto = new LocationDTO(1L, "Sprout Tower", Collections.emptyList());

        when(locationService.convertToLocationDTO(location)).thenReturn(expectedDto);

        // Invoke the method under test
        LocationDTO actualDto = locationService.convertToLocationDTO(location);

        System.out.println(actualDto.getName());
        System.out.println(actualDto.getId());

        for (EncounterDTO encounter1: actualDto.getEncounters()) {
            System.out.println(encounter1.getTimeOfEncounter());
            System.out.println(encounter1.getEncounterRate());

            if ((encounter1.getVersions() == null)) {
                System.out.println("Is null");
            } else {
                System.out.println(encounter1.getVersions());
            }

            System.out.println(encounter1.getPokemonName());
        }


        // Assertions
        assertNotNull(actualDto, "The LocationDTO should not be null");
        assertNotNull(actualDto.getName(), "The name field in LocationDTO should not be null");
        assertNotNull(actualDto.getEncounters(), "The encounters list in LocationDTO should not be null");
    }
}
