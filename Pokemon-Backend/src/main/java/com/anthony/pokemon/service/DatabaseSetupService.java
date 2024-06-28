package com.anthony.pokemon.service;

import com.anthony.pokemon.model.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DatabaseSetupService {

    private final LocationService locationService;
    private final EncounterService encounterService;
    private final PokemonService pokemonService;

    private final Set<TimeOfEncounter> allTimes;
    private final Set<TimeOfEncounter> morningDay;
    private final Set<TimeOfEncounter> nightOnly;
    private final Set<GameVersion> allVersions;

    private Set<GameVersion> heartGold;
    private Set<GameVersion> soulSilver;

    public DatabaseSetupService(LocationService locationService,
                                EncounterService encounterService,
                                PokemonService pokemonService,
                                Set<TimeOfEncounter> allTimes,
                                Set<TimeOfEncounter> morningDay,
                                Set<TimeOfEncounter> nightOnly,
                                Set<GameVersion> allVersions
                                ) {
        this.locationService = locationService;
        this.encounterService = encounterService;
        this.pokemonService = pokemonService;

        this.allTimes = EnumSet.of(TimeOfEncounter.MORNING, TimeOfEncounter.DAY, TimeOfEncounter.NIGHT);
        this.morningDay = EnumSet.of(TimeOfEncounter.MORNING, TimeOfEncounter.DAY);
        this.nightOnly = EnumSet.of(TimeOfEncounter.NIGHT);

        this.allVersions = new HashSet<>(Arrays.asList(GameVersion.HG, GameVersion.SS));
        this.heartGold = new HashSet<>(List.of(GameVersion.HG));
        this.soulSilver = new HashSet<>(List.of(GameVersion.SS));
    }


    @Transactional
    public void setupEncounters() {
        initializeSproutTower();
    }

    private void initializeSproutTower() {
        Location sproutTower = locationService.getLocationByName("Sprout Tower");
        Pokemon gastly = pokemonService.getByName("gastly");
        Pokemon rattata = pokemonService.getByName("rattata");

        Pokemon blastoise = pokemonService.getByName("blastoise");
        Pokemon scizor = pokemonService.getByName("scizor");

        Encounter e1 = new Encounter(rattata, 3, 6, morningDay, 100.00,
                EncounterMethod.WALKING, allVersions, sproutTower);
        Encounter e2 = new Encounter(rattata, 3, 6, nightOnly, 15.00,
                EncounterMethod.WALKING, allVersions, sproutTower);
        Encounter e3 = new Encounter(gastly, 3, 6, nightOnly, 85.00,
                EncounterMethod.WALKING, allVersions, sproutTower);

        Encounter e4 = new Encounter(blastoise, 40, 60, allTimes, 100.00,
                EncounterMethod.SURFING, allVersions, sproutTower);
        Encounter e5 = new Encounter(scizor, 50, 70, allTimes, 100.00,
                EncounterMethod.GIFT, allVersions, sproutTower);

        encounterService.createAndSaveEncounter(e1);
        encounterService.createAndSaveEncounter(e2);
        encounterService.createAndSaveEncounter(e3);

        encounterService.createAndSaveEncounter(e4);
        encounterService.createAndSaveEncounter(e5);
    }
}
