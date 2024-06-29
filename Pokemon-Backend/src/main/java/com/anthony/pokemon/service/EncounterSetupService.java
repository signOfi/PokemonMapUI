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
        initializeRoute38();
        initializeRoute39();
        initializeRoute40();
        initializeRoute41();
        initializeRoute42();
        initializeRoute43();
        initializeRoute44();
        initializeRoute45();
        initializeRoute46();
        initializeRoute47();
        initializeRoute48();
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

        newEncounters = new ArrayList<>();
        Location route38 = locationService.getLocationByName("Route 38");

        Pokemon rattata = pokemonService.getByName("rattata");
        Pokemon raticate = pokemonService.getByName("raticate");
        Pokemon magnemite = pokemonService.getByName("magnemite");
        Pokemon farfetch = pokemonService.getByName("farfetchd");
        Pokemon miltank = pokemonService.getByName("miltank");
        Pokemon tauros = pokemonService.getByName("tauros");
        Pokemon snubbull = pokemonService.getByName("snubbull");
        Pokemon meowth = pokemonService.getByName("meowth");


        newEncounters.add(new Encounter(snubbull, 13, 13, allTimes,
                1.00, EncounterMethod.WALKING, allVersions, route38));
        newEncounters.add(new Encounter(tauros, 13, 13, allTimes,
                4.00, EncounterMethod.WALKING, allVersions, route38));
        newEncounters.add(new Encounter(miltank, 13, 13, allTimes,
                5.00, EncounterMethod.WALKING, allVersions, route38));
        newEncounters.add(new Encounter(farfetch, 16, 16, allTimes,
                5.00, EncounterMethod.WALKING, allVersions, route38));
        newEncounters.add(new Encounter(magnemite, 16, 16, allTimes,
                5.00, EncounterMethod.WALKING, allVersions, route38));
        newEncounters.add(new Encounter(raticate, 16, 16, allTimes,
                30.00, EncounterMethod.WALKING, allVersions, route38));
        newEncounters.add(new Encounter(meowth, 16, 16, allTimes,
                30.00, EncounterMethod.WALKING, soulSilver, route38));
        newEncounters.add(new Encounter(rattata, 16, 16, allTimes,
                30.00, EncounterMethod.WALKING, heartGold, route38));


        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                route38.addEncounter(encounter);

        locationService.saveLocation(route38);
    }

    @Transactional
    protected void initializeRoute39() {
        newEncounters = new ArrayList<>();
        Location route39 = locationService.getLocationByName("Route 39");

        Pokemon rattata = pokemonService.getByName("rattata");
        Pokemon raticate = pokemonService.getByName("raticate");
        Pokemon magnemite = pokemonService.getByName("magnemite");
        Pokemon farfetch = pokemonService.getByName("farfetchd");
        Pokemon miltank = pokemonService.getByName("miltank");
        Pokemon tauros = pokemonService.getByName("tauros");
        Pokemon meowth = pokemonService.getByName("meowth");

        newEncounters.add(new Encounter(tauros, 13, 13, allTimes,
                5.00, EncounterMethod.WALKING, heartGold, route39));
        newEncounters.add(new Encounter(tauros, 15, 15, allTimes,
                5.00, EncounterMethod.WALKING, soulSilver, route39));

        newEncounters.add(new Encounter(miltank, 13, 13, allTimes,
                5.00, EncounterMethod.WALKING, heartGold, route39));
        newEncounters.add(new Encounter(miltank, 15, 15, allTimes,
                5.00, EncounterMethod.WALKING, soulSilver, route39));

        newEncounters.add(new Encounter(farfetch, 16, 16, morningDay,
                10.00, EncounterMethod.WALKING, allVersions, route39));

        newEncounters.add(new Encounter(magnemite, 16, 16, allTimes,
                20.00, EncounterMethod.WALKING, allVersions, route39));


        newEncounters.add(new Encounter(raticate, 16, 16, allTimes,
                30.00, EncounterMethod.WALKING, heartGold, route39));
        newEncounters.add(new Encounter(raticate, 17, 17, allTimes,
                30.00, EncounterMethod.WALKING, soulSilver, route39));


        newEncounters.add(new Encounter(meowth, 16, 16, morningDay,
                30.00, EncounterMethod.WALKING, soulSilver, route39));
        newEncounters.add(new Encounter(meowth, 16, 16, night,
                40.00, EncounterMethod.WALKING, soulSilver, route39));

        newEncounters.add(new Encounter(rattata, 16, 16, allTimes,
                30.00, EncounterMethod.WALKING, heartGold, route39));
        newEncounters.add(new Encounter(rattata, 16, 16, allTimes,
                40.00, EncounterMethod.WALKING, heartGold, route39));

        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                route39.addEncounter(encounter);

        locationService.saveLocation(route39);
    }

    @Transactional
    protected void initializeRoute40() {

        newEncounters = new ArrayList<>();
        Location route40 = locationService.getLocationByName("Route 40");

        Pokemon magikarp = pokemonService.getByName("magikarp");
        Pokemon krabby = pokemonService.getByName("krabby");
        Pokemon kingler = pokemonService.getByName("kingler");
        Pokemon tentacool = pokemonService.getByName("tentacool");
        Pokemon tentacruel = pokemonService.getByName("tentacruel");
        Pokemon corsola = pokemonService.getByName("corsola");
        Pokemon staryu = pokemonService.getByName("staryu");

        newEncounters.add(new Encounter(tentacool, 10, 25, allTimes,
                90.00, EncounterMethod.SURFING, allVersions, route40));
        newEncounters.add(new Encounter(tentacruel, 15, 29, allTimes,
                10.00, EncounterMethod.SURFING, allVersions, route40));


        newEncounters.add(new Encounter(tentacool, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, route40));
        newEncounters.add(new Encounter(tentacruel, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, route40));


        newEncounters.add(new Encounter(magikarp, 20, 20, morningDay,
                60.00, EncounterMethod.GOOD_ROD, allVersions, route40));
        newEncounters.add(new Encounter(krabby, 20, 20, morningDay,
                37.00, EncounterMethod.GOOD_ROD, allVersions, route40));
        newEncounters.add(new Encounter(corsola, 20, 20, morningDay,
                3.00, EncounterMethod.GOOD_ROD, allVersions, route40));
        newEncounters.add(new Encounter(magikarp, 20, 20, night,
                60.00, EncounterMethod.GOOD_ROD, allVersions, route40));
        newEncounters.add(new Encounter(krabby, 20, 20, night,
                37.00, EncounterMethod.GOOD_ROD, allVersions, route40));
        newEncounters.add(new Encounter(staryu, 20, 20, night,
                3.00, EncounterMethod.GOOD_ROD, allVersions, route40));

        newEncounters.add(new Encounter(krabby, 40, 40, morningDay,
                60.00, EncounterMethod.SUPER_ROD, allVersions, route40));
        newEncounters.add(new Encounter(corsola, 40, 40, morningDay,
                37.00, EncounterMethod.SUPER_ROD, allVersions, route40));
        newEncounters.add(new Encounter(kingler, 40, 40, morningDay,
                3.00, EncounterMethod.SUPER_ROD, allVersions, route40));
        newEncounters.add(new Encounter(krabby, 40, 40, night,
                60.00, EncounterMethod.SUPER_ROD, allVersions, route40));
        newEncounters.add(new Encounter(staryu, 40, 40, night,
                37.00, EncounterMethod.SUPER_ROD, allVersions, route40));
        newEncounters.add(new Encounter(kingler, 40, 40, night,
                3.00, EncounterMethod.SUPER_ROD, allVersions, route40));


        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                route40.addEncounter(encounter);

        locationService.saveLocation(route40);

    }

    @Transactional
    protected void initializeRoute41() {

        newEncounters = new ArrayList<>();
        Location route41 = locationService.getLocationByName("Route 41");

        Pokemon mantine = pokemonService.getByName("mantine");
        Pokemon magikarp = pokemonService.getByName("magikarp");
        Pokemon chinchou = pokemonService.getByName("chinchou");
        Pokemon tentacool = pokemonService.getByName("tentacool");
        Pokemon tentacruel = pokemonService.getByName("tentacruel");
        Pokemon shellder = pokemonService.getByName("shellder");
        Pokemon lanturn = pokemonService.getByName("lanturn");

        newEncounters.add(new Encounter(tentacool, 15, 25, allTimes,
                60.00, EncounterMethod.SURFING, allVersions, route41));

        newEncounters.add(new Encounter(tentacruel, 15, 25, allTimes,
                30.00, EncounterMethod.SURFING, heartGold, route41));
        newEncounters.add(new Encounter(tentacruel, 15, 25, allTimes,
                40.00, EncounterMethod.SURFING, soulSilver, route41));

        newEncounters.add(new Encounter(mantine, 15, 25, allTimes,
                10.00, EncounterMethod.SURFING, heartGold, route41));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, heartGold, route41));
        newEncounters.add(new Encounter(tentacool, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, soulSilver, route41));


        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, route41));
        newEncounters.add(new Encounter(tentacool, 20, 20, allTimes,
                30.00, EncounterMethod.GOOD_ROD, allVersions, route41));
        newEncounters.add(new Encounter(chinchou, 20, 20, allTimes,
                7.00, EncounterMethod.GOOD_ROD, allVersions, route41));
        newEncounters.add(new Encounter(shellder, 20, 20, allTimes,
                3.00, EncounterMethod.GOOD_ROD, allVersions, route41));

        newEncounters.add(new Encounter(chinchou, 40, 40, allTimes,
                60.00, EncounterMethod.SUPER_ROD, allVersions, route41));
        newEncounters.add(new Encounter(shellder, 40, 40, allTimes,
                30.00, EncounterMethod.SUPER_ROD, allVersions, route41));
        newEncounters.add(new Encounter(tentacruel, 40, 40, allTimes,
                7.00, EncounterMethod.SUPER_ROD, allVersions, route41));
        newEncounters.add(new Encounter(lanturn, 40, 40, allTimes,
                3.00, EncounterMethod.SUPER_ROD, allVersions, route41));


        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                route41.addEncounter(encounter);

        locationService.saveLocation(route41);
    }

    @Transactional
    protected void initializeRoute42() {
        newEncounters = new ArrayList<>();
        Location route42 = locationService.getLocationByName("Route 42");


        Pokemon magikarp = pokemonService.getByName("magikarp");
        Pokemon goldeen = pokemonService.getByName("goldeen");
        Pokemon seaking = pokemonService.getByName("seaking");
        Pokemon spearow = pokemonService.getByName("spearow");
        Pokemon mankey = pokemonService.getByName("mankey");
        Pokemon mareep = pokemonService.getByName("mareep");
        Pokemon flaaffy = pokemonService.getByName("flaaffy");
        Pokemon zubat = pokemonService.getByName("zubat");

        newEncounters.add(new Encounter(spearow, 14, 16, morningDay,
                30.00, EncounterMethod.WALKING, heartGold, route42));
        newEncounters.add(new Encounter(mankey, 15, 15, allTimes,
                30.00, EncounterMethod.WALKING, heartGold, route42));
        newEncounters.add(new Encounter(mareep, 13, 13, allTimes,
                30.00, EncounterMethod.WALKING, heartGold, route42));
        newEncounters.add(new Encounter(flaaffy, 15, 17, allTimes,
                10.00, EncounterMethod.WALKING, heartGold, route42));

        newEncounters.add(new Encounter(mareep, 13, 15, allTimes,
                50.00, EncounterMethod.WALKING, soulSilver, route42));
        newEncounters.add(new Encounter(spearow, 14, 16, morningDay,
                40.00, EncounterMethod.WALKING, soulSilver, route42));
        newEncounters.add(new Encounter(flaaffy, 15, 17, allTimes,
                10.00, EncounterMethod.WALKING, soulSilver, route42));

        newEncounters.add(new Encounter(zubat, 14, 16, night,
                30.00, EncounterMethod.WALKING, heartGold, route42));
        newEncounters.add(new Encounter(zubat, 14, 16, night,
                40.00, EncounterMethod.WALKING, soulSilver, route42));


        newEncounters.add(new Encounter(goldeen, 15, 25, allTimes,
                90.00, EncounterMethod.SURFING, allVersions, route42));
        newEncounters.add(new Encounter(seaking, 15, 25, allTimes,
                10.00, EncounterMethod.SURFING, allVersions, route42));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, route42));
        newEncounters.add(new Encounter(goldeen, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, route42));
        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, route42));
        newEncounters.add(new Encounter(goldeen, 20, 20, allTimes,
                40.00, EncounterMethod.GOOD_ROD, allVersions, route42));
        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes,
                90.00, EncounterMethod.SUPER_ROD, allVersions, route42));
        newEncounters.add(new Encounter(goldeen, 40, 40, allTimes,
                7.00, EncounterMethod.SUPER_ROD, allVersions, route42));
        newEncounters.add(new Encounter(seaking, 40, 40, allTimes,
                3.00, EncounterMethod.SUPER_ROD, allVersions, route42));


        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                route42.addEncounter(encounter);

        locationService.saveLocation(route42);
    }

    @Transactional
    protected void initializeRoute43() {

        newEncounters = new ArrayList<>();
        Location route43 = locationService.getLocationByName("Route 43");


        Pokemon magikarp = pokemonService.getByName("magikarp");
        Pokemon poliwag = pokemonService.getByName("poliwag");
        Pokemon flaaffy = pokemonService.getByName("flaaffy");
        Pokemon mareep = pokemonService.getByName("mareep");
        Pokemon pidgeotto = pokemonService.getByName("pidgeotto");
        Pokemon girafarig = pokemonService.getByName("girafarig");
        Pokemon venonat = pokemonService.getByName("venonat");
        Pokemon noctowl = pokemonService.getByName("noctowl");


        newEncounters.add(new Encounter(flaaffy, 15, 15, morning,
                30.00, EncounterMethod.WALKING, allVersions, route43));
        newEncounters.add(new Encounter(girafarig, 15, 15, morning,
                30.00, EncounterMethod.WALKING, allVersions, route43));
        newEncounters.add(new Encounter(pidgeotto, 17, 17, morning,
                25.00, EncounterMethod.WALKING, allVersions, route43));
        newEncounters.add(new Encounter(mareep, 15, 15, morning,
                10.00, EncounterMethod.WALKING, allVersions, route43));
        newEncounters.add(new Encounter(venonat, 16, 16, morning,
                5.00, EncounterMethod.WALKING, allVersions, route43));

        newEncounters.add(new Encounter(flaaffy, 15, 17, day,
                40.00, EncounterMethod.WALKING, allVersions, route43));
        newEncounters.add(new Encounter(girafarig, 15, 15, day,
                30.00, EncounterMethod.WALKING, allVersions, route43));
        newEncounters.add(new Encounter(pidgeotto, 17, 17, day,
                20.00, EncounterMethod.WALKING, allVersions, route43));
        newEncounters.add(new Encounter(mareep, 15, 15, day,
                10.00, EncounterMethod.WALKING, allVersions, route43));

        newEncounters.add(new Encounter(flaaffy, 15, 15, night,
                30.00, EncounterMethod.WALKING, allVersions, route43));
        newEncounters.add(new Encounter(girafarig, 15, 15, night,
                30.00, EncounterMethod.WALKING, allVersions, route43));
        newEncounters.add(new Encounter(noctowl, 17, 17, night,
                20.00, EncounterMethod.WALKING, allVersions, route43));
        newEncounters.add(new Encounter(venonat, 15, 17, night,
                15.00, EncounterMethod.WALKING, allVersions, route43));
        newEncounters.add(new Encounter(mareep, 16, 16, night,
                5.00, EncounterMethod.WALKING, allVersions, route43));

        newEncounters.add(new Encounter(magikarp, 5, 50, allTimes,
                100.00, EncounterMethod.SURFING, allVersions, route43));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, route43));
        newEncounters.add(new Encounter(poliwag, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, route43));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, route43));
        newEncounters.add(new Encounter(poliwag, 20, 20, allTimes,
                40.00, EncounterMethod.GOOD_ROD, allVersions, route43));

        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes,
                93.00, EncounterMethod.SUPER_ROD, allVersions, route43));
        newEncounters.add(new Encounter(poliwag, 40, 40, allTimes,
                7.00, EncounterMethod.SUPER_ROD, allVersions, route43));


        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                route43.addEncounter(encounter);

        locationService.saveLocation(route43);

    }

    @Transactional
    protected void initializeRoute44() {
        newEncounters = new ArrayList<>();
        Location route44 = locationService.getLocationByName("Route 44");


        Pokemon weepinbell = pokemonService.getByName("weepinbell");
        Pokemon tangela = pokemonService.getByName("tangela");
        Pokemon bellsprout = pokemonService.getByName("bellsprout");
        Pokemon lickitung = pokemonService.getByName("lickitung");
        Pokemon poliwag = pokemonService.getByName("poliwag");
        Pokemon poliwhirl = pokemonService.getByName("poliwhirl");
        Pokemon magikarp = pokemonService.getByName("magikarp");
        Pokemon remoraid = pokemonService.getByName("remoraid");

        newEncounters.add(new Encounter(weepinbell, 22, 24, allTimes,
                35.00, EncounterMethod.WALKING, allVersions, route44));
        newEncounters.add(new Encounter(tangela, 23, 23, allTimes,
                30.00, EncounterMethod.WALKING, allVersions, route44));
        newEncounters.add(new Encounter(bellsprout, 22, 22, allTimes,
                20.00, EncounterMethod.WALKING, allVersions, route44));
        newEncounters.add(new Encounter(lickitung, 24, 26, allTimes,
                15.00, EncounterMethod.WALKING, allVersions, route44));

        newEncounters.add(new Encounter(poliwag, 10, 25, allTimes,
                90.00, EncounterMethod.SURFING, allVersions, route44));
        newEncounters.add(new Encounter(poliwhirl, 15, 32, allTimes,
                10.00, EncounterMethod.SURFING, allVersions, route44));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, route44));
        newEncounters.add(new Encounter(poliwag, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, route44));

        newEncounters.add(new Encounter(poliwag, 20, 20, allTimes,
                38.00, EncounterMethod.GOOD_ROD, allVersions, route44));
        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, route44));
        newEncounters.add(new Encounter(remoraid, 20, 20, allTimes,
                2.00, EncounterMethod.GOOD_ROD, allVersions, route44));

        newEncounters.add(new Encounter(poliwag, 40, 40, allTimes,
                90.00, EncounterMethod.SUPER_ROD, allVersions, route44));
        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes,
                7.00, EncounterMethod.SUPER_ROD, allVersions, route44));
        newEncounters.add(new Encounter(remoraid, 40, 40, allTimes,
                2.00, EncounterMethod.SUPER_ROD, allVersions, route44));



        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                route44.addEncounter(encounter);

        locationService.saveLocation(route44);
    }

    @Transactional
    protected void initializeRoute45() {

        newEncounters = new ArrayList<>();
        Location route45 = locationService.getLocationByName("Route 45");

        Pokemon graveler = pokemonService.getByName("graveler");
        Pokemon geodude = pokemonService.getByName("geodude");
        Pokemon gligar = pokemonService.getByName("gligar");
        Pokemon phanpy = pokemonService.getByName("phanpy");
        Pokemon teddiursa = pokemonService.getByName("teddiursa");
        Pokemon skarmory = pokemonService.getByName("skarmory");
        Pokemon magikarp = pokemonService.getByName("magikarp");
        Pokemon poliwag = pokemonService.getByName("poliwag");

        newEncounters.add(new Encounter(graveler, 23, 27, allTimes,
                40.00, EncounterMethod.WALKING, heartGold, route45));
        newEncounters.add(new Encounter(geodude, 23, 23, allTimes,
                30.00, EncounterMethod.WALKING, heartGold, route45));
        newEncounters.add(new Encounter(gligar, 24, 24, allTimes,
                20.00, EncounterMethod.WALKING, heartGold, route45));
        newEncounters.add(new Encounter(phanpy, 20, 20, allTimes,
                10.00, EncounterMethod.WALKING, heartGold, route45));

        newEncounters.add(new Encounter(graveler, 23, 25, allTimes,
                55.00, EncounterMethod.WALKING, soulSilver, route45));
        newEncounters.add(new Encounter(geodude, 23, 23, allTimes,
                30.00, EncounterMethod.WALKING, soulSilver, route45));
        newEncounters.add(new Encounter(teddiursa, 20, 20, allTimes,
                10.00, EncounterMethod.WALKING, soulSilver, route45));
        newEncounters.add(new Encounter(skarmory, 27, 27, allTimes,
                5.00, EncounterMethod.WALKING, soulSilver, route45));


        newEncounters.add(new Encounter(magikarp, 2, 20, allTimes,
                100.00, EncounterMethod.SURFING, allVersions, route45));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, route45));
        newEncounters.add(new Encounter(poliwag, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, route45));
        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, route45));
        newEncounters.add(new Encounter(poliwag, 20, 20, allTimes,
                40.00, EncounterMethod.GOOD_ROD, allVersions, route45));
        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes,
                93.00, EncounterMethod.SUPER_ROD, allVersions, route45));
        newEncounters.add(new Encounter(poliwag, 40, 40, allTimes,
                7.00, EncounterMethod.SUPER_ROD, allVersions, route45));

        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                route45.addEncounter(encounter);

        locationService.saveLocation(route45);

    }

    @Transactional
    protected void initializeRoute46() {

        newEncounters = new ArrayList<>();
        Location route46 = locationService.getLocationByName("Route 46");

        Pokemon geodude = pokemonService.getByName("geodude");
        Pokemon spearow = pokemonService.getByName("spearow");
        Pokemon rattata = pokemonService.getByName("rattata");

        newEncounters.add(new Encounter(geodude, 2, 3, morningDay,
                40.00, EncounterMethod.WALKING, allVersions, route46));
        newEncounters.add(new Encounter(spearow, 2, 3, morningDay,
                35.00, EncounterMethod.WALKING, allVersions, route46));
        newEncounters.add(new Encounter(rattata, 2, 4, morningDay,
                25.00, EncounterMethod.WALKING, allVersions, route46));

        newEncounters.add(new Encounter(geodude, 2, 3, night,
                55.00, EncounterMethod.WALKING, allVersions, route46));
        newEncounters.add(new Encounter(rattata, 2, 4, night,
                45.00, EncounterMethod.WALKING, allVersions, route46));


        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                route46.addEncounter(encounter);

        locationService.saveLocation(route46);

    }

    @Transactional
    protected void initializeRoute47() {
        newEncounters = new ArrayList<>();
        Location route47 = locationService.getLocationByName("Route 47");

        Pokemon ditto = pokemonService.getByName("ditto");
        Pokemon farfetch = pokemonService.getByName("farfetchd");
        Pokemon miltank = pokemonService.getByName("miltank");
        Pokemon raticate = pokemonService.getByName("raticate");
        Pokemon spearow = pokemonService.getByName("spearow");
        Pokemon gloom = pokemonService.getByName("gloom");
        Pokemon fearow = pokemonService.getByName("fearow");
        Pokemon noctowl = pokemonService.getByName("noctowl");
        Pokemon tentacool = pokemonService.getByName("tentacool");
        Pokemon seel = pokemonService.getByName("seel");
        Pokemon staryu = pokemonService.getByName("staryu");
        Pokemon magikarp = pokemonService.getByName("magikarp");
        Pokemon chinchou = pokemonService.getByName("chinchou");
        Pokemon shellder = pokemonService.getByName("shellder");
        Pokemon tentacruel = pokemonService.getByName("tentacruel");
        Pokemon lanturn = pokemonService.getByName("lanturn");

        newEncounters.add(new Encounter(ditto, 31, 40, allTimes,
                41.00, EncounterMethod.WALKING, allVersions, route47));
        newEncounters.add(new Encounter(farfetch, 35, 35, morningDay,
                20.00, EncounterMethod.WALKING, allVersions, route47));
        newEncounters.add(new Encounter(miltank, 35, 35, allTimes,
                20.00, EncounterMethod.WALKING, allVersions, route47));
        newEncounters.add(new Encounter(raticate, 31, 33, allTimes,
                5.00, EncounterMethod.WALKING, allVersions, route47));
        newEncounters.add(new Encounter(spearow, 31, 31, allTimes,
                5.00, EncounterMethod.WALKING, allVersions, route47));
        newEncounters.add(new Encounter(gloom, 32, 32, allTimes,
                5.00, EncounterMethod.WALKING, allVersions, route47));
        newEncounters.add(new Encounter(fearow, 34, 34, allTimes,
                4.00, EncounterMethod.WALKING, allVersions, route47));
        newEncounters.add(new Encounter(noctowl, 35, 35, night,
                20.00, EncounterMethod.WALKING, allVersions, route47));

        newEncounters.add(new Encounter(tentacool, 15, 25, allTimes,
                60.00, EncounterMethod.SURFING, allVersions, route47));
        newEncounters.add(new Encounter(seel, 10, 20, allTimes,
                30.00, EncounterMethod.SURFING, allVersions, route47));
        newEncounters.add(new Encounter(staryu, 15, 25, allTimes,
                10.00, EncounterMethod.SURFING, allVersions, route47));


        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, route47));
        newEncounters.add(new Encounter(tentacool, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, route47));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, route47));
        newEncounters.add(new Encounter(tentacool, 20, 20, allTimes,
                30.00, EncounterMethod.GOOD_ROD, allVersions, route47));
        newEncounters.add(new Encounter(chinchou, 20, 20, allTimes,
                7.00, EncounterMethod.GOOD_ROD, allVersions, route47));
        newEncounters.add(new Encounter(shellder, 20, 20, allTimes,
                3.00, EncounterMethod.GOOD_ROD, allVersions, route47));

        newEncounters.add(new Encounter(chinchou, 40, 40, allTimes,
                60.00, EncounterMethod.SUPER_ROD, allVersions, route47));
        newEncounters.add(new Encounter(shellder, 40, 40, allTimes,
                30.00, EncounterMethod.SUPER_ROD, allVersions, route47));
        newEncounters.add(new Encounter(tentacruel, 40, 40, allTimes,
                7.00, EncounterMethod.SUPER_ROD, allVersions, route47));
        newEncounters.add(new Encounter(lanturn, 40, 40, allTimes,
                3.00, EncounterMethod.SUPER_ROD, allVersions, route47));


        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                route47.addEncounter(encounter);

        locationService.saveLocation(route47);
    }

    @Transactional
    protected void initializeRoute48() {
        newEncounters = new ArrayList<>();
        Location route48 = locationService.getLocationByName("Route 48");

        Pokemon tauros = pokemonService.getByName("tauros");
        Pokemon gloom = pokemonService.getByName("gloom");
        Pokemon farfetch = pokemonService.getByName("farfetchd");
        Pokemon hoppip = pokemonService.getByName("hoppip");
        Pokemon fearow = pokemonService.getByName("fearow");
        Pokemon growlithe = pokemonService.getByName("growlithe");
        Pokemon girafarig = pokemonService.getByName("girafarig");
        Pokemon diglett = pokemonService.getByName("diglett");
        Pokemon vulpix = pokemonService.getByName("vulpix");

        newEncounters.add(new Encounter(tauros, 20, 20, allTimes,
                21.00, EncounterMethod.WALKING, allVersions, route48));
        newEncounters.add(new Encounter(gloom, 22, 24, allTimes,
                20.00, EncounterMethod.WALKING, allVersions, route48));
        newEncounters.add(new Encounter(farfetch, 25, 25, morningDay,
                20.00, EncounterMethod.WALKING, allVersions, route48));
        newEncounters.add(new Encounter(hoppip, 20, 20, allTimes,
                11.00, EncounterMethod.WALKING, allVersions, route48));
        newEncounters.add(new Encounter(fearow, 21, 21, allTimes,
                10.00, EncounterMethod.WALKING, allVersions, route48));
        newEncounters.add(new Encounter(girafarig, 20, 20, allTimes,
                5.00, EncounterMethod.WALKING, allVersions, route48));
        newEncounters.add(new Encounter(diglett, 20, 20, allTimes,
                4.00, EncounterMethod.WALKING, allVersions, route48));

        newEncounters.add(new Encounter(growlithe, 21, 21, morningDay,
                9.00, EncounterMethod.WALKING, heartGold, route48));
        newEncounters.add(new Encounter(growlithe, 21, 21, morningDay,
                9.00, EncounterMethod.WALKING, soulSilver, route48));
        newEncounters.add(new Encounter(growlithe, 21, 25, night,
                29.00, EncounterMethod.WALKING, heartGold, route48));
        newEncounters.add(new Encounter(growlithe, 21, 25, night,
                29.00, EncounterMethod.WALKING, soulSilver, route48));



        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                route48.addEncounter(encounter);

        locationService.saveLocation(route48);
    }

    @Transactional
    protected void initializeIcePath() {
        newEncounters = new ArrayList<>();
        Location icePath = locationService.getLocationByName("Ice Path");

        Pokemon swinub = pokemonService.getByName("swinub");
        Pokemon golbat = pokemonService.getByName("golbat");
        Pokemon zubat = pokemonService.getByName("zubat");
        Pokemon jynx = pokemonService.getByName("jynx");
        Pokemon delibird = pokemonService.getByName("delibird");

        newEncounters.add(new Encounter(swinub, 22, 24, allTimes,
                40.00, EncounterMethod.WALKING, allVersions, icePath));
        newEncounters.add(new Encounter(golbat, 23, 23, allTimes,
                30.00, EncounterMethod.WALKING, allVersions, icePath));
        newEncounters.add(new Encounter(jynx, 23, 25, allTimes,
                5.00, EncounterMethod.WALKING, allVersions, icePath));

        newEncounters.add(new Encounter(zubat, 23, 23, morning,
                15.00, EncounterMethod.WALKING, heartGold, icePath));
        newEncounters.add(new Encounter(zubat, 23, 23, day,
                10.00, EncounterMethod.WALKING, heartGold, icePath));
        newEncounters.add(new Encounter(zubat, 23, 23, night,
                25.00, EncounterMethod.WALKING, heartGold, icePath));

        newEncounters.add(new Encounter(zubat, 23, 23, night,
                5.00, EncounterMethod.WALKING, soulSilver, icePath));
        newEncounters.add(new Encounter(delibird, 23, 23, allTimes,
                20.00, EncounterMethod.WALKING, soulSilver, icePath));


        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                icePath.addEncounter(encounter);

        locationService.saveLocation(icePath);
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
