package com.anthony.pokemon.service;

import com.anthony.pokemon.model.*;
import com.anthony.pokemon.util.EncounterManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EncounterSetupService {

    private final LocationService locationService;
    private final PokemonService pokemonService;
    private final EncounterService encounterService;

    private final Set<TimeOfEncounter> allTimes;
    private final Set<TimeOfEncounter> morningDay;
    private final Set<TimeOfEncounter> morning;
    private final Set<TimeOfEncounter> day;
    private final Set<TimeOfEncounter> night;
    private final Set<GameVersion> allVersions;

    private final EncounterManager encounterManager;

    List<Encounter> newEncounters;

    private Set<GameVersion> heartGold;
    private Set<GameVersion> soulSilver;

    public EncounterSetupService(LocationService locationService,
                                 PokemonService pokemonService,
                                 EncounterService encounterService) {

        this.locationService = locationService;
        this.pokemonService = pokemonService;
        this.encounterService = encounterService;

        this.encounterManager = new EncounterManager(encounterService.getAllEncounters());

        this.allTimes = EnumSet.of(TimeOfEncounter.MORNING, TimeOfEncounter.DAY, TimeOfEncounter.NIGHT);
        this.morningDay = EnumSet.of(TimeOfEncounter.MORNING, TimeOfEncounter.DAY);
        this.night = EnumSet.of(TimeOfEncounter.NIGHT);
        this.morning = EnumSet.of(TimeOfEncounter.MORNING);
        this.day = EnumSet.of(TimeOfEncounter.DAY);

        this.allVersions = new HashSet<>(Arrays.asList(GameVersion.HG, GameVersion.SS));
        this.heartGold = new HashSet<>(List.of(GameVersion.HG));
        this.soulSilver = new HashSet<>(List.of(GameVersion.SS));
    }


    @Transactional
    public void setupEncounters() {
        initializeSproutTower();
        initializeRoute29();
        initializeRoute30();
        initializeRoute31();
        initializeRoute32();
        initializeRoute33();
        initializeRoute34();
        initializeRoute35();
        initializeRoute36();
        initializeRoute37();
    }

    @Transactional
    protected void initializeRoute29() {

        newEncounters = new ArrayList<>();
        Location route29 = locationService.getLocationByName("Route 29");
        Pokemon sentret = pokemonService.getByName("sentret");
        Pokemon rattata = pokemonService.getByName("rattata");
        Pokemon hoothoot = pokemonService.getByName("hoothoot");
        Pokemon pidgey = pokemonService.getByName("pidgey");

        newEncounters = new ArrayList<>();

        newEncounters.add(new Encounter(pidgey, 2, 4, morningDay,
                55.00, EncounterMethod.WALKING, allVersions, route29));
        newEncounters.add(new Encounter(sentret, 2, 3, morningDay,
                40.00, EncounterMethod.WALKING, allVersions, route29));
        newEncounters.add(new Encounter(rattata, 4, 4, morningDay,
                5.00, EncounterMethod.WALKING, allVersions, route29));


        newEncounters.add(new Encounter(hoothoot, 2, 4, night,
                85.00, EncounterMethod.WALKING, allVersions, route29));
        newEncounters.add(new Encounter(rattata, 2, 4, night,
                15.00, EncounterMethod.WALKING, allVersions, route29));
    }

    @Transactional
    protected void initializeRoute30() {

        newEncounters = new ArrayList<>();
        Location route30 = locationService.getLocationByName("Route 30");

        Pokemon caterpie = pokemonService.getByName("caterpie");
        Pokemon pidgey = pokemonService.getByName("pidgey");
        Pokemon metapod = pokemonService.getByName("metapod");
        Pokemon weedle = pokemonService.getByName("weedle");
        Pokemon ledyba = pokemonService.getByName("ledyba");
        Pokemon kakuna = pokemonService.getByName("kakuna");
        Pokemon rattata = pokemonService.getByName("rattata");
        Pokemon spinarak = pokemonService.getByName("spinarak");
        Pokemon hoothoot = pokemonService.getByName("hoothoot");

        Pokemon poliwag = pokemonService.getByName("poliwag");
        Pokemon poliwhirl = pokemonService.getByName("poliwhirl");
        Pokemon magikarp = pokemonService.getByName("magikarp");

        newEncounters.add(new Encounter(pidgey, 2, 4, morning,
                50.00, EncounterMethod.WALKING, heartGold, route30));
        newEncounters.add(new Encounter(caterpie, 3, 4, morning,
                40.00, EncounterMethod.WALKING, heartGold, route30));
        newEncounters.add(new Encounter(metapod, 4, 4, morning,
                10.00, EncounterMethod.WALKING, heartGold, route30));
        newEncounters.add(new Encounter(weedle, 3, 4, morning,
                50.00, EncounterMethod.WALKING, soulSilver, route30));
        newEncounters.add(new Encounter(ledyba, 3, 3, morning,
                30.00, EncounterMethod.WALKING, soulSilver, route30));
        newEncounters.add(new Encounter(kakuna, 4, 4, morning,
                10.00, EncounterMethod.WALKING, soulSilver, route30));
        newEncounters.add(new Encounter(pidgey, 4, 4, morning,
                10.00, EncounterMethod.WALKING, soulSilver, route30));


        newEncounters.add(new Encounter(pidgey, 2, 4, day,
                50.00, EncounterMethod.WALKING, heartGold, route30));
        newEncounters.add(new Encounter(caterpie, 2, 4, day,
                35.00, EncounterMethod.WALKING, heartGold, route30));
        newEncounters.add(new Encounter(metapod, 4, 4, day,
                15.00, EncounterMethod.WALKING, heartGold, route30));
        newEncounters.add(new Encounter(pidgey, 3, 4, day,
                50.00, EncounterMethod.WALKING, soulSilver, route30));
        newEncounters.add(new Encounter(weedle, 3, 4, day,
                35.00, EncounterMethod.WALKING, soulSilver, route30));
        newEncounters.add(new Encounter(kakuna, 4, 4, day,
                15.00, EncounterMethod.WALKING, soulSilver, route30));

        newEncounters.add(new Encounter(rattata, 3, 4, night,
                40.00, EncounterMethod.WALKING, heartGold, route30));
        newEncounters.add(new Encounter(hoothoot, 4, 4, night,
                30.00, EncounterMethod.WALKING, heartGold, route30));
        newEncounters.add(new Encounter(spinarak, 2, 2, night,
                30.00, EncounterMethod.WALKING, heartGold, route30));
        newEncounters.add(new Encounter(rattata, 3, 4, night,
                40.00, EncounterMethod.WALKING, soulSilver, route30));
        newEncounters.add(new Encounter(hoothoot, 3, 4, night,
                60.00, EncounterMethod.WALKING, soulSilver, route30));

        newEncounters.add(new Encounter(poliwag, 10, 25, allTimes,
                90.00, EncounterMethod.SURFING, allVersions, route30));
        newEncounters.add(new Encounter(poliwhirl, 15, 32, allTimes,
                10.00, EncounterMethod.SURFING, allVersions, route30));

        newEncounters.add(new Encounter(poliwag, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, route30));
        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, route30));

        newEncounters.add(new Encounter(poliwag, 20, 20, allTimes,
                40.00, EncounterMethod.GOOD_ROD, allVersions, route30));
        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, route30));

        newEncounters.add(new Encounter(poliwag, 40, 40, allTimes,
                93.00, EncounterMethod.SUPER_ROD, allVersions, route30));
        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes,
                7.00, EncounterMethod.SUPER_ROD, allVersions, route30));

        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                route30.addEncounter(encounter);

        locationService.saveLocation(route30);
    }

    @Transactional
    protected void initializeRoute31() {

        newEncounters = new ArrayList<>();
        Location route31 = locationService.getLocationByName("Route 31");

        Pokemon caterpie = pokemonService.getByName("caterpie");
        Pokemon pidgey = pokemonService.getByName("pidgey");
        Pokemon bellsprout = pokemonService.getByName("bellsprout");
        Pokemon metapod = pokemonService.getByName("metapod");
        Pokemon weedle = pokemonService.getByName("weedle");
        Pokemon ledyba = pokemonService.getByName("ledyba");
        Pokemon kakuna = pokemonService.getByName("kakuna");
        Pokemon rattata = pokemonService.getByName("rattata");
        Pokemon spinarak = pokemonService.getByName("spinarak");
        Pokemon hoothoot = pokemonService.getByName("hoothoot");

        Pokemon poliwag = pokemonService.getByName("poliwag");
        Pokemon poliwhirl = pokemonService.getByName("poliwhirl");
        Pokemon magikarp = pokemonService.getByName("magikarp");

        newEncounters.add(new Encounter(caterpie, 4, 5, morningDay,
                35.00, EncounterMethod.WALKING, heartGold, route31));
        newEncounters.add(new Encounter(pidgey, 3, 3, morningDay,
                30.00, EncounterMethod.WALKING, heartGold, route31));
        newEncounters.add(new Encounter(bellsprout, 3, 3, morningDay,
                20.00, EncounterMethod.WALKING, heartGold, route31));
        newEncounters.add(new Encounter(metapod, 5, 5, morningDay,
                15.00, EncounterMethod.WALKING, heartGold, route31));

        newEncounters.add(new Encounter(weedle, 4, 4, morning,
                30.00, EncounterMethod.WALKING, soulSilver, route31));
        newEncounters.add(new Encounter(ledyba, 4, 4, morning,
                30.00, EncounterMethod.WALKING, soulSilver, route31));
        newEncounters.add(new Encounter(bellsprout, 3, 3, morning,
                20.00, EncounterMethod.WALKING, soulSilver, route31));
        newEncounters.add(new Encounter(kakuna, 5, 5, morning,
                10.00, EncounterMethod.WALKING, soulSilver, route31));
        newEncounters.add(new Encounter(pidgey, 5, 5, morning,
                10.00, EncounterMethod.WALKING, soulSilver, route31));

        newEncounters.add(new Encounter(weedle, 4, 5, day,
                35.00, EncounterMethod.WALKING, soulSilver, route31));
        newEncounters.add(new Encounter(pidgey, 4, 4, day,
                20.00, EncounterMethod.WALKING, soulSilver, route31));
        newEncounters.add(new Encounter(bellsprout, 3, 3, day,
                10.00, EncounterMethod.WALKING, soulSilver, route31));
        newEncounters.add(new Encounter(kakuna, 5, 5, day,
                10.00, EncounterMethod.WALKING, soulSilver, route31));

        newEncounters.add(new Encounter(rattata, 4, 5, night,
                40.00, EncounterMethod.WALKING, heartGold, route31));
        newEncounters.add(new Encounter(spinarak, 3, 3, night,
                30.00, EncounterMethod.WALKING, heartGold, route31));
        newEncounters.add(new Encounter(bellsprout, 3, 3, night,
                20.00, EncounterMethod.WALKING, heartGold, route31));
        newEncounters.add(new Encounter(hoothoot, 5, 5, night,
                10.00, EncounterMethod.WALKING, heartGold, route31));

        newEncounters.add(new Encounter(hoothoot, 4, 5, night,
                30.00, EncounterMethod.WALKING, soulSilver, route31));
        newEncounters.add(new Encounter(rattata, 4, 5, night,
                20.00, EncounterMethod.WALKING, soulSilver, route31));
        newEncounters.add(new Encounter(bellsprout, 3, 3, night,
                10.00, EncounterMethod.WALKING, soulSilver, route31));

        newEncounters.add(new Encounter(poliwag, 10, 25, allTimes,
                90.00, EncounterMethod.SURFING, allVersions, route31));
        newEncounters.add(new Encounter(poliwhirl, 15, 32, allTimes,
                10.00, EncounterMethod.SURFING, allVersions, route31));

        newEncounters.add(new Encounter(poliwag, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, route31));
        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, route31));

        newEncounters.add(new Encounter(poliwag, 20, 20, allTimes,
                40.00, EncounterMethod.GOOD_ROD, allVersions, route31));
        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, route31));

        newEncounters.add(new Encounter(poliwag, 40, 40, allTimes,
                93.00, EncounterMethod.SUPER_ROD, allVersions, route31));
        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes,
                7.00, EncounterMethod.SUPER_ROD, allVersions, route31));

        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                route31.addEncounter(encounter);

        locationService.saveLocation(route31);
    }

    @Transactional
    protected void initializeRoute32() {

        newEncounters = new ArrayList<>();
        Location route32 = locationService.getLocationByName("Route 32");

        Pokemon hoppip = pokemonService.getByName("hoppip");
        Pokemon rattata = pokemonService.getByName("rattata");
        Pokemon ekans = pokemonService.getByName("ekans");
        Pokemon wooper = pokemonService.getByName("wooper");
        Pokemon bellsprout = pokemonService.getByName("bellsprout");
        Pokemon mareep = pokemonService.getByName("mareep");
        Pokemon zubat = pokemonService.getByName("zubat");
        Pokemon qwilfish = pokemonService.getByName("qwilfish");
        Pokemon tentacool = pokemonService.getByName("tentacool");
        Pokemon magikarp = pokemonService.getByName("magikarp");
        Pokemon quagsire = pokemonService.getByName("quagsire");
        Pokemon tentacruel = pokemonService.getByName("tentacruel");

        newEncounters.add(new Encounter(rattata, 4, 6, morning,
                35.00, EncounterMethod.WALKING, heartGold, route32));
        newEncounters.add(new Encounter(bellsprout, 6, 6, morning,
                30.00, EncounterMethod.WALKING, heartGold, route32));
        newEncounters.add(new Encounter(mareep, 6, 6, morning,
                20.00, EncounterMethod.WALKING, heartGold, route32));
        newEncounters.add(new Encounter(hoppip, 6, 6, morning,
                10.00, EncounterMethod.WALKING, heartGold, route32));
        newEncounters.add(new Encounter(zubat, 4, 4, morning,
                5.00, EncounterMethod.WALKING, heartGold, route32));
        newEncounters.add(new Encounter(ekans, 4, 4, morning,
                35.00, EncounterMethod.WALKING, soulSilver, route32));
        newEncounters.add(new Encounter(bellsprout, 6, 6, morning,
                30.00, EncounterMethod.WALKING, soulSilver, route32));
        newEncounters.add(new Encounter(mareep, 6, 6, morning,
                20.00, EncounterMethod.WALKING, soulSilver, route32));
        newEncounters.add(new Encounter(hoppip, 6, 6, morning,
                10.00, EncounterMethod.WALKING, soulSilver, route32));
        newEncounters.add(new Encounter(rattata, 6, 6, morning,
                5.00, EncounterMethod.WALKING, soulSilver, route32));
        newEncounters.add(new Encounter(zubat, 4, 4, morning,
                5.00, EncounterMethod.WALKING, soulSilver, route32));


        newEncounters.add(new Encounter(rattata, 4, 6, day,
                40.00, EncounterMethod.WALKING, heartGold, route32));
        newEncounters.add(new Encounter(bellsprout, 6, 6, day,
                30.00, EncounterMethod.WALKING, heartGold, route32));
        newEncounters.add(new Encounter(mareep, 6, 6, day,
                20.00, EncounterMethod.WALKING, heartGold, route32));
        newEncounters.add(new Encounter(hoppip, 6, 6, day,
                10.00, EncounterMethod.WALKING, heartGold, route32));
        newEncounters.add(new Encounter(ekans, 4, 4, day,
                30.00, EncounterMethod.WALKING, soulSilver, route32));
        newEncounters.add(new Encounter(bellsprout, 6, 6, day,
                30.00, EncounterMethod.WALKING, soulSilver, route32));
        newEncounters.add(new Encounter(mareep, 6, 6, day,
                20.00, EncounterMethod.WALKING, soulSilver, route32));
        newEncounters.add(new Encounter(hoppip, 6, 6, day,
                10.00, EncounterMethod.WALKING, soulSilver, route32));
        newEncounters.add(new Encounter(rattata, 4, 6, day,
                10.00, EncounterMethod.WALKING, soulSilver, route32));

        newEncounters.add(new Encounter(wooper, 6, 6, night,
                35.00, EncounterMethod.WALKING, heartGold, route32));
        newEncounters.add(new Encounter(rattata, 4, 4, night,
                30.00, EncounterMethod.WALKING, heartGold, route32));
        newEncounters.add(new Encounter(bellsprout, 6, 6, night,
                20.00, EncounterMethod.WALKING, heartGold, route32));
        newEncounters.add(new Encounter(mareep, 6, 6, night,
                10.00, EncounterMethod.WALKING, heartGold, route32));
        newEncounters.add(new Encounter(zubat, 4, 4, night,
                5.00, EncounterMethod.WALKING, heartGold, route32));
        newEncounters.add(new Encounter(wooper, 6, 6, night,
                35.00, EncounterMethod.WALKING, soulSilver, route32));
        newEncounters.add(new Encounter(ekans, 4, 4, night,
                30.00, EncounterMethod.WALKING, soulSilver, route32));
        newEncounters.add(new Encounter(bellsprout, 6, 6, night,
                20.00, EncounterMethod.WALKING, soulSilver, route32));
        newEncounters.add(new Encounter(mareep, 6, 6, night,
                10.00, EncounterMethod.WALKING, soulSilver, route32));
        newEncounters.add(new Encounter(zubat, 4, 4, night,
                5.00, EncounterMethod.WALKING, soulSilver, route32));

        newEncounters.add(new Encounter(tentacool, 10, 20, allTimes,
                60.00, EncounterMethod.SURFING, allVersions, route32));
        newEncounters.add(new Encounter(quagsire, 15, 25, allTimes,
                30.00, EncounterMethod.SURFING, allVersions, route32));
        newEncounters.add(new Encounter(tentacruel, 15, 36, allTimes,
                10.00, EncounterMethod.SURFING, allVersions, route32));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, route32));
        newEncounters.add(new Encounter(tentacool, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, route32));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, route32));
        newEncounters.add(new Encounter(tentacool, 20, 20, allTimes,
                38.00, EncounterMethod.GOOD_ROD, allVersions, route32));
        newEncounters.add(new Encounter(qwilfish, 20, 20, allTimes,
                2.00, EncounterMethod.GOOD_ROD, allVersions, route32));

        newEncounters.add(new Encounter(tentacool, 40, 40, allTimes,
                90.00, EncounterMethod.SUPER_ROD, allVersions, route32));
        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes,
                7.00, EncounterMethod.SUPER_ROD, allVersions, route32));
        newEncounters.add(new Encounter(qwilfish, 40, 40, allTimes,
                3.00, EncounterMethod.SUPER_ROD, allVersions, route32));


        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                route32.addEncounter(encounter);

        locationService.saveLocation(route32);
    }

    @Transactional
    protected void initializeRoute33() {
        newEncounters = new ArrayList<>();
        Location route33 = locationService.getLocationByName("Route 33");

        Pokemon hoppip = pokemonService.getByName("hoppip");
        Pokemon rattata = pokemonService.getByName("rattata");
        Pokemon zubat = pokemonService.getByName("zubat");
        Pokemon spearow = pokemonService.getByName("spearow");
        Pokemon ekans = pokemonService.getByName("ekans");

        newEncounters.add(new Encounter(rattata, 6, 7, morning,
                40.00, EncounterMethod.WALKING, heartGold, route33));
        newEncounters.add(new Encounter(hoppip, 6, 8, morning,
                35.00, EncounterMethod.WALKING, heartGold, route33));
        newEncounters.add(new Encounter(spearow, 6, 6, morning,
                20.00, EncounterMethod.WALKING, heartGold, route33));
        newEncounters.add(new Encounter(zubat, 4, 4, morning,
                5.00, EncounterMethod.WALKING, heartGold, route33));
        newEncounters.add(new Encounter(hoppip, 6, 8, morning,
                35.00, EncounterMethod.WALKING, soulSilver, route33));
        newEncounters.add(new Encounter(ekans, 7, 7, morning,
                30.00, EncounterMethod.WALKING, soulSilver, route33));
        newEncounters.add(new Encounter(spearow, 6, 6, morning,
                20.00, EncounterMethod.WALKING, soulSilver, route33));
        newEncounters.add(new Encounter(rattata, 6, 6, morning,
                10.00, EncounterMethod.WALKING, soulSilver, route33));
        newEncounters.add(new Encounter(zubat, 4, 4, morning,
                5.00, EncounterMethod.WALKING, soulSilver, route33));


        newEncounters.add(new Encounter(rattata, 4, 7, day,
                45.00, EncounterMethod.WALKING, heartGold, route33));
        newEncounters.add(new Encounter(hoppip, 6, 8, day,
                35.00, EncounterMethod.WALKING, heartGold, route33));
        newEncounters.add(new Encounter(spearow, 6, 6, day,
                20.00, EncounterMethod.WALKING, heartGold, route33));
        newEncounters.add(new Encounter(rattata, 6, 8, day,
                35.00, EncounterMethod.WALKING, soulSilver, route33));
        newEncounters.add(new Encounter(hoppip, 7, 7, day,
                30.00, EncounterMethod.WALKING, soulSilver, route33));
        newEncounters.add(new Encounter(spearow, 6, 6, day,
                20.00, EncounterMethod.WALKING, soulSilver, route33));
        newEncounters.add(new Encounter(spearow, 4, 6, day,
                15.00, EncounterMethod.WALKING, soulSilver, route33));

        newEncounters.add(new Encounter(rattata, 4, 7, night,
                60.00, EncounterMethod.WALKING, allVersions, route33));
        newEncounters.add(new Encounter(zubat, 4, 8, night,
                40.00, EncounterMethod.WALKING, allVersions, route33));

        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                route33.addEncounter(encounter);

        locationService.saveLocation(route33);
    }

    @Transactional
    protected void initializeRoute34() {

        newEncounters = new ArrayList<>();
        Location route34 = locationService.getLocationByName("Route 34");

        Pokemon drowzee = pokemonService.getByName("drowzee");
        Pokemon abra = pokemonService.getByName("abra");
        Pokemon ditto = pokemonService.getByName("ditto");
        Pokemon rattata = pokemonService.getByName("rattata");

        Pokemon tentacool = pokemonService.getByName("tentacool");
        Pokemon tentacruel = pokemonService.getByName("tentacruel");

        Pokemon magikarp = pokemonService.getByName("magikarp");
        Pokemon krabby = pokemonService.getByName("krabby");
        Pokemon corsola = pokemonService.getByName("corsola");
        Pokemon staryu = pokemonService.getByName("staryu");
        Pokemon kingler = pokemonService.getByName("kingler");

        newEncounters.add(new Encounter(drowzee, 10, 12, allTimes,
                50.00, EncounterMethod.WALKING, allVersions, route34));
        newEncounters.add(new Encounter(rattata, 11, 13, allTimes,
                35.00, EncounterMethod.WALKING, allVersions, route34));
        newEncounters.add(new Encounter(abra, 10, 10, allTimes,
                10.00, EncounterMethod.WALKING, allVersions, route34));
        newEncounters.add(new Encounter(ditto, 10, 10, allTimes,
                10.00, EncounterMethod.WALKING, allVersions, route34));

        newEncounters.add(new Encounter(tentacool, 10, 25, allTimes,
                90.00, EncounterMethod.SURFING, allVersions, route34));
        newEncounters.add(new Encounter(tentacruel, 15, 29, allTimes,
                10.00, EncounterMethod.SURFING, allVersions, route34));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                90.00, EncounterMethod.OLD_ROD, allVersions, route34));
        newEncounters.add(new Encounter(krabby, 10, 10, allTimes,
                10.00, EncounterMethod.OLD_ROD, allVersions, route34));

        newEncounters.add(new Encounter(magikarp, 20, 20, morningDay,
                60.00, EncounterMethod.GOOD_ROD, allVersions, route34));
        newEncounters.add(new Encounter(krabby, 20, 20, morningDay,
                37.00, EncounterMethod.GOOD_ROD, allVersions, route34));
        newEncounters.add(new Encounter(corsola, 20, 20, morningDay,
                3.00, EncounterMethod.GOOD_ROD, allVersions, route34));
        newEncounters.add(new Encounter(magikarp, 20, 20, night,
                60.00, EncounterMethod.GOOD_ROD, allVersions, route34));
        newEncounters.add(new Encounter(krabby, 20, 20, night,
                37.00, EncounterMethod.GOOD_ROD, allVersions, route34));
        newEncounters.add(new Encounter(staryu, 20, 20, night,
                3.00, EncounterMethod.GOOD_ROD, allVersions, route34));

        newEncounters.add(new Encounter(krabby, 40, 40, morningDay,
                67.00, EncounterMethod.SUPER_ROD, allVersions, route34));
        newEncounters.add(new Encounter(corsola, 40, 40, morningDay,
                30.00, EncounterMethod.SUPER_ROD, allVersions, route34));
        newEncounters.add(new Encounter(kingler, 40, 40, morningDay,
                3.00, EncounterMethod.SUPER_ROD, allVersions, route34));
        newEncounters.add(new Encounter(krabby, 40, 40, night,
                67.00, EncounterMethod.SUPER_ROD, allVersions, route34));
        newEncounters.add(new Encounter(staryu, 40, 40, night,
                30.00, EncounterMethod.SUPER_ROD, allVersions, route34));
        newEncounters.add(new Encounter(kingler, 40, 40, night,
                3.00, EncounterMethod.SUPER_ROD, allVersions, route34));



        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                route34.addEncounter(encounter);

        locationService.saveLocation(route34);
    }

    @Transactional
    protected void initializeRoute35() {
        newEncounters = new ArrayList<>();
        Location route35 = locationService.getLocationByName("Route 35");

        Pokemon nidoranF = pokemonService.getByName("nidoran-f");
        Pokemon nidoranM = pokemonService.getByName("nidoran-m");
        Pokemon drowzee = pokemonService.getByName("drowzee");
        Pokemon abra = pokemonService.getByName("abra");
        Pokemon ditto = pokemonService.getByName("ditto");
        Pokemon pidgey = pokemonService.getByName("pidgey");
        Pokemon yanma = pokemonService.getByName("yanma");

        Pokemon psyduck = pokemonService.getByName("psyduck");
        Pokemon golduck = pokemonService.getByName("golduck");

        Pokemon poliwag = pokemonService.getByName("poliwag");
        Pokemon magikarp = pokemonService.getByName("magikarp");

        newEncounters.add(new Encounter(nidoranF, 12, 12, allTimes,
                30.00, EncounterMethod.WALKING, allVersions, route35));
        newEncounters.add(new Encounter(nidoranM, 12, 12, allTimes,
                30.00, EncounterMethod.WALKING, allVersions, route35));
        newEncounters.add(new Encounter(drowzee, 14, 14, allTimes,
                20.00, EncounterMethod.WALKING, allVersions, route35));
        newEncounters.add(new Encounter(abra, 10, 10, allTimes,
                10.00, EncounterMethod.WALKING, allVersions, route35));
        newEncounters.add(new Encounter(pidgey, 14, 14, allTimes,
                5.00, EncounterMethod.WALKING, allVersions, route35));
        newEncounters.add(new Encounter(ditto, 10, 10, allTimes,
                4.00, EncounterMethod.WALKING, allVersions, route35));
        newEncounters.add(new Encounter(yanma, 12, 12, allTimes,
                1.00, EncounterMethod.WALKING, allVersions, route35));

        newEncounters.add(new Encounter(psyduck, 5, 20, allTimes,
                90.00, EncounterMethod.SURFING, allVersions, route35));
        newEncounters.add(new Encounter(golduck, 10, 20, allTimes,
                10.00, EncounterMethod.SURFING, allVersions, route35));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, route35));
        newEncounters.add(new Encounter(golduck, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, route35));
        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, route35));
        newEncounters.add(new Encounter(golduck, 20, 20, allTimes,
                40.00, EncounterMethod.GOOD_ROD, allVersions, route35));
        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes,
                93.00, EncounterMethod.SUPER_ROD, allVersions, route35));
        newEncounters.add(new Encounter(golduck, 40, 40, allTimes,
                7.00, EncounterMethod.SUPER_ROD, allVersions, route35));

        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                route35.addEncounter(encounter);

        locationService.saveLocation(route35);
    }

    @Transactional
    protected void initializeRoute36() {
        newEncounters = new ArrayList<>();
        Location route36 = locationService.getLocationByName("Route 36");

        Pokemon nidoranF = pokemonService.getByName("nidoran-f");
        Pokemon nidoranM = pokemonService.getByName("nidoran-m");
        Pokemon vulpix = pokemonService.getByName("vulpix");
        Pokemon pidgey = pokemonService.getByName("pidgey");
        Pokemon growlithe = pokemonService.getByName("growlithe");
        Pokemon stantler = pokemonService.getByName("stantler");
        Pokemon hoothoot = pokemonService.getByName("hoothoot");

        newEncounters.add(new Encounter(nidoranF, 12, 12, allTimes,
                30.00, EncounterMethod.WALKING, allVersions, route36));
        newEncounters.add(new Encounter(nidoranM, 12, 12, allTimes,
                30.00, EncounterMethod.WALKING, allVersions, route36));
        newEncounters.add(new Encounter(stantler, 12, 12, allTimes,
                5.00, EncounterMethod.WALKING, allVersions, route36));

        newEncounters.add(new Encounter(growlithe, 13, 13, morning,
                10.00, EncounterMethod.WALKING, heartGold, route36));
        newEncounters.add(new Encounter(growlithe, 13, 13, night,
                10.00, EncounterMethod.WALKING, heartGold, route36));
        newEncounters.add(new Encounter(growlithe, 13, 15, day,
                15.00, EncounterMethod.WALKING, heartGold, route36));
        newEncounters.add(new Encounter(vulpix, 13, 13, morning,
                10.00, EncounterMethod.WALKING, soulSilver, route36));
        newEncounters.add(new Encounter(vulpix, 13, 13, night,
                10.00, EncounterMethod.WALKING, soulSilver, route36));
        newEncounters.add(new Encounter(vulpix, 13, 15, day,
                15.00, EncounterMethod.WALKING, soulSilver, route36));
        newEncounters.add(new Encounter(stantler, 13, 13, allTimes,
                25.00, EncounterMethod.WALKING, allVersions, route36));
        newEncounters.add(new Encounter(pidgey, 12, 15, morning,
                25.00, EncounterMethod.WALKING, allVersions, route36));
        newEncounters.add(new Encounter(pidgey, 12, 15, day,
                20.00, EncounterMethod.WALKING, allVersions, route36));
        newEncounters.add(new Encounter(hoothoot, 13, 15, night,
                25.00, EncounterMethod.WALKING, allVersions, route36));

        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                route36.addEncounter(encounter);

        locationService.saveLocation(route36);
    }

    @Transactional
    protected void initializeRoute37() {

        newEncounters = new ArrayList<>();
        Location route37 = locationService.getLocationByName("Route 37");

        Pokemon vulpix = pokemonService.getByName("vulpix");
        Pokemon growlithe = pokemonService.getByName("growlithe");
        Pokemon stantler = pokemonService.getByName("stantler");
        Pokemon ledyba = pokemonService.getByName("ledyba");
        Pokemon pidgey = pokemonService.getByName("pidgey");
        Pokemon pidgeotto = pokemonService.getByName("pidgeotto");
        Pokemon spinarak = pokemonService.getByName("spinarak");
        Pokemon hoothoot = pokemonService.getByName("hoothoot");


        newEncounters.add(new Encounter(pidgey, 13, 15, morning,
                60.00, EncounterMethod.WALKING, heartGold, route37));
        newEncounters.add(new Encounter(pidgey, 15, 15, morning,
                20.00, EncounterMethod.WALKING, soulSilver, route37));
        newEncounters.add(new Encounter(growlithe, 14, 14, morning,
                10.00, EncounterMethod.WALKING, heartGold, route37));
        newEncounters.add(new Encounter(vulpix, 14, 14, morning,
                10.00, EncounterMethod.WALKING, soulSilver, route37));
        newEncounters.add(new Encounter(ledyba, 13, 15, morning,
                40.00, EncounterMethod.WALKING, soulSilver, route37));

        newEncounters.add(new Encounter(vulpix, 14, 15, day,
                15.00, EncounterMethod.WALKING, soulSilver, route37));
        newEncounters.add(new Encounter(growlithe, 14, 15, day,
                15.00, EncounterMethod.WALKING, heartGold, route37));
        newEncounters.add(new Encounter(pidgeotto, 15, 15, day,
                5.00, EncounterMethod.WALKING, allVersions, route37));
        newEncounters.add(new Encounter(pidgey, 13, 15, day,
                50.00, EncounterMethod.WALKING, allVersions, route37));
        newEncounters.add(new Encounter(stantler, 15, 15, allTimes,
                30.00, EncounterMethod.WALKING, allVersions, route37));

        newEncounters.add(new Encounter(hoothoot, 15, 15, night,
                20.00, EncounterMethod.WALKING, heartGold, route37));
        newEncounters.add(new Encounter(hoothoot, 13, 15, night,
                60.00, EncounterMethod.WALKING, soulSilver, route37));
        newEncounters.add(new Encounter(growlithe, 12, 12, night,
                10.00, EncounterMethod.WALKING, soulSilver, route37));
        newEncounters.add(new Encounter(vulpix, 12, 12, night,
                10.00, EncounterMethod.WALKING, soulSilver, route37));
        newEncounters.add(new Encounter(vulpix, 14, 14, night,
                10.00, EncounterMethod.WALKING, heartGold, route37));
        newEncounters.add(new Encounter(growlithe, 14, 14, night,
                10.00, EncounterMethod.WALKING, soulSilver, route37));
        newEncounters.add(new Encounter(spinarak, 13, 15, night,
                40.00, EncounterMethod.WALKING, heartGold, route37));

        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                route37.addEncounter(encounter);

        locationService.saveLocation(route37);

    }

    @Transactional
    protected void initializeRoute38() {



    }

    @Transactional
    protected void initializeSproutTower() {
        Location sproutTower = locationService.getLocationByName("Sprout Tower");
        Pokemon gastly = pokemonService.getByName("gastly");
        Pokemon rattata = pokemonService.getByName("rattata");

        newEncounters = new ArrayList<>();

        newEncounters.add(new Encounter(rattata, 3, 6, morning, 100.00,
                EncounterMethod.WALKING, allVersions, sproutTower));
        newEncounters.add(new Encounter(rattata, 3, 6, night, 15.00,
                EncounterMethod.WALKING, allVersions, sproutTower));
        newEncounters.add(new Encounter(gastly, 3, 6, night, 85.00,
                EncounterMethod.WALKING, allVersions, sproutTower));

        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                sproutTower.addEncounter(encounter);

        locationService.saveLocation(sproutTower);
    }
}
