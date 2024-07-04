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

    private final Set<GameVersion> heartGold;
    private final Set<GameVersion> soulSilver;

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
        initializeIcePath();
        initializeWhirlIslands();
        initializeUnionCave();
        initializeSlowpokeWell();
        initializeMtMortar();
        initializeRuinsOfAlph();
        initializeLakeOfRage();
        initializeIlexForest();
        initializeDragonsDen();
        initializeDarkCaveRoute31();
        initializeDarkCaveRoute45();
        initializeBurnedTower();
        initializeBellTower();
        initializeVioletCity();
        initializeSinjohRuins();
        initializeOlivineCity();
        initializeNewBarkTown();
        initializeGoldenRodCity();
        initializeEcruteakCity();
        initializeCliffCave();
        initializeCianwoodCity();
        initializeCherrygroveCity();
        initializeBlackthornCity();
        initializeRoute26();
        initializeRoute27();
        initializeTohjoFalls();
        initializeVictoryRoad();

        initializeRoute22();
        initializeRoute28();
        initializeMtSilver();
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
                5.00, EncounterMethod.WALKING, allVersions, route34));

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
                20.00, EncounterMethod.WALKING, allVersions, route38));
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

        newEncounters.add(new Encounter(rattata, 16, 16, morningDay,
                30.00, EncounterMethod.WALKING, heartGold, route39));
        newEncounters.add(new Encounter(rattata, 16, 16, night,
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
                40.00, EncounterMethod.WALKING, allVersions, icePath, "1F"));
        newEncounters.add(new Encounter(golbat, 23, 23, allTimes,
                30.00, EncounterMethod.WALKING, allVersions, icePath, "1F"));
        newEncounters.add(new Encounter(jynx, 23, 25, allTimes,
                5.00, EncounterMethod.WALKING, allVersions, icePath, "1F"));
        newEncounters.add(new Encounter(zubat, 23, 23, morning,
                15.00, EncounterMethod.WALKING, heartGold, icePath, "1F"));
        newEncounters.add(new Encounter(zubat, 23, 23, day,
                10.00, EncounterMethod.WALKING, heartGold, icePath, "1F"));
        newEncounters.add(new Encounter(zubat, 23, 23, night,
                25.00, EncounterMethod.WALKING, heartGold, icePath, "1F"));
        newEncounters.add(new Encounter(zubat, 23, 23, night,
                5.00, EncounterMethod.WALKING, soulSilver, icePath, "1F"));
        newEncounters.add(new Encounter(delibird, 23, 23, allTimes,
                20.00, EncounterMethod.WALKING, soulSilver, icePath, "1F"));

        newEncounters.add(new Encounter(swinub, 22, 24, allTimes,
                40.00, EncounterMethod.WALKING, allVersions, icePath, "B1F"));
        newEncounters.add(new Encounter(golbat, 23, 23, allTimes,
                30.00, EncounterMethod.WALKING, allVersions, icePath, "B1F"));
        newEncounters.add(new Encounter(jynx, 23, 25, allTimes,
                5.00, EncounterMethod.WALKING, allVersions, icePath, "B1F"));
        newEncounters.add(new Encounter(zubat, 23, 23, morning,
                15.00, EncounterMethod.WALKING, heartGold, icePath, "B1F"));
        newEncounters.add(new Encounter(zubat, 23, 23, day,
                10.00, EncounterMethod.WALKING, heartGold, icePath, "B1F"));
        newEncounters.add(new Encounter(zubat, 23, 23, night,
                25.00, EncounterMethod.WALKING, heartGold, icePath, "B1F"));
        newEncounters.add(new Encounter(zubat, 23, 23, night,
                5.00, EncounterMethod.WALKING, soulSilver, icePath, "B1F"));
        newEncounters.add(new Encounter(delibird, 23, 23, allTimes,
                20.00, EncounterMethod.WALKING, soulSilver, icePath, "B1F"));

        newEncounters.add(new Encounter(swinub, 22, 24, allTimes,
                40.00, EncounterMethod.WALKING, allVersions, icePath, "B2F"));
        newEncounters.add(new Encounter(golbat, 23, 23, allTimes,
                30.00, EncounterMethod.WALKING, allVersions, icePath, "B2F"));
        newEncounters.add(new Encounter(jynx, 23, 25, allTimes,
                5.00, EncounterMethod.WALKING, allVersions, icePath, "B2F"));
        newEncounters.add(new Encounter(zubat, 23, 23, morning,
                15.00, EncounterMethod.WALKING, heartGold, icePath, "B2F"));
        newEncounters.add(new Encounter(zubat, 23, 23, day,
                10.00, EncounterMethod.WALKING, heartGold, icePath, "B2F"));
        newEncounters.add(new Encounter(zubat, 23, 23, night,
                25.00, EncounterMethod.WALKING, heartGold, icePath, "B2F"));
        newEncounters.add(new Encounter(zubat, 23, 23, night,
                5.00, EncounterMethod.WALKING, soulSilver, icePath, "B2F"));
        newEncounters.add(new Encounter(delibird, 23, 23, allTimes,
                20.00, EncounterMethod.WALKING, soulSilver, icePath, "B2F"));

        newEncounters.add(new Encounter(swinub, 22, 24, allTimes,
                40.00, EncounterMethod.WALKING, allVersions, icePath, "B3F"));
        newEncounters.add(new Encounter(golbat, 23, 23, allTimes,
                30.00, EncounterMethod.WALKING, allVersions, icePath, "B3F"));
        newEncounters.add(new Encounter(jynx, 23, 25, allTimes,
                5.00, EncounterMethod.WALKING, allVersions, icePath, "B3F"));
        newEncounters.add(new Encounter(zubat, 23, 23, morning,
                15.00, EncounterMethod.WALKING, heartGold, icePath, "B3F"));
        newEncounters.add(new Encounter(zubat, 23, 23, day,
                10.00, EncounterMethod.WALKING, heartGold, icePath, "B3F"));
        newEncounters.add(new Encounter(zubat, 23, 23, night,
                25.00, EncounterMethod.WALKING, heartGold, icePath, "B3F"));
        newEncounters.add(new Encounter(zubat, 23, 23, night,
                5.00, EncounterMethod.WALKING, soulSilver, icePath, "B3F"));
        newEncounters.add(new Encounter(delibird, 23, 23, allTimes,
                20.00, EncounterMethod.WALKING, soulSilver, icePath, "B3F"));


        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                icePath.addEncounter(encounter);

        locationService.saveLocation(icePath);
    }

    @Transactional
    protected void initializeWhirlIslands() {
        newEncounters = new ArrayList<>();
        Location whirlIslands = locationService.getLocationByName("Whirl Islands");

        Pokemon krabby = pokemonService.getByName("krabby");
        Pokemon zubat = pokemonService.getByName("zubat");
        Pokemon seel = pokemonService.getByName("seel");
        Pokemon golbat = pokemonService.getByName("golbat");
        Pokemon tentacool = pokemonService.getByName("tentacool");
        Pokemon horsea = pokemonService.getByName("horsea");
        Pokemon tentacruel = pokemonService.getByName("tentacruel");
        Pokemon kingler = pokemonService.getByName("kingler");
        Pokemon seadra = pokemonService.getByName("seadra");
        Pokemon lugia = pokemonService.getByName("lugia");
        Pokemon magikarp = pokemonService.getByName("magikarp");

        newEncounters.add(new Encounter(krabby, 23, 25, allTimes,
                50.00, EncounterMethod.WALKING, allVersions, whirlIslands, "1F"));
        newEncounters.add(new Encounter(zubat, 24, 24, allTimes,
                30.00, EncounterMethod.WALKING, allVersions, whirlIslands, "1F"));
        newEncounters.add(new Encounter(seel, 23, 25, allTimes,
                15.00, EncounterMethod.WALKING, allVersions, whirlIslands, "1F"));
        newEncounters.add(new Encounter(golbat, 24, 24, allTimes,
                5.00, EncounterMethod.WALKING, allVersions, whirlIslands, "1F"));


        newEncounters.add(new Encounter(tentacool, 15, 25, allTimes,
                60.00, EncounterMethod.SURFING, allVersions, whirlIslands, "1F"));
        newEncounters.add(new Encounter(horsea, 10, 20, allTimes,
                30.00, EncounterMethod.SURFING, allVersions, whirlIslands, "1F"));
        newEncounters.add(new Encounter(tentacruel, 15, 25, allTimes,
                10.00, EncounterMethod.SURFING, allVersions, whirlIslands, "1F"));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, whirlIslands, "1F"));
        newEncounters.add(new Encounter(krabby, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, whirlIslands, "1F"));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, whirlIslands, "1F"));
        newEncounters.add(new Encounter(krabby, 20, 20, allTimes,
                37.00, EncounterMethod.GOOD_ROD, allVersions, whirlIslands, "1F"));
        newEncounters.add(new Encounter(horsea, 20, 20, allTimes,
                3.00, EncounterMethod.GOOD_ROD, allVersions, whirlIslands, "1F"));

        newEncounters.add(new Encounter(krabby, 40, 40, allTimes,
                60.00, EncounterMethod.SUPER_ROD, allVersions, whirlIslands, "1F"));
        newEncounters.add(new Encounter(horsea, 40, 40, allTimes,
                30.00, EncounterMethod.SUPER_ROD, allVersions, whirlIslands, "1F"));
        newEncounters.add(new Encounter(kingler, 40, 40, allTimes,
                7.00, EncounterMethod.SUPER_ROD, allVersions, whirlIslands, "1F"));
        newEncounters.add(new Encounter(seadra, 40, 40, allTimes,
                3.00, EncounterMethod.SUPER_ROD, allVersions, whirlIslands, "1F"));


        newEncounters.add(new Encounter(krabby, 23, 25, allTimes,
                50.00, EncounterMethod.WALKING, allVersions, whirlIslands, "B1F"));
        newEncounters.add(new Encounter(zubat, 24, 24, allTimes,
                30.00, EncounterMethod.WALKING, allVersions, whirlIslands, "B1F"));
        newEncounters.add(new Encounter(seel, 23, 25, allTimes,
                15.00, EncounterMethod.WALKING, allVersions, whirlIslands, "B1F"));
        newEncounters.add(new Encounter(golbat, 24, 24, allTimes,
                5.00, EncounterMethod.WALKING, allVersions, whirlIslands, "B1F"));

        newEncounters.add(new Encounter(krabby, 23, 25, allTimes,
                50.00, EncounterMethod.WALKING, allVersions, whirlIslands, "B2F"));
        newEncounters.add(new Encounter(zubat, 24, 24, allTimes,
                30.00, EncounterMethod.WALKING, allVersions, whirlIslands, "B2F"));
        newEncounters.add(new Encounter(seel, 23, 25, allTimes,
                15.00, EncounterMethod.WALKING, allVersions, whirlIslands, "B2F"));
        newEncounters.add(new Encounter(golbat, 24, 24, allTimes,
                5.00, EncounterMethod.WALKING, allVersions, whirlIslands, "B2F"));




        newEncounters.add(new Encounter(horsea, 15, 25, allTimes,
                60.00, EncounterMethod.SURFING, allVersions, whirlIslands, "B2F"));
        newEncounters.add(new Encounter(tentacruel, 15, 25, allTimes,
                30.00, EncounterMethod.SURFING, allVersions, whirlIslands, "B2F"));
        newEncounters.add(new Encounter(seadra, 15, 30, allTimes,
                10.00, EncounterMethod.SURFING, allVersions, whirlIslands, "B2F"));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, whirlIslands, "B2F"));
        newEncounters.add(new Encounter(krabby, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, whirlIslands, "B2F"));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, whirlIslands, "B2F"));
        newEncounters.add(new Encounter(krabby, 20, 20, allTimes,
                37.00, EncounterMethod.GOOD_ROD, allVersions, whirlIslands, "B2F"));
        newEncounters.add(new Encounter(horsea, 20, 20, allTimes,
                3.00, EncounterMethod.GOOD_ROD, allVersions, whirlIslands, "B2F"));

        newEncounters.add(new Encounter(krabby, 40, 40, allTimes,
                60.00, EncounterMethod.SUPER_ROD, allVersions, whirlIslands, "B2F"));
        newEncounters.add(new Encounter(horsea, 40, 40, allTimes,
                30.00, EncounterMethod.SUPER_ROD, allVersions, whirlIslands, "B2F"));
        newEncounters.add(new Encounter(kingler, 40, 40, allTimes,
                7.00, EncounterMethod.SUPER_ROD, allVersions, whirlIslands, "B2F"));
        newEncounters.add(new Encounter(seadra, 40, 40, allTimes,
                3.00, EncounterMethod.SUPER_ROD, allVersions, whirlIslands, "B2F"));




        newEncounters.add(new Encounter(krabby, 23, 25, allTimes,
                50.00, EncounterMethod.WALKING, allVersions, whirlIslands, "B3F"));
        newEncounters.add(new Encounter(zubat, 24, 24, allTimes,
                30.00, EncounterMethod.WALKING, allVersions, whirlIslands, "B3F"));
        newEncounters.add(new Encounter(seel, 23, 25, allTimes,
                15.00, EncounterMethod.WALKING, allVersions, whirlIslands, "B3F"));
        newEncounters.add(new Encounter(golbat, 24, 24, allTimes,
                5.00, EncounterMethod.WALKING, allVersions, whirlIslands, "B3F"));

        newEncounters.add(new Encounter(lugia, 70, 70, allTimes,
                100.00, EncounterMethod.ENCOUNTER, heartGold, whirlIslands, "B3F"));
        newEncounters.add(new Encounter(lugia, 45, 45, allTimes,
                100.00, EncounterMethod.ENCOUNTER, soulSilver, whirlIslands, "B3F"));


        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                whirlIslands.addEncounter(encounter);

        locationService.saveLocation(whirlIslands);
    }

    @Transactional
    protected void initializeUnionCave() {
        newEncounters = new ArrayList<>();
        Location unionCave = locationService.getLocationByName("Union Cave");


        Pokemon geodude = pokemonService.getByName("geodude");
        Pokemon sandshrew = pokemonService.getByName("sandshrew");
        Pokemon zubat = pokemonService.getByName("zubat");
        Pokemon rattata = pokemonService.getByName("rattata");
        Pokemon onix = pokemonService.getByName("onix");
        Pokemon wooper = pokemonService.getByName("wooper");
        Pokemon quagsire = pokemonService.getByName("quagsire");
        Pokemon magikarp = pokemonService.getByName("magikarp");
        Pokemon goldeen = pokemonService.getByName("goldeen");
        Pokemon seaking = pokemonService.getByName("seaking");
        Pokemon raticate = pokemonService.getByName("raticate");
        Pokemon golbat = pokemonService.getByName("golbat");
        Pokemon tentacruel = pokemonService.getByName("tentacruel");
        Pokemon krabby = pokemonService.getByName("krabby");
        Pokemon corsola = pokemonService.getByName("corsola");
        Pokemon staryu = pokemonService.getByName("staryu");
        Pokemon lapras = pokemonService.getByName("lapras");
        Pokemon tentacool = pokemonService.getByName("tentacool");
        Pokemon kingler = pokemonService.getByName("kingler");

        newEncounters.add(new Encounter(geodude, 6, 6, allTimes,
                30.00, EncounterMethod.WALKING, heartGold, unionCave, "1F"));
        newEncounters.add(new Encounter(sandshrew, 6, 6, allTimes,
                30.00, EncounterMethod.WALKING, heartGold, unionCave, "1F"));
        newEncounters.add(new Encounter(zubat, 5, 7, allTimes,
                25.00, EncounterMethod.WALKING, heartGold, unionCave, "1F"));
        newEncounters.add(new Encounter(rattata, 4, 4, allTimes,
                10.00, EncounterMethod.WALKING, heartGold, unionCave, "1F"));
        newEncounters.add(new Encounter(onix, 6, 6, allTimes,
                5.00, EncounterMethod.WALKING, heartGold, unionCave, "1F"));

        newEncounters.add(new Encounter(geodude, 6, 6, allTimes,
                30.00, EncounterMethod.WALKING, soulSilver, unionCave, "1F"));
        newEncounters.add(new Encounter(zubat, 5, 7, allTimes,
                25.00, EncounterMethod.WALKING, soulSilver, unionCave, "1F"));
        newEncounters.add(new Encounter(rattata, 4, 4, allTimes,
                40.00, EncounterMethod.WALKING, soulSilver, unionCave, "1F"));
        newEncounters.add(new Encounter(onix, 6, 6, allTimes,
                5.00, EncounterMethod.WALKING, soulSilver, unionCave, "1F"));

        newEncounters.add(new Encounter(wooper, 10, 20, allTimes,
                60.00, EncounterMethod.SURFING, allVersions, unionCave, "1F"));
        newEncounters.add(new Encounter(quagsire, 10, 25, allTimes,
                40.00, EncounterMethod.SURFING, allVersions, unionCave, "1F"));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, unionCave, "1F"));
        newEncounters.add(new Encounter(goldeen, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, unionCave, "1F"));


        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, unionCave, "1F"));
        newEncounters.add(new Encounter(goldeen, 20, 20, allTimes,
                40.00, EncounterMethod.GOOD_ROD, allVersions, unionCave, "1F"));

        newEncounters.add(new Encounter(goldeen, 40, 40, allTimes,
                90.00, EncounterMethod.SUPER_ROD, allVersions, unionCave, "1F"));
        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes,
                7.00, EncounterMethod.SUPER_ROD, allVersions, unionCave, "1F"));
        newEncounters.add(new Encounter(seaking, 40, 40, allTimes,
                3.00, EncounterMethod.SUPER_ROD, allVersions, unionCave, "1F"));


        newEncounters.add(new Encounter(geodude, 8, 8, allTimes,
                30.00, EncounterMethod.WALKING, heartGold, unionCave, "B1F"));
        newEncounters.add(new Encounter(sandshrew, 8, 8, allTimes,
                30.00, EncounterMethod.WALKING, heartGold, unionCave, "B1F"));
        newEncounters.add(new Encounter(zubat, 7, 9, allTimes,
                25.00, EncounterMethod.WALKING, heartGold, unionCave, "B1F"));
        newEncounters.add(new Encounter(rattata, 6, 6, allTimes,
                5.00, EncounterMethod.WALKING, heartGold, unionCave, "B1F"));
        newEncounters.add(new Encounter(onix, 8, 8, allTimes,
                10.00, EncounterMethod.WALKING, heartGold, unionCave, "B1F"));

        newEncounters.add(new Encounter(geodude, 8, 8, allTimes,
                30.00, EncounterMethod.WALKING, soulSilver, unionCave, "B1F"));
        newEncounters.add(new Encounter(zubat, 7, 9, allTimes,
                25.00, EncounterMethod.WALKING, soulSilver, unionCave, "B1F"));
        newEncounters.add(new Encounter(rattata, 6, 8, allTimes,
                35.00, EncounterMethod.WALKING, soulSilver, unionCave, "B1F"));
        newEncounters.add(new Encounter(onix, 8, 8, allTimes,
                10.00, EncounterMethod.WALKING, soulSilver, unionCave, "B1F"));

        newEncounters.add(new Encounter(wooper, 10, 20, allTimes,
                60.00, EncounterMethod.SURFING, allVersions, unionCave, "B1F"));
        newEncounters.add(new Encounter(quagsire, 10, 25, allTimes,
                40.00, EncounterMethod.SURFING, allVersions, unionCave, "B1F"));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, unionCave, "B1F"));
        newEncounters.add(new Encounter(goldeen, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, unionCave, "B1F"));


        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, unionCave, "B1F"));
        newEncounters.add(new Encounter(goldeen, 20, 20, allTimes,
                40.00, EncounterMethod.GOOD_ROD, allVersions, unionCave, "B1F"));

        newEncounters.add(new Encounter(goldeen, 40, 40, allTimes,
                90.00, EncounterMethod.SUPER_ROD, allVersions, unionCave, "B1F"));
        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes,
                7.00, EncounterMethod.SUPER_ROD, allVersions, unionCave, "B1F"));
        newEncounters.add(new Encounter(seaking, 40, 40, allTimes,
                3.00, EncounterMethod.SUPER_ROD, allVersions, unionCave, "B1F"));


        newEncounters.add(new Encounter(zubat, 22, 22, allTimes,
                30.00, EncounterMethod.WALKING, allVersions, unionCave, "B2F"));
        newEncounters.add(new Encounter(raticate, 22, 22, allTimes,
                30.00, EncounterMethod.WALKING, allVersions, unionCave, "B2F"));
        newEncounters.add(new Encounter(golbat, 22, 22, allTimes,
                20.00, EncounterMethod.WALKING, allVersions, unionCave, "B2F"));
        newEncounters.add(new Encounter(geodude, 21, 21, allTimes,
                10.00, EncounterMethod.WALKING, allVersions, unionCave, "B2F"));
        newEncounters.add(new Encounter(rattata, 20, 20, allTimes,
                5.00, EncounterMethod.WALKING, allVersions, unionCave, "B2F"));
        newEncounters.add(new Encounter(onix, 23, 23, allTimes,
                5.00, EncounterMethod.WALKING, allVersions, unionCave, "B2F"));


        newEncounters.add(new Encounter(tentacool, 10, 20, allTimes,
                60.00, EncounterMethod.SURFING, allVersions, unionCave, "B2F"));
        newEncounters.add(new Encounter(quagsire, 15, 25, allTimes,
                30.00, EncounterMethod.SURFING, allVersions, unionCave, "B2F"));
        newEncounters.add(new Encounter(tentacruel, 15, 25, allTimes,
                10.00, EncounterMethod.SURFING, allVersions, unionCave, "B2F"));


        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, unionCave, "B2F"));
        newEncounters.add(new Encounter(krabby, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, unionCave, "B2F"));


        newEncounters.add(new Encounter(magikarp, 25, 25, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, unionCave, "B2F"));
        newEncounters.add(new Encounter(krabby, 25, 25, allTimes,
                37.00, EncounterMethod.GOOD_ROD, allVersions, unionCave, "B2F"));
        newEncounters.add(new Encounter(corsola, 25, 25, morningDay,
                3.00, EncounterMethod.GOOD_ROD, allVersions, unionCave, "B2F"));
        newEncounters.add(new Encounter(staryu, 25, 25, night,
                3.00, EncounterMethod.GOOD_ROD, allVersions, unionCave, "B2F"));


        newEncounters.add(new Encounter(krabby, 40, 40, allTimes,
                67.00, EncounterMethod.SUPER_ROD, allVersions, unionCave, "B2F"));
        newEncounters.add(new Encounter(corsola, 40, 40, morningDay,
                30.00, EncounterMethod.SUPER_ROD, allVersions, unionCave, "B2F"));
        newEncounters.add(new Encounter(kingler, 40, 40, allTimes,
                3.00, EncounterMethod.SUPER_ROD, allVersions, unionCave, "B2F"));
        newEncounters.add(new Encounter(staryu, 40, 40, night,
                30.00, EncounterMethod.SUPER_ROD, allVersions, unionCave, "B2F"));

        newEncounters.add(new Encounter(lapras, 20, 20, allTimes,
                100.00, EncounterMethod.ENCOUNTER, allVersions, unionCave, "B2F"));


        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                unionCave.addEncounter(encounter);

        locationService.saveLocation(unionCave);
    }

    @Transactional
    protected void initializeSlowpokeWell() {

        newEncounters = new ArrayList<>();
        Location slowpokeWell = locationService.getLocationByName("Slowpoke Well");

        Pokemon zubat = pokemonService.getByName("zubat");
        Pokemon slowpoke = pokemonService.getByName("slowpoke");
        Pokemon magikarp = pokemonService.getByName("magikarp");
        Pokemon goldeen = pokemonService.getByName("goldeen");
        Pokemon seaking = pokemonService.getByName("seaking");
        Pokemon golbat = pokemonService.getByName("golbat");
        Pokemon slowbro =  pokemonService.getByName("slowbro");

        newEncounters.add(new Encounter(zubat, 5, 8, allTimes,
                85.00, EncounterMethod.WALKING, allVersions, slowpokeWell, "1F"));
        newEncounters.add(new Encounter(slowpoke, 6, 8, allTimes,
                15.00, EncounterMethod.WALKING, allVersions, slowpokeWell, "1F"));

        newEncounters.add(new Encounter(slowpoke, 5, 25, allTimes,
                100.00, EncounterMethod.SURFING, allVersions, slowpokeWell, "1F"));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, slowpokeWell, "1F"));
        newEncounters.add(new Encounter(goldeen, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, slowpokeWell, "1F"));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, slowpokeWell, "1F"));
        newEncounters.add(new Encounter(goldeen, 20, 20, allTimes,
                40.00, EncounterMethod.GOOD_ROD, allVersions, slowpokeWell, "1F"));

        newEncounters.add(new Encounter(goldeen, 40, 40, allTimes,
                90.00, EncounterMethod.SUPER_ROD, allVersions, slowpokeWell, "1F"));
        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes,
                7.00, EncounterMethod.SUPER_ROD, allVersions, slowpokeWell, "1F"));
        newEncounters.add(new Encounter(seaking, 40, 40, allTimes,
                3.00, EncounterMethod.SUPER_ROD, allVersions, slowpokeWell, "1F"));

        newEncounters.add(new Encounter(zubat, 19, 23, allTimes,
                80.00, EncounterMethod.WALKING, allVersions, slowpokeWell, "B1F"));
        newEncounters.add(new Encounter(slowpoke, 21, 23, allTimes,
                15.00, EncounterMethod.WALKING, allVersions, slowpokeWell, "B1F"));
        newEncounters.add(new Encounter(golbat, 23, 23, allTimes,
                5.00, EncounterMethod.WALKING, allVersions, slowpokeWell, "B1F"));

        newEncounters.add(new Encounter(slowpoke, 10, 25, allTimes,
                90.00, EncounterMethod.SURFING, allVersions, slowpokeWell, "B1F"));
        newEncounters.add(new Encounter(slowbro, 15, 30, allTimes,
                10.00, EncounterMethod.SURFING, allVersions, slowpokeWell, "B1F"));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, slowpokeWell, "B1F"));
        newEncounters.add(new Encounter(goldeen, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, slowpokeWell, "B1F"));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, slowpokeWell, "B1F"));
        newEncounters.add(new Encounter(goldeen, 20, 20, allTimes,
                40.00, EncounterMethod.GOOD_ROD, allVersions, slowpokeWell, "B1F"));

        newEncounters.add(new Encounter(goldeen, 40, 40, allTimes,
                90.00, EncounterMethod.SUPER_ROD, allVersions, slowpokeWell, "B1F"));
        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes,
                7.00, EncounterMethod.SUPER_ROD, allVersions, slowpokeWell, "B1F"));
        newEncounters.add(new Encounter(seaking, 40, 40, allTimes,
                3.00, EncounterMethod.SUPER_ROD, allVersions, slowpokeWell, "B1F"));



        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                slowpokeWell.addEncounter(encounter);

        locationService.saveLocation(slowpokeWell);
    }

    @Transactional
    protected void initializeMtMortar() {newEncounters = new ArrayList<>();
        Location mtMortar = locationService.getLocationByName("Mt. Mortar");

        Pokemon zubat = pokemonService.getByName("zubat");
        Pokemon machop = pokemonService.getByName("machop");
        Pokemon rattata = pokemonService.getByName("rattata");
        Pokemon geodude = pokemonService.getByName("geodude");
        Pokemon marill = pokemonService.getByName("marill");
        Pokemon goldeen = pokemonService.getByName("goldeen");
        Pokemon seaking = pokemonService.getByName("seaking");
        Pokemon magikarp = pokemonService.getByName("magikarp");
        Pokemon graveler = pokemonService.getByName("graveler");
        Pokemon raticate = pokemonService.getByName("raticate");
        Pokemon golbat = pokemonService.getByName("golbat");
        Pokemon tyrogue = pokemonService.getByName("tyrogue");
        Pokemon machoke = pokemonService.getByName("machoke");

        newEncounters.add(new Encounter(zubat, 13, 15, allTimes,
                60.00, EncounterMethod.WALKING, allVersions, mtMortar, "1F"));
        newEncounters.add(new Encounter(machop, 14, 14, allTimes,
                20.00, EncounterMethod.WALKING, allVersions, mtMortar, "1F"));
        newEncounters.add(new Encounter(rattata, 14, 16, allTimes,
                19.00, EncounterMethod.WALKING, allVersions, mtMortar, "1F"));
        newEncounters.add(new Encounter(geodude, 14, 14, allTimes,
                5.00, EncounterMethod.WALKING, allVersions, mtMortar, "1F"));
        newEncounters.add(new Encounter(marill, 15, 15, allTimes,
                1.00, EncounterMethod.WALKING, allVersions, mtMortar, "1F"));

        newEncounters.add(new Encounter(magikarp, 10, 25, allTimes,
                90.00, EncounterMethod.SURFING, allVersions, mtMortar, "1F"));
        newEncounters.add(new Encounter(goldeen, 15, 25, allTimes,
                10.00, EncounterMethod.SURFING, allVersions, mtMortar, "1F"));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, mtMortar, "1F"));
        newEncounters.add(new Encounter(goldeen, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, mtMortar, "1F"));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, mtMortar, "1F"));
        newEncounters.add(new Encounter(goldeen, 20, 20, allTimes,
                40.00, EncounterMethod.GOOD_ROD, allVersions, mtMortar, "1F"));

        newEncounters.add(new Encounter(goldeen, 40, 40, allTimes,
                90.00, EncounterMethod.SUPER_ROD, allVersions, mtMortar, "1F"));
        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes,
                7.00, EncounterMethod.SUPER_ROD, allVersions, mtMortar, "1F"));
        newEncounters.add(new Encounter(seaking, 40, 40, allTimes,
                3.00, EncounterMethod.SUPER_ROD, allVersions, mtMortar, "1F"));

        newEncounters.add(new Encounter(geodude, 13, 15, allTimes,
                50.00, EncounterMethod.WALKING, allVersions, mtMortar, "1F-2"));
        newEncounters.add(new Encounter(machop, 13, 15, allTimes,
                35.00, EncounterMethod.WALKING, allVersions, mtMortar, "1F-2"));
        newEncounters.add(new Encounter(rattata, 14, 15, allTimes,
                10.00, EncounterMethod.WALKING, allVersions, mtMortar, "1F-2"));
        newEncounters.add(new Encounter(zubat, 14, 14, allTimes,
                5.00, EncounterMethod.WALKING, allVersions, mtMortar, "1F-2"));



        newEncounters.add(new Encounter(graveler, 31, 31, allTimes,
                30.00, EncounterMethod.WALKING, allVersions, mtMortar, "1F-3"));
        newEncounters.add(new Encounter(machoke, 32, 32, allTimes,
                30.00, EncounterMethod.WALKING, allVersions, mtMortar, "1F-3"));
        newEncounters.add(new Encounter(geodude, 31, 32, allTimes,
                20.00, EncounterMethod.WALKING, allVersions, mtMortar, "1F-3"));
        newEncounters.add(new Encounter(raticate, 30, 30, allTimes,
                10.00, EncounterMethod.WALKING, allVersions, mtMortar, "1F-3"));
        newEncounters.add(new Encounter(machop, 28, 30, allTimes,
                5.00, EncounterMethod.WALKING, allVersions, mtMortar, "1F-3"));
        newEncounters.add(new Encounter(golbat, 30, 30, allTimes,
                5.00, EncounterMethod.WALKING, allVersions, mtMortar, "1F-3"));

        newEncounters.add(new Encounter(goldeen, 15, 30, allTimes,
                90.00, EncounterMethod.SURFING, allVersions, mtMortar, "1F-3"));
        newEncounters.add(new Encounter(seaking, 20, 30, allTimes,
                10.00, EncounterMethod.SURFING, allVersions, mtMortar, "1F-3"));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, mtMortar, "1F-3"));
        newEncounters.add(new Encounter(goldeen, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, mtMortar, "1F-3"));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, mtMortar, "1F-3"));
        newEncounters.add(new Encounter(goldeen, 20, 20, allTimes,
                40.00, EncounterMethod.GOOD_ROD, allVersions, mtMortar, "1F-3"));

        newEncounters.add(new Encounter(goldeen, 40, 40, allTimes,
                90.00, EncounterMethod.SUPER_ROD, allVersions, mtMortar, "1F-3"));
        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes,
                7.00, EncounterMethod.SUPER_ROD, allVersions, mtMortar, "1F-3"));
        newEncounters.add(new Encounter(seaking, 40, 40, allTimes,
                3.00, EncounterMethod.SUPER_ROD, allVersions, mtMortar, "1F-3"));


        newEncounters.add(new Encounter(zubat, 15, 17, allTimes,
                60.00, EncounterMethod.WALKING, allVersions, mtMortar, "B1F"));
        newEncounters.add(new Encounter(rattata, 16, 16, allTimes,
                20.00, EncounterMethod.WALKING, allVersions, mtMortar, "B1F"));
        newEncounters.add(new Encounter(machop, 16, 16, allTimes,
                10.00, EncounterMethod.WALKING, allVersions, mtMortar, "B1F"));
        newEncounters.add(new Encounter(raticate, 16, 16, allTimes,
                5.00, EncounterMethod.WALKING, allVersions, mtMortar, "B1F"));
        newEncounters.add(new Encounter(geodude, 16, 16, allTimes,
                5.00, EncounterMethod.WALKING, allVersions, mtMortar, "B1F"));

        newEncounters.add(new Encounter(magikarp, 10, 25, allTimes,
                90.00, EncounterMethod.SURFING, allVersions, mtMortar, "B1F"));
        newEncounters.add(new Encounter(goldeen, 15, 25, allTimes,
                10.00, EncounterMethod.SURFING, allVersions, mtMortar, "B1F"));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, mtMortar, "B1F"));
        newEncounters.add(new Encounter(goldeen, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, mtMortar, "B1F"));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, mtMortar, "B1F"));
        newEncounters.add(new Encounter(goldeen, 20, 20, allTimes,
                40.00, EncounterMethod.GOOD_ROD, allVersions, mtMortar, "B1F"));

        newEncounters.add(new Encounter(goldeen, 40, 40, allTimes,
                90.00, EncounterMethod.SUPER_ROD, allVersions, mtMortar, "B1F"));
        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes,
                7.00, EncounterMethod.SUPER_ROD, allVersions, mtMortar, "B1F"));
        newEncounters.add(new Encounter(seaking, 40, 40, allTimes,
                3.00, EncounterMethod.SUPER_ROD, allVersions, mtMortar, "B1F"));

        newEncounters.add(new Encounter(tyrogue, 10, 10, allTimes,
                100.00, EncounterMethod.GIFT, allVersions, mtMortar, "B1F"));


        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                mtMortar.addEncounter(encounter);

        locationService.saveLocation(mtMortar);
    }

    @Transactional
    protected void initializeRuinsOfAlph() {

        newEncounters = new ArrayList<>();
        Location ruinsOfAlph = locationService.getLocationByName("Ruins of Alph");

        Pokemon natu = pokemonService.getByName("natu");
        Pokemon smeargle = pokemonService.getByName("smeargle");
        Pokemon geodude = pokemonService.getByName("geodude");
        Pokemon wooper = pokemonService.getByName("wooper");
        Pokemon quagsire = pokemonService.getByName("quagsire");
        Pokemon magikarp = pokemonService.getByName("magikarp");
        Pokemon poliwag = pokemonService.getByName("poliwag");
        Pokemon unown = pokemonService.getByName("unown");


        newEncounters.add(new Encounter(natu, 18, 24, allTimes,
                90.00, EncounterMethod.WALKING, allVersions, ruinsOfAlph, "Outside"));
        newEncounters.add(new Encounter(smeargle, 20, 22, allTimes,
                10.00, EncounterMethod.WALKING, allVersions, ruinsOfAlph, "Outside"));
        newEncounters.add(new Encounter(smeargle, 3, 14, allTimes,
                100.00, EncounterMethod.ROCK_SMASH, allVersions, ruinsOfAlph, "Outside"));

        newEncounters.add(new Encounter(wooper, 10, 20, allTimes,
                60.00, EncounterMethod.SURFING, allVersions, ruinsOfAlph, "Outside"));
        newEncounters.add(new Encounter(quagsire, 10, 25, allTimes,
                40.00, EncounterMethod.SURFING, allVersions, ruinsOfAlph, "Outside"));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, ruinsOfAlph, "Outside"));
        newEncounters.add(new Encounter(poliwag, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, ruinsOfAlph, "Outside"));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, ruinsOfAlph, "Outside"));
        newEncounters.add(new Encounter(poliwag, 20, 20, allTimes,
                40.00, EncounterMethod.GOOD_ROD, allVersions, ruinsOfAlph, "Outside"));

        newEncounters.add(new Encounter(poliwag, 40, 40, allTimes,
                93.00, EncounterMethod.SUPER_ROD, allVersions, ruinsOfAlph, "Outside"));
        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes,
                7.00, EncounterMethod.SUPER_ROD, allVersions, ruinsOfAlph, "Outside"));

        newEncounters.add(new Encounter(geodude, 3, 14, allTimes,
                100.00, EncounterMethod.ROCK_SMASH, allVersions, ruinsOfAlph, "Outside"));

        newEncounters.add(new Encounter(unown, 5, 5, allTimes,
                100.00, EncounterMethod.WALKING, allVersions, ruinsOfAlph, "Inside"));

        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                ruinsOfAlph.addEncounter(encounter);

        locationService.saveLocation(ruinsOfAlph);

    }

    @Transactional
    protected void initializeLakeOfRage() {
        newEncounters = new ArrayList<>();
        Location lakeOfRage = locationService.getLocationByName("Lake of Rage");

        Pokemon magikarp = pokemonService.getByName("magikarp");
        Pokemon gyarados = pokemonService.getByName("gyarados");

        newEncounters.add(new Encounter(magikarp, 5, 20, allTimes,
                90.00, EncounterMethod.SURFING, allVersions, lakeOfRage));
        newEncounters.add(new Encounter(magikarp, 10, 20, allTimes,
                10.00, EncounterMethod.SURFING, allVersions, lakeOfRage));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                100.00, EncounterMethod.OLD_ROD, allVersions, lakeOfRage));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                97.00, EncounterMethod.GOOD_ROD, allVersions, lakeOfRage));
        newEncounters.add(new Encounter(gyarados, 20, 20, allTimes,
                3.00, EncounterMethod.GOOD_ROD, allVersions, lakeOfRage));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                90.00, EncounterMethod.SUPER_ROD, allVersions, lakeOfRage));
        newEncounters.add(new Encounter(gyarados, 20, 20, allTimes,
                10.00, EncounterMethod.SUPER_ROD, allVersions, lakeOfRage));

        newEncounters.add(new Encounter(gyarados, 30, 30, allTimes,
                100.00, EncounterMethod.ENCOUNTER, allVersions, lakeOfRage));

        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                lakeOfRage.addEncounter(encounter);

        locationService.saveLocation(lakeOfRage);
    }

    @Transactional
    protected void initializeIlexForest() {

        newEncounters = new ArrayList<>();
        Location ilexForest = locationService.getLocationByName("Ilex Forest");

        Pokemon caterpie = pokemonService.getByName("caterpie");
        Pokemon kakuna = pokemonService.getByName("kakuna");
        Pokemon weedle = pokemonService.getByName("weedle");
        Pokemon metapod = pokemonService.getByName("metapod");
        Pokemon paras = pokemonService.getByName("paras");
        Pokemon zubat = pokemonService.getByName("zubat");
        Pokemon psyduck = pokemonService.getByName("psyduck");
        Pokemon golduck = pokemonService.getByName("golduck");
        Pokemon magikarp = pokemonService.getByName("magikarp");
        Pokemon poliwag = pokemonService.getByName("poliwag");
        Pokemon pichu = pokemonService.getByName("pichu");
        Pokemon oddish = pokemonService.getByName("oddish");

        newEncounters.add(new Encounter(caterpie, 5, 6, morning,
                50.00, EncounterMethod.WALKING, heartGold, ilexForest));
        newEncounters.add(new Encounter(metapod, 6, 6, morning,
                30.00, EncounterMethod.WALKING, heartGold, ilexForest));
        newEncounters.add(new Encounter(paras, 5, 6, morning,
                15.00, EncounterMethod.WALKING, heartGold, ilexForest));
        newEncounters.add(new Encounter(zubat, 5, 5, morning,
                5.00, EncounterMethod.WALKING, heartGold, ilexForest));
        newEncounters.add(new Encounter(weedle, 5, 6, morning,
                50.00, EncounterMethod.WALKING, soulSilver, ilexForest));
        newEncounters.add(new Encounter(kakuna, 6, 6, morning,
                30.00, EncounterMethod.WALKING, soulSilver, ilexForest));
        newEncounters.add(new Encounter(paras, 5, 6, morning,
                15.00, EncounterMethod.WALKING, soulSilver, ilexForest));
        newEncounters.add(new Encounter(zubat, 5, 5, morning,
                5.00, EncounterMethod.WALKING, soulSilver, ilexForest));


        newEncounters.add(new Encounter(caterpie, 5, 6, day,
                60.00, EncounterMethod.WALKING, heartGold, ilexForest));
        newEncounters.add(new Encounter(metapod, 5, 6, day,
                30.00, EncounterMethod.WALKING, heartGold, ilexForest));
        newEncounters.add(new Encounter(paras, 5, 5, day,
                5.00, EncounterMethod.WALKING, heartGold, ilexForest));
        newEncounters.add(new Encounter(zubat, 6, 6, day,
                5.00, EncounterMethod.WALKING, heartGold, ilexForest));
        newEncounters.add(new Encounter(weedle, 5, 6, day,
                50.00, EncounterMethod.WALKING, soulSilver, ilexForest));
        newEncounters.add(new Encounter(kakuna, 5, 6, day,
                30.00, EncounterMethod.WALKING, soulSilver, ilexForest));
        newEncounters.add(new Encounter(zubat, 5, 5, day,
                15.00, EncounterMethod.WALKING, soulSilver, ilexForest));
        newEncounters.add(new Encounter(paras, 6, 6, day,
                5.00, EncounterMethod.WALKING, soulSilver, ilexForest));


        newEncounters.add(new Encounter(oddish, 5, 6, night,
                60.00, EncounterMethod.WALKING, allVersions, ilexForest));
        newEncounters.add(new Encounter(zubat, 5, 6, night,
                25.00, EncounterMethod.WALKING, allVersions, ilexForest));
        newEncounters.add(new Encounter(paras, 5, 5, night,
                15.00, EncounterMethod.WALKING, allVersions, ilexForest));


        newEncounters.add(new Encounter(psyduck, 5, 20, allTimes,
                90.00, EncounterMethod.SURFING, allVersions, ilexForest));
        newEncounters.add(new Encounter(golduck, 10, 20, allTimes,
                10.00, EncounterMethod.SURFING, allVersions, ilexForest));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, ilexForest));
        newEncounters.add(new Encounter(poliwag, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, ilexForest));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, ilexForest));
        newEncounters.add(new Encounter(poliwag, 20, 20, allTimes,
                40.00, EncounterMethod.GOOD_ROD, allVersions, ilexForest));

        newEncounters.add(new Encounter(poliwag, 40, 40, allTimes,
                93.00, EncounterMethod.SUPER_ROD, allVersions, ilexForest));
        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes,
                7.00, EncounterMethod.SUPER_ROD, allVersions, ilexForest));

        newEncounters.add(new Encounter(pichu, 30, 30, allTimes,
                100.00, EncounterMethod.GIFT, allVersions, ilexForest));

        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                ilexForest.addEncounter(encounter);

        locationService.saveLocation(ilexForest);

    }

    @Transactional
    protected void initializeDragonsDen() {
        newEncounters = new ArrayList<>();
        Location dragonsDen = locationService.getLocationByName("Dragon's Den");

        Pokemon magikarp = pokemonService.getByName("magikarp");
        Pokemon dratini = pokemonService.getByName("dratini");
        Pokemon dragonair = pokemonService.getByName("dragonair");

        newEncounters.add(new Encounter(magikarp, 5, 20, allTimes,
                90.00, EncounterMethod.SURFING, allVersions, dragonsDen));
        newEncounters.add(new Encounter(dratini, 5, 15, allTimes,
                10.00, EncounterMethod.SURFING, allVersions, dragonsDen));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                100.00, EncounterMethod.OLD_ROD, allVersions, dragonsDen));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                97.00, EncounterMethod.GOOD_ROD, allVersions, dragonsDen));
        newEncounters.add(new Encounter(dratini, 20, 20, allTimes,
                3.00, EncounterMethod.GOOD_ROD, allVersions, dragonsDen));

        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes,
                65.00, EncounterMethod.SUPER_ROD, allVersions, dragonsDen));
        newEncounters.add(new Encounter(dratini, 40, 40, allTimes,
                32.00, EncounterMethod.SUPER_ROD, allVersions, dragonsDen));
        newEncounters.add(new Encounter(dragonair, 40, 40, allTimes,
                3.00, EncounterMethod.SUPER_ROD, allVersions, dragonsDen));

        newEncounters.add(new Encounter(dratini, 15, 15, allTimes,
                100.00, EncounterMethod.GIFT, allVersions, dragonsDen));


        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                dragonsDen.addEncounter(encounter);

        locationService.saveLocation(dragonsDen);
    }

    @Transactional
    protected void initializeDarkCaveRoute31() {
        newEncounters = new ArrayList<>();
        Location darkCave = locationService.getLocationByName("Dark cave Route 31");

        Pokemon geodude = pokemonService.getByName("geodude");
        Pokemon zubat = pokemonService.getByName("zubat");
        Pokemon dunsparce = pokemonService.getByName("dunsparce");
        Pokemon magikarp = pokemonService.getByName("magikarp");
        Pokemon goldeen = pokemonService.getByName("goldeen");
        Pokemon seaking = pokemonService.getByName("seaking");
        Pokemon graveler = pokemonService.getByName("graveler");
        Pokemon wobbuffet = pokemonService.getByName("wobbuffet");
        Pokemon golbat = pokemonService.getByName("golbat");


        newEncounters.add(new Encounter(geodude, 2, 4, allTimes,
                60.00, EncounterMethod.WALKING, allVersions, darkCave));
        newEncounters.add(new Encounter(zubat, 2, 4, allTimes,
                39.00, EncounterMethod.WALKING, allVersions, darkCave));
        newEncounters.add(new Encounter(dunsparce, 4, 4, allTimes,
                1.00, EncounterMethod.WALKING, allVersions, darkCave));

        newEncounters.add(new Encounter(geodude, 8, 14, allTimes,
                10.00, EncounterMethod.ROCK_SMASH, allVersions, darkCave));
        newEncounters.add(new Encounter(dunsparce, 4, 8, allTimes,
                90.00, EncounterMethod.ROCK_SMASH, allVersions, darkCave));

        newEncounters.add(new Encounter(magikarp, 2, 20, allTimes,
                100.00, EncounterMethod.SURFING, allVersions, darkCave));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, darkCave));
        newEncounters.add(new Encounter(goldeen, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, darkCave));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, darkCave));
        newEncounters.add(new Encounter(goldeen, 20, 20, allTimes,
                40.00, EncounterMethod.GOOD_ROD, allVersions, darkCave));

        newEncounters.add(new Encounter(goldeen, 40, 40, allTimes,
                90.00, EncounterMethod.SUPER_ROD, allVersions, darkCave));
        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes,
                7.00, EncounterMethod.SUPER_ROD, allVersions, darkCave));
        newEncounters.add(new Encounter(seaking, 40, 40, allTimes,
                3.00, EncounterMethod.SUPER_ROD, allVersions, darkCave));


        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                darkCave.addEncounter(encounter);

        locationService.saveLocation(darkCave);
    }

    @Transactional
    protected void initializeDarkCaveRoute45() {

        newEncounters = new ArrayList<>();
        Location darkCave = locationService.getLocationByName("Dark cave Route 45");


        Pokemon geodude = pokemonService.getByName("geodude");
        Pokemon zubat = pokemonService.getByName("zubat");
        Pokemon graveler = pokemonService.getByName("graveler");
        Pokemon wobbuffet = pokemonService.getByName("wobbuffet");
        Pokemon golbat = pokemonService.getByName("golbat");
        Pokemon magikarp = pokemonService.getByName("magikarp");
        Pokemon goldeen = pokemonService.getByName("goldeen");
        Pokemon seaking = pokemonService.getByName("seaking");

        newEncounters.add(new Encounter(geodude, 23, 23, allTimes,
                30.00, EncounterMethod.WALKING, allVersions, darkCave));
        newEncounters.add(new Encounter(zubat, 23, 23, allTimes,
                30.00, EncounterMethod.WALKING, allVersions, darkCave));
        newEncounters.add(new Encounter(graveler, 25, 25, allTimes,
                20.00, EncounterMethod.WALKING, allVersions, darkCave));
        newEncounters.add(new Encounter(wobbuffet, 20, 25, allTimes,
                14.00, EncounterMethod.WALKING, allVersions, darkCave));
        newEncounters.add(new Encounter(golbat, 23, 23, allTimes,
                5.00, EncounterMethod.WALKING, allVersions, darkCave));


        newEncounters.add(new Encounter(magikarp, 2, 20, allTimes,
                100.00, EncounterMethod.SURFING, allVersions, darkCave));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, darkCave));
        newEncounters.add(new Encounter(goldeen, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, darkCave));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, darkCave));
        newEncounters.add(new Encounter(goldeen, 20, 20, allTimes,
                40.00, EncounterMethod.GOOD_ROD, allVersions, darkCave));

        newEncounters.add(new Encounter(goldeen, 40, 40, allTimes,
                90.00, EncounterMethod.SUPER_ROD, allVersions, darkCave));
        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes,
                7.00, EncounterMethod.SUPER_ROD, allVersions, darkCave));
        newEncounters.add(new Encounter(seaking, 40, 40, allTimes,
                3.00, EncounterMethod.SUPER_ROD, allVersions, darkCave));

        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                darkCave.addEncounter(encounter);

        locationService.saveLocation(darkCave);
    }

    @Transactional
    protected void initializeBurnedTower() {

        newEncounters = new ArrayList<>();
        Location burnedTower = locationService.getLocationByName("Burned Tower");

        Pokemon rattata = pokemonService.getByName("rattata");
        Pokemon koffing = pokemonService.getByName("koffing");
        Pokemon zubat = pokemonService.getByName("zubat");
        Pokemon raticate = pokemonService.getByName("raticate");
        Pokemon magmar = pokemonService.getByName("magmar");

        newEncounters.add(new Encounter(rattata, 13, 15, allTimes,
                50.00, EncounterMethod.WALKING, allVersions, burnedTower, "1F"));
        newEncounters.add(new Encounter(koffing, 14, 16, allTimes,
                35.00, EncounterMethod.WALKING, allVersions, burnedTower, "1F"));
        newEncounters.add(new Encounter(zubat, 14, 14, allTimes,
                10.00, EncounterMethod.WALKING, allVersions, burnedTower, "1F"));
        newEncounters.add(new Encounter(raticate, 15, 15, allTimes,
                5.00, EncounterMethod.WALKING, allVersions, burnedTower, "1F"));

        newEncounters.add(new Encounter(koffing, 14, 16, morning,
                50.00, EncounterMethod.WALKING, allVersions, burnedTower, "B1F"));
        newEncounters.add(new Encounter(rattata, 14, 16, morning,
                40.00, EncounterMethod.WALKING, allVersions, burnedTower, "B1F"));
        newEncounters.add(new Encounter(zubat, 15, 15, morning,
                5.00, EncounterMethod.WALKING, allVersions, burnedTower, "B1F"));
        newEncounters.add(new Encounter(magmar, 14, 14, morning,
                5.00, EncounterMethod.WALKING, allVersions, burnedTower, "B1F"));

        newEncounters.add(new Encounter(koffing, 14, 16, day,
                50.00, EncounterMethod.WALKING, allVersions, burnedTower, "B1F"));
        newEncounters.add(new Encounter(rattata, 14, 14, day,
                35.00, EncounterMethod.WALKING, allVersions, burnedTower, "B1F"));
        newEncounters.add(new Encounter(magmar, 16, 16, day,
                10.00, EncounterMethod.WALKING, allVersions, burnedTower, "B1F"));
        newEncounters.add(new Encounter(zubat, 15, 15, day,
                5.00, EncounterMethod.WALKING, allVersions, burnedTower, "B1F"));

        newEncounters.add(new Encounter(koffing, 14, 16, night,
                50.00, EncounterMethod.WALKING, allVersions, burnedTower, "B1F"));
        newEncounters.add(new Encounter(rattata, 14, 16, night,
                40.00, EncounterMethod.WALKING, allVersions, burnedTower, "B1F"));
        newEncounters.add(new Encounter(zubat, 15, 15, night,
                5.00, EncounterMethod.WALKING, allVersions, burnedTower, "B1F"));
        newEncounters.add(new Encounter(magmar, 14, 14, night,
                5.00, EncounterMethod.WALKING, allVersions, burnedTower, "B1F"));

        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                burnedTower.addEncounter(encounter);

        locationService.saveLocation(burnedTower);

    }

    @Transactional
    protected void initializeBellTower() {

        newEncounters = new ArrayList<>();
        Location bellTower = locationService.getLocationByName("Bell Tower");


        Pokemon rattata = pokemonService.getByName("rattata");
        Pokemon gastly = pokemonService.getByName("gastly");
        Pokemon hooh = pokemonService.getByName("ho-oh");

        newEncounters.add(new Encounter(rattata, 20, 24, morningDay,
                100.00, EncounterMethod.WALKING, allVersions, bellTower, "2F"));
        newEncounters.add(new Encounter(rattata, 20, 24, morningDay,
                100.00, EncounterMethod.WALKING, allVersions, bellTower, "3F"));
        newEncounters.add(new Encounter(rattata, 20, 24, morningDay,
                100.00, EncounterMethod.WALKING, allVersions, bellTower, "4F"));
        newEncounters.add(new Encounter(rattata, 20, 24, morningDay,
                100.00, EncounterMethod.WALKING, allVersions, bellTower, "5F"));
        newEncounters.add(new Encounter(rattata, 20, 24, morningDay,
                100.00, EncounterMethod.WALKING, allVersions, bellTower, "6F"));
        newEncounters.add(new Encounter(rattata, 20, 24, morningDay,
                100.00, EncounterMethod.WALKING, allVersions, bellTower, "7F"));
        newEncounters.add(new Encounter(rattata, 20, 24, morningDay,
                100.00, EncounterMethod.WALKING, allVersions, bellTower, "8F"));
        newEncounters.add(new Encounter(rattata, 20, 24, morningDay,
                100.00, EncounterMethod.WALKING, allVersions, bellTower, "9F"));
        newEncounters.add(new Encounter(rattata, 20, 24, morningDay,
                100.00, EncounterMethod.WALKING, allVersions, bellTower, "10F"));

        newEncounters.add(new Encounter(gastly, 20, 22, night,
                80.00, EncounterMethod.WALKING, allVersions, bellTower, "2F"));
        newEncounters.add(new Encounter(rattata, 20, 24, night,
                20.00, EncounterMethod.WALKING, allVersions, bellTower, "2F"));

        newEncounters.add(new Encounter(gastly, 20, 22, night,
                80.00, EncounterMethod.WALKING, allVersions, bellTower, "3F"));
        newEncounters.add(new Encounter(rattata, 20, 24, night,
                20.00, EncounterMethod.WALKING, allVersions, bellTower, "3F"));

        newEncounters.add(new Encounter(gastly, 20, 22, night,
                80.00, EncounterMethod.WALKING, allVersions, bellTower, "4F"));
        newEncounters.add(new Encounter(rattata, 20, 24, night,
                20.00, EncounterMethod.WALKING, allVersions, bellTower, "4F"));

        newEncounters.add(new Encounter(gastly, 20, 22, night,
                80.00, EncounterMethod.WALKING, allVersions, bellTower, "5F"));
        newEncounters.add(new Encounter(rattata, 20, 24, night,
                20.00, EncounterMethod.WALKING, allVersions, bellTower, "5F"));

        newEncounters.add(new Encounter(gastly, 20, 22, night,
                80.00, EncounterMethod.WALKING, allVersions, bellTower, "6F"));
        newEncounters.add(new Encounter(rattata, 20, 24, night,
                20.00, EncounterMethod.WALKING, allVersions, bellTower, "6F"));

        newEncounters.add(new Encounter(gastly, 20, 22, night,
                80.00, EncounterMethod.WALKING, allVersions, bellTower, "7F"));
        newEncounters.add(new Encounter(rattata, 20, 24, night,
                20.00, EncounterMethod.WALKING, allVersions, bellTower, "7F"));

        newEncounters.add(new Encounter(gastly, 20, 22, night,
                80.00, EncounterMethod.WALKING, allVersions, bellTower, "8F"));
        newEncounters.add(new Encounter(rattata, 20, 24, night,
                20.00, EncounterMethod.WALKING, allVersions, bellTower, "8F"));

        newEncounters.add(new Encounter(gastly, 20, 22, night,
                80.00, EncounterMethod.WALKING, allVersions, bellTower, "9F"));
        newEncounters.add(new Encounter(rattata, 20, 24, night,
                20.00, EncounterMethod.WALKING, allVersions, bellTower, "9F"));

        newEncounters.add(new Encounter(gastly, 20, 22, night,
                80.00, EncounterMethod.WALKING, allVersions, bellTower, "10F"));
        newEncounters.add(new Encounter(rattata, 20, 24, night,
                20.00, EncounterMethod.WALKING, allVersions, bellTower, "10F"));

        newEncounters.add(new Encounter(hooh, 45, 45, allTimes,
                100.00, EncounterMethod.ENCOUNTER, heartGold, bellTower, "Top"));
        newEncounters.add(new Encounter(hooh, 70, 70, allTimes,
                100.00, EncounterMethod.ENCOUNTER, soulSilver, bellTower, "Top"));

        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                bellTower.addEncounter(encounter);

        locationService.saveLocation(bellTower);

    }

    @Transactional
    protected void initializeVioletCity() {
        newEncounters = new ArrayList<>();
        Location violetCity = locationService.getLocationByName("Violet City");

        Pokemon poliwag = pokemonService.getByName("poliwag");
        Pokemon poliwhirl = pokemonService.getByName("poliwhirl");
        Pokemon magikarp = pokemonService.getByName("magikarp");

        Pokemon togepi = pokemonService.getByName("togepi");
        Pokemon mareep = pokemonService.getByName("mareep");
        Pokemon wooper = pokemonService.getByName("wooper");
        Pokemon slugma = pokemonService.getByName("slugma");

        newEncounters.add(new Encounter(poliwag, 10, 25, allTimes,
                90.00, EncounterMethod.SURFING, allVersions, violetCity));
        newEncounters.add(new Encounter(poliwhirl, 15, 32, allTimes,
                10.00, EncounterMethod.SURFING, allVersions, violetCity));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, violetCity));
        newEncounters.add(new Encounter(poliwag, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, violetCity));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, violetCity));
        newEncounters.add(new Encounter(poliwag, 20, 20, allTimes,
                40.00, EncounterMethod.GOOD_ROD, allVersions, violetCity));

        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes,
                93.00, EncounterMethod.SUPER_ROD, allVersions, violetCity));
        newEncounters.add(new Encounter(poliwag, 40, 40, allTimes,
                7.00, EncounterMethod.SUPER_ROD, allVersions, violetCity));

        newEncounters.add(new Encounter(togepi, 1, 1, allTimes,
                100.00, EncounterMethod.GIFT, allVersions, violetCity));
        newEncounters.add(new Encounter(mareep, 1, 1, allTimes,
                100.00, EncounterMethod.GIFT, allVersions, violetCity));
        newEncounters.add(new Encounter(wooper, 1, 1, allTimes,
                100.00, EncounterMethod.GIFT, allVersions, violetCity));
        newEncounters.add(new Encounter(slugma, 1, 1, allTimes,
                100.00, EncounterMethod.GIFT, allVersions, violetCity));

        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                violetCity.addEncounter(encounter);

        locationService.saveLocation(violetCity);
    }

    @Transactional
    protected void initializeSinjohRuins() {
        newEncounters = new ArrayList<>();
        Location sinjohRuins = locationService.getLocationByName("Sinjoh Ruins");

        Pokemon dialga = pokemonService.getByName("dialga");
        Pokemon palkia = pokemonService.getByName("palkia");
        Pokemon giratina = pokemonService.getByName("giratina");

        newEncounters.add(new Encounter(dialga, 1, 1, allTimes,
                100.00, EncounterMethod.GIFT, allVersions, sinjohRuins));
        newEncounters.add(new Encounter(palkia, 1, 1, allTimes,
                100.00, EncounterMethod.GIFT, allVersions, sinjohRuins));
        newEncounters.add(new Encounter(giratina, 1, 1, allTimes,
                100.00, EncounterMethod.GIFT, allVersions, sinjohRuins));

        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                sinjohRuins.addEncounter(encounter);

        locationService.saveLocation(sinjohRuins);
    }

    @Transactional
    protected void initializeOlivineCity() {
        newEncounters = new ArrayList<>();
        Location olivineCity = locationService.getLocationByName("Olivine City");

        Pokemon tentacool = pokemonService.getByName("tentacool");
        Pokemon tentacruel = pokemonService.getByName("tentacruel");
        Pokemon magikarp = pokemonService.getByName("magikarp");
        Pokemon krabby = pokemonService.getByName("krabby");
        Pokemon corsola = pokemonService.getByName("corsola");
        Pokemon staryu = pokemonService.getByName("staryu");
        Pokemon kingler = pokemonService.getByName("kingler");

        newEncounters.add(new Encounter(tentacool, 10, 25, allTimes,
                90.00, EncounterMethod.SURFING, allVersions, olivineCity));
        newEncounters.add(new Encounter(tentacruel, 10, 29, allTimes,
                10.00, EncounterMethod.SURFING, allVersions, olivineCity));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, olivineCity));
        newEncounters.add(new Encounter(krabby, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, olivineCity));

        newEncounters.add(new Encounter(magikarp, 25, 25, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, olivineCity));
        newEncounters.add(new Encounter(krabby, 25, 25, allTimes,
                37.00, EncounterMethod.GOOD_ROD, allVersions, olivineCity));
        newEncounters.add(new Encounter(corsola, 25, 25, morningDay,
                3.00, EncounterMethod.GOOD_ROD, allVersions, olivineCity));
        newEncounters.add(new Encounter(staryu, 25, 25, night,
                3.00, EncounterMethod.GOOD_ROD, allVersions, olivineCity));

        newEncounters.add(new Encounter(krabby, 40, 40, allTimes,
                67.00, EncounterMethod.SUPER_ROD, allVersions, olivineCity));
        newEncounters.add(new Encounter(kingler, 40, 40, allTimes,
                3.00, EncounterMethod.SUPER_ROD, allVersions, olivineCity));
        newEncounters.add(new Encounter(corsola, 40, 40, night,
                30.00, EncounterMethod.SUPER_ROD, allVersions, olivineCity));
        newEncounters.add(new Encounter(staryu, 40, 40, night,
                30.00, EncounterMethod.SUPER_ROD, allVersions, olivineCity));


        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                olivineCity.addEncounter(encounter);

        locationService.saveLocation(olivineCity);
    }

    @Transactional
    protected void initializeNewBarkTown() {
        newEncounters = new ArrayList<>();
        Location newBarkTown = locationService.getLocationByName("New Bark Town");


        Pokemon tentacool = pokemonService.getByName("tentacool");
        Pokemon tentacruel = pokemonService.getByName("tentacruel");
        Pokemon magikarp = pokemonService.getByName("magikarp");
        Pokemon chinchou = pokemonService.getByName("chinchou");
        Pokemon shellder = pokemonService.getByName("shellder");
        Pokemon lanturn = pokemonService.getByName("lanturn");
        Pokemon chikorita = pokemonService.getByName("chikorita");
        Pokemon cyndaquil = pokemonService.getByName("cyndaquil");
        Pokemon totodile = pokemonService.getByName("totodile");

        newEncounters.add(new Encounter(tentacool, 10, 25, allTimes,
                90.00, EncounterMethod.SURFING, allVersions, newBarkTown));
        newEncounters.add(new Encounter(tentacruel, 15, 29, allTimes,
                10.00, EncounterMethod.SURFING, allVersions, newBarkTown));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, newBarkTown));
        newEncounters.add(new Encounter(tentacool, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, newBarkTown));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, newBarkTown));
        newEncounters.add(new Encounter(tentacool, 20, 20, allTimes,
                30.00, EncounterMethod.GOOD_ROD, allVersions, newBarkTown));
        newEncounters.add(new Encounter(chinchou, 20, 20, allTimes,
                7.00, EncounterMethod.GOOD_ROD, allVersions, newBarkTown));
        newEncounters.add(new Encounter(shellder, 20, 20, allTimes,
                3.00, EncounterMethod.GOOD_ROD, allVersions, newBarkTown));

        newEncounters.add(new Encounter(chinchou, 40, 40, allTimes,
                60.00, EncounterMethod.SUPER_ROD, allVersions, newBarkTown));
        newEncounters.add(new Encounter(shellder, 40, 40, allTimes,
                30.00, EncounterMethod.SUPER_ROD, allVersions, newBarkTown));
        newEncounters.add(new Encounter(tentacruel, 40, 40, allTimes,
                7.00, EncounterMethod.SUPER_ROD, allVersions, newBarkTown));
        newEncounters.add(new Encounter(lanturn, 40, 40, allTimes,
                3.00, EncounterMethod.SUPER_ROD, allVersions, newBarkTown));


        newEncounters.add(new Encounter(chikorita, 5, 5, allTimes,
                100.00, EncounterMethod.GIFT, allVersions, newBarkTown));
        newEncounters.add(new Encounter(cyndaquil, 5, 5, allTimes,
                100.00, EncounterMethod.GIFT, allVersions, newBarkTown));
        newEncounters.add(new Encounter(totodile, 5, 5, allTimes,
                100.00, EncounterMethod.GIFT, allVersions, newBarkTown));


        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                newBarkTown.addEncounter(encounter);

        locationService.saveLocation(newBarkTown);
    }

    @Transactional
    protected void initializeGoldenRodCity() {
        newEncounters = new ArrayList<>();
        Location goldenrodCity = locationService.getLocationByName("Goldenrod City");

        Pokemon eevee = pokemonService.getByName("eevee");
        Pokemon spearow = pokemonService.getByName("spearow");
        Pokemon abra = pokemonService.getByName("abra");
        Pokemon ekans = pokemonService.getByName("ekans");
        Pokemon sandshrew = pokemonService.getByName("sandshrew");
        Pokemon dratini = pokemonService.getByName("dratini");

        newEncounters.add(new Encounter(eevee, 5, 5, allTimes,
                100.00, EncounterMethod.GIFT, allVersions, goldenrodCity));
        newEncounters.add(new Encounter(spearow, 20, 20, allTimes,
                100.00, EncounterMethod.GIFT, allVersions, goldenrodCity));
        newEncounters.add(new Encounter(abra, 20, 20, allTimes,
                100.00, EncounterMethod.GIFT, allVersions, goldenrodCity));
        newEncounters.add(new Encounter(ekans, 20, 20, allTimes,
                100.00, EncounterMethod.GIFT, heartGold, goldenrodCity));
        newEncounters.add(new Encounter(sandshrew, 20, 20, allTimes,
                100.00, EncounterMethod.GIFT, soulSilver, goldenrodCity));
        newEncounters.add(new Encounter(dratini, 20, 20, allTimes,
                100.00, EncounterMethod.GIFT, allVersions, goldenrodCity));

        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                goldenrodCity.addEncounter(encounter);

        locationService.saveLocation(goldenrodCity);
    }

    @Transactional
    protected void initializeEcruteakCity() {
        newEncounters = new ArrayList<>();
        Location ecruteakCity = locationService.getLocationByName("Ecruteak City");

        Pokemon poliwag = pokemonService.getByName("poliwag");
        Pokemon poliwhirl = pokemonService.getByName("poliwhirl");
        Pokemon magikarp = pokemonService.getByName("magikarp");

        newEncounters.add(new Encounter(poliwag, 10, 25, allTimes,
                90.00, EncounterMethod.SURFING, allVersions, ecruteakCity));
        newEncounters.add(new Encounter(poliwhirl, 15, 25, allTimes,
                10.00, EncounterMethod.SURFING, allVersions, ecruteakCity));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, ecruteakCity));
        newEncounters.add(new Encounter(poliwag, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, ecruteakCity));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, ecruteakCity));
        newEncounters.add(new Encounter(poliwag, 20, 20, allTimes,
                40.00, EncounterMethod.GOOD_ROD, allVersions, ecruteakCity));

        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes,
                93.00, EncounterMethod.SUPER_ROD, allVersions, ecruteakCity));
        newEncounters.add(new Encounter(poliwag, 40, 40, allTimes,
                7.00, EncounterMethod.SUPER_ROD, allVersions, ecruteakCity));


        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                ecruteakCity.addEncounter(encounter);

        locationService.saveLocation(ecruteakCity);
    }

    @Transactional
    protected void initializeCliffCave() {
        newEncounters = new ArrayList<>();
        Location cliffCave = locationService.getLocationByName("Cliff Cave");

        Pokemon golbat = pokemonService.getByName("golbat");
        Pokemon geodude = pokemonService.getByName("geodude");
        Pokemon machop = pokemonService.getByName("machop");
        Pokemon onix = pokemonService.getByName("onix");
        Pokemon krabby = pokemonService.getByName("krabby");
        Pokemon wooper = pokemonService.getByName("wooper");
        Pokemon kingler = pokemonService.getByName("kingler");
        Pokemon quagsire = pokemonService.getByName("quagsire");
        Pokemon graveler = pokemonService.getByName("graveler");
        Pokemon machoke = pokemonService.getByName("machoke");
        Pokemon steelix = pokemonService.getByName("steelix");
        Pokemon misdreavus = pokemonService.getByName("misdreavus");
        Pokemon zubat = pokemonService.getByName("zubat");

        newEncounters.add(new Encounter(golbat, 22, 22, allTimes,
                20.00, EncounterMethod.WALKING, allVersions, cliffCave, "1F"));
        newEncounters.add(new Encounter(geodude, 19, 19, allTimes,
                20.00, EncounterMethod.WALKING, allVersions, cliffCave, "1F"));
        newEncounters.add(new Encounter(machop, 19, 19, allTimes,
                10.00, EncounterMethod.WALKING, allVersions, cliffCave, "1F"));
        newEncounters.add(new Encounter(onix, 20, 20, allTimes,
                10.00, EncounterMethod.WALKING, allVersions, cliffCave, "1F"));
        newEncounters.add(new Encounter(krabby, 20, 20, allTimes,
                10.00, EncounterMethod.WALKING, allVersions, cliffCave, "1F"));
        newEncounters.add(new Encounter(kingler, 22, 22, allTimes,
                10.00, EncounterMethod.WALKING, allVersions, cliffCave, "1F"));
        newEncounters.add(new Encounter(wooper, 18, 18, morningDay,
                5.00, EncounterMethod.WALKING, allVersions, cliffCave, "1F"));
        newEncounters.add(new Encounter(quagsire, 20, 20, morningDay,
                5.00, EncounterMethod.WALKING, allVersions, cliffCave, "1F"));
        newEncounters.add(new Encounter(graveler, 20, 20, morningDay,
                4.00, EncounterMethod.WALKING, allVersions, cliffCave, "1F"));
        newEncounters.add(new Encounter(machoke, 22, 22, allTimes,
                2.00, EncounterMethod.WALKING, allVersions, cliffCave, "1F"));
        newEncounters.add(new Encounter(steelix, 23, 23, allTimes,
                2.00, EncounterMethod.WALKING, allVersions, cliffCave, "1F"));
        newEncounters.add(new Encounter(zubat, 18, 18, night,
                2.00, EncounterMethod.WALKING, allVersions, cliffCave, "1F"));
        newEncounters.add(new Encounter(misdreavus, 20, 20, night,
                2.00, EncounterMethod.WALKING, allVersions, cliffCave, "1F"));

        newEncounters.add(new Encounter(golbat, 22, 22, allTimes,
                20.00, EncounterMethod.WALKING, allVersions, cliffCave, "2F"));
        newEncounters.add(new Encounter(geodude, 19, 19, allTimes,
                20.00, EncounterMethod.WALKING, allVersions, cliffCave, "2F"));
        newEncounters.add(new Encounter(machop, 19, 19, allTimes,
                10.00, EncounterMethod.WALKING, allVersions, cliffCave, "2F"));
        newEncounters.add(new Encounter(onix, 20, 20, allTimes,
                10.00, EncounterMethod.WALKING, allVersions, cliffCave, "2F"));
        newEncounters.add(new Encounter(krabby, 20, 20, allTimes,
                10.00, EncounterMethod.WALKING, allVersions, cliffCave, "2F"));
        newEncounters.add(new Encounter(kingler, 22, 22, allTimes,
                10.00, EncounterMethod.WALKING, allVersions, cliffCave, "2F"));
        newEncounters.add(new Encounter(wooper, 18, 18, morningDay,
                5.00, EncounterMethod.WALKING, allVersions, cliffCave, "2F"));
        newEncounters.add(new Encounter(quagsire, 20, 20, morningDay,
                5.00, EncounterMethod.WALKING, allVersions, cliffCave, "2F"));
        newEncounters.add(new Encounter(graveler, 20, 20, morningDay,
                4.00, EncounterMethod.WALKING, allVersions, cliffCave, "2F"));
        newEncounters.add(new Encounter(machoke, 22, 22, allTimes,
                2.00, EncounterMethod.WALKING, allVersions, cliffCave, "2F"));
        newEncounters.add(new Encounter(steelix, 23, 23, allTimes,
                2.00, EncounterMethod.WALKING, allVersions, cliffCave, "2F"));
        newEncounters.add(new Encounter(zubat, 18, 18, night,
                2.00, EncounterMethod.WALKING, allVersions, cliffCave, "2F"));
        newEncounters.add(new Encounter(misdreavus, 20, 20, night,
                2.00, EncounterMethod.WALKING, allVersions, cliffCave, "2F"));

        newEncounters.add(new Encounter(golbat, 22, 22, allTimes,
                20.00, EncounterMethod.WALKING, allVersions, cliffCave, "B1F"));
        newEncounters.add(new Encounter(geodude, 19, 19, allTimes,
                20.00, EncounterMethod.WALKING, allVersions, cliffCave, "B1F"));
        newEncounters.add(new Encounter(machop, 19, 19, allTimes,
                10.00, EncounterMethod.WALKING, allVersions, cliffCave, "B1F"));
        newEncounters.add(new Encounter(onix, 20, 20, allTimes,
                10.00, EncounterMethod.WALKING, allVersions, cliffCave, "B1F"));
        newEncounters.add(new Encounter(krabby, 20, 20, allTimes,
                10.00, EncounterMethod.WALKING, allVersions, cliffCave, "B1F"));
        newEncounters.add(new Encounter(kingler, 22, 22, allTimes,
                10.00, EncounterMethod.WALKING, allVersions, cliffCave, "B1F"));
        newEncounters.add(new Encounter(wooper, 18, 18, morningDay,
                5.00, EncounterMethod.WALKING, allVersions, cliffCave, "B1F"));
        newEncounters.add(new Encounter(quagsire, 20, 20, morningDay,
                5.00, EncounterMethod.WALKING, allVersions, cliffCave, "B1F"));
        newEncounters.add(new Encounter(graveler, 20, 20, morningDay,
                4.00, EncounterMethod.WALKING, allVersions, cliffCave, "B1F"));
        newEncounters.add(new Encounter(machoke, 22, 22, allTimes,
                2.00, EncounterMethod.WALKING, allVersions, cliffCave, "B1F"));
        newEncounters.add(new Encounter(steelix, 23, 23, allTimes,
                2.00, EncounterMethod.WALKING, allVersions, cliffCave, "B1F"));
        newEncounters.add(new Encounter(zubat, 18, 18, night,
                2.00, EncounterMethod.WALKING, allVersions, cliffCave, "B1F"));
        newEncounters.add(new Encounter(misdreavus, 20, 20, night,
                2.00, EncounterMethod.WALKING, allVersions, cliffCave, "B1F"));

        newEncounters.add(new Encounter(krabby, 20, 26, allTimes,
                90.00, EncounterMethod.ROCK_SMASH, allVersions, cliffCave, "B1F"));
        newEncounters.add(new Encounter(kingler, 28, 31, allTimes,
                10.00, EncounterMethod.ROCK_SMASH, allVersions, cliffCave, "B1F"));


        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                cliffCave.addEncounter(encounter);

        locationService.saveLocation(cliffCave);
    }

    @Transactional
    protected void initializeCianwoodCity() {
        newEncounters = new ArrayList<>();
        Location cianwoodCity = locationService.getLocationByName("Cianwood City");

        Pokemon krabby = pokemonService.getByName("krabby");
        Pokemon shuckle = pokemonService.getByName("shuckle");
        Pokemon tentacool = pokemonService.getByName("tentacool");
        Pokemon tentacruel = pokemonService.getByName("tentacruel");
        Pokemon magikarp = pokemonService.getByName("magikarp");
        Pokemon corsola = pokemonService.getByName("corsola");
        Pokemon staryu = pokemonService.getByName("staryu");
        Pokemon kingler = pokemonService.getByName("kingler");

        newEncounters.add(new Encounter(krabby, 15, 24, allTimes,
                90.00, EncounterMethod.ROCK_SMASH, allVersions, cianwoodCity));
        newEncounters.add(new Encounter(shuckle, 23, 28, allTimes,
                10.00, EncounterMethod.ROCK_SMASH, allVersions, cianwoodCity));

        newEncounters.add(new Encounter(tentacool, 10, 25, allTimes,
                90.00, EncounterMethod.SURFING, allVersions, cianwoodCity));
        newEncounters.add(new Encounter(tentacruel, 10, 25, allTimes,
                10.00, EncounterMethod.SURFING, allVersions, cianwoodCity));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, cianwoodCity));
        newEncounters.add(new Encounter(krabby, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, cianwoodCity));

        newEncounters.add(new Encounter(magikarp, 25, 25, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, cianwoodCity));
        newEncounters.add(new Encounter(krabby, 25, 25, allTimes,
                37.00, EncounterMethod.GOOD_ROD, allVersions, cianwoodCity));
        newEncounters.add(new Encounter(corsola, 25, 25, morningDay,
                3.00, EncounterMethod.GOOD_ROD, allVersions, cianwoodCity));
        newEncounters.add(new Encounter(staryu, 25, 25, night,
                3.00, EncounterMethod.GOOD_ROD, allVersions, cianwoodCity));

        newEncounters.add(new Encounter(krabby, 40, 40, allTimes,
                67.00, EncounterMethod.SUPER_ROD, allVersions, cianwoodCity));
        newEncounters.add(new Encounter(kingler, 40, 40, allTimes,
                3.00, EncounterMethod.SUPER_ROD, allVersions, cianwoodCity));
        newEncounters.add(new Encounter(corsola, 40, 40, morningDay,
                30.00, EncounterMethod.SUPER_ROD, allVersions, cianwoodCity));
        newEncounters.add(new Encounter(staryu, 40, 40, night,
                30.00, EncounterMethod.SUPER_ROD, allVersions, cianwoodCity));

        newEncounters.add(new Encounter(shuckle, 20, 20, allTimes,
                100.00, EncounterMethod.GIFT, allVersions, cianwoodCity));
        newEncounters.add(new Encounter(tentacool, 15, 15, allTimes,
                100.00, EncounterMethod.GIFT, allVersions, cianwoodCity));

        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                cianwoodCity.addEncounter(encounter);

        locationService.saveLocation(cianwoodCity);
    }

    @Transactional
    protected void initializeCherrygroveCity() {
        newEncounters = new ArrayList<>();
        Location cherrygroveCity = locationService.getLocationByName("Cherrygrove City");

        Pokemon tentacool = pokemonService.getByName("tentacool");
        Pokemon tentacruel = pokemonService.getByName("tentacruel");
        Pokemon magikarp = pokemonService.getByName("magikarp");
        Pokemon krabby = pokemonService.getByName("krabby");
        Pokemon corsola = pokemonService.getByName("corsola");
        Pokemon staryu = pokemonService.getByName("staryu");
        Pokemon kingler = pokemonService.getByName("kingler");

        newEncounters.add(new Encounter(tentacool, 10, 25, allTimes,
                90.00, EncounterMethod.SURFING, allVersions, cherrygroveCity));
        newEncounters.add(new Encounter(tentacruel, 15, 25, allTimes,
                10.00, EncounterMethod.SURFING, allVersions, cherrygroveCity));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, cherrygroveCity));
        newEncounters.add(new Encounter(krabby, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, cherrygroveCity));

        newEncounters.add(new Encounter(magikarp, 25, 25, allTimes,
                60.00, EncounterMethod.GOOD_ROD, allVersions, cherrygroveCity));
        newEncounters.add(new Encounter(krabby, 25, 25, allTimes,
                37.00, EncounterMethod.GOOD_ROD, allVersions, cherrygroveCity));
        newEncounters.add(new Encounter(corsola, 25, 25, morningDay,
                3.00, EncounterMethod.GOOD_ROD, allVersions, cherrygroveCity));
        newEncounters.add(new Encounter(staryu, 25, 25, night,
                3.00, EncounterMethod.GOOD_ROD, allVersions, cherrygroveCity));

        newEncounters.add(new Encounter(krabby, 40, 40, allTimes,
                67.00, EncounterMethod.SUPER_ROD, allVersions, cherrygroveCity));
        newEncounters.add(new Encounter(kingler, 40, 40, allTimes,
                3.00, EncounterMethod.SUPER_ROD, allVersions, cherrygroveCity));
        newEncounters.add(new Encounter(corsola, 40, 40, morningDay,
                30.00, EncounterMethod.SUPER_ROD, allVersions, cherrygroveCity));
        newEncounters.add(new Encounter(staryu, 40, 40, night,
                30.00, EncounterMethod.SUPER_ROD, allVersions, cherrygroveCity));

        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                cherrygroveCity.addEncounter(encounter);

        locationService.saveLocation(cherrygroveCity);
    }

    @Transactional
    protected void initializeBlackthornCity() {
        newEncounters = new ArrayList<>();
        Location blackthornCity = locationService.getLocationByName("Blackthorn City");

        Pokemon magikarp = pokemonService.getByName("magikarp");
        Pokemon poliwag = pokemonService.getByName("poliwag");

        newEncounters.add(new Encounter(magikarp, 2, 20, allTimes,
                100.00, EncounterMethod.SURFING, allVersions, blackthornCity));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes,
                95.00, EncounterMethod.OLD_ROD, allVersions, blackthornCity));
        newEncounters.add(new Encounter(poliwag, 10, 10, allTimes,
                5.00, EncounterMethod.OLD_ROD, allVersions, blackthornCity));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes,
                60.00, EncounterMethod.OLD_ROD, allVersions, blackthornCity));
        newEncounters.add(new Encounter(poliwag, 20, 20, allTimes,
                40.00, EncounterMethod.OLD_ROD, allVersions, blackthornCity));

        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes,
                7.00, EncounterMethod.OLD_ROD, allVersions, blackthornCity));
        newEncounters.add(new Encounter(poliwag, 40, 40, allTimes,
                93.00, EncounterMethod.OLD_ROD, allVersions, blackthornCity));


        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                blackthornCity.addEncounter(encounter);

        locationService.saveLocation(blackthornCity);
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

    @Transactional
    protected void initializeRoute26() {

        newEncounters = new ArrayList<>();
        Location route26 = locationService.getLocationByName("Route 26");

        Pokemon doduo = pokemonService.getByName("doduo");
        Pokemon sandslash = pokemonService.getByName("sandslash");
        Pokemon ponyta = pokemonService.getByName("ponyta");
        Pokemon raticate = pokemonService.getByName("raticate");
        Pokemon dodrio = pokemonService.getByName("dodrio");
        Pokemon arbok = pokemonService.getByName("arbok");
        Pokemon quagsire = pokemonService.getByName("quagsire");
        Pokemon tentacool = pokemonService.getByName("tentacool");
        Pokemon tentacruel = pokemonService.getByName("tentacruel");
        Pokemon magikarp = pokemonService.getByName("magikarp");
        Pokemon chinchou = pokemonService.getByName("chinchou");
        Pokemon shellder = pokemonService.getByName("shellder");
        Pokemon lanturn = pokemonService.getByName("lanturn");


        newEncounters.add(new Encounter(doduo, 28, 30, morningDay, 40.00,
                EncounterMethod.WALKING, heartGold, route26));
        newEncounters.add(new Encounter(sandslash, 28, 28, morningDay, 5.00,
                EncounterMethod.WALKING, heartGold, route26));
        newEncounters.add(new Encounter(ponyta, 32, 32, morningDay, 20.00,
                EncounterMethod.WALKING, heartGold, route26));
        newEncounters.add(new Encounter(raticate, 30, 30, morningDay, 5.00,
                EncounterMethod.WALKING, heartGold, route26));
        newEncounters.add(new Encounter(dodrio, 30, 30, morningDay, 5.00,
                EncounterMethod.WALKING, heartGold, route26));
        newEncounters.add(new Encounter(doduo, 28, 30, morningDay, 40.00,
                EncounterMethod.WALKING, soulSilver, route26));
        newEncounters.add(new Encounter(ponyta, 32, 32, morningDay, 20.00,
                EncounterMethod.WALKING, soulSilver, route26));
        newEncounters.add(new Encounter(raticate, 28, 30, morningDay, 35.00,
                EncounterMethod.WALKING, soulSilver, route26));
        newEncounters.add(new Encounter(arbok, 30, 30, morningDay, 5.00,
                EncounterMethod.WALKING, soulSilver, route26));


        newEncounters.add(new Encounter(raticate, 28, 28, night, 50.00,
                EncounterMethod.WALKING, soulSilver, route26));
        newEncounters.add(new Encounter(ponyta, 32, 32, night, 20.00,
                EncounterMethod.WALKING, soulSilver, route26));
        newEncounters.add(new Encounter(doduo, 30, 30, night, 5.00,
                EncounterMethod.WALKING, soulSilver, route26));
        newEncounters.add(new Encounter(arbok, 30, 30, night, 5.00,
                EncounterMethod.WALKING, soulSilver, route26));
        newEncounters.add(new Encounter(raticate, 28, 30, night, 40.00,
                EncounterMethod.WALKING, heartGold, route26));
        newEncounters.add(new Encounter(sandslash, 28, 28, night, 30.00,
                EncounterMethod.WALKING, heartGold, route26));
        newEncounters.add(new Encounter(ponyta, 32, 32, night, 20.00,
                EncounterMethod.WALKING, heartGold, route26));
        newEncounters.add(new Encounter(quagsire, 30, 30, night, 10.00,
                EncounterMethod.WALKING, heartGold, route26));


        newEncounters.add(new Encounter(tentacool, 25, 30, allTimes, 90.00,
                EncounterMethod.SURFING, allVersions, route26));
        newEncounters.add(new Encounter(tentacruel, 30, 30, allTimes, 10.00,
                EncounterMethod.SURFING, allVersions, route26));

        newEncounters.add(new Encounter(tentacool, 10, 10, allTimes, 95.00,
                EncounterMethod.OLD_ROD, allVersions, route26));
        newEncounters.add(new Encounter(tentacruel, 10, 10, allTimes, 5.00,
                EncounterMethod.OLD_ROD, allVersions, route26));


        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes, 60.00,
                EncounterMethod.GOOD_ROD, allVersions, route26));
        newEncounters.add(new Encounter(tentacool, 20, 20, allTimes, 30.00,
                EncounterMethod.GOOD_ROD, allVersions, route26));
        newEncounters.add(new Encounter(chinchou, 20, 20, allTimes, 7.00,
                EncounterMethod.GOOD_ROD, allVersions, route26));
        newEncounters.add(new Encounter(shellder, 20, 20, allTimes, 3.00,
                EncounterMethod.GOOD_ROD, allVersions, route26));


        newEncounters.add(new Encounter(chinchou, 40, 40, allTimes, 60.00,
                EncounterMethod.SUPER_ROD, allVersions, route26));
        newEncounters.add(new Encounter(shellder, 40, 40, allTimes, 30.00,
                EncounterMethod.SUPER_ROD, allVersions, route26));
        newEncounters.add(new Encounter(tentacruel, 40, 40, allTimes, 7.00,
                EncounterMethod.SUPER_ROD, allVersions, route26));
        newEncounters.add(new Encounter(lanturn, 40, 40, allTimes, 3.00,
                EncounterMethod.SUPER_ROD, allVersions, route26));



        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                route26.addEncounter(encounter);

        locationService.saveLocation(route26);
    }

    @Transactional
    protected void initializeRoute27() {
        newEncounters = new ArrayList<>();
        Location route27 = locationService.getLocationByName("Route 27");

        Pokemon doduo = pokemonService.getByName("doduo");
        Pokemon sandslash = pokemonService.getByName("sandslash");
        Pokemon ponyta = pokemonService.getByName("ponyta");
        Pokemon raticate = pokemonService.getByName("raticate");
        Pokemon dodrio = pokemonService.getByName("dodrio");
        Pokemon arbok = pokemonService.getByName("arbok");
        Pokemon quagsire = pokemonService.getByName("quagsire");
        Pokemon tentacool = pokemonService.getByName("tentacool");
        Pokemon tentacruel = pokemonService.getByName("tentacruel");
        Pokemon magikarp = pokemonService.getByName("magikarp");
        Pokemon chinchou = pokemonService.getByName("chinchou");
        Pokemon shellder = pokemonService.getByName("shellder");
        Pokemon lanturn = pokemonService.getByName("lanturn");

        newEncounters.add(new Encounter(doduo, 28, 30, morningDay, 50.00,
                EncounterMethod.WALKING, heartGold, route27));
        newEncounters.add(new Encounter(raticate, 28, 30, morningDay, 40.00,
                EncounterMethod.WALKING, heartGold, route27));
        newEncounters.add(new Encounter(sandslash, 20, 20, morningDay, 5.00,
                EncounterMethod.WALKING, heartGold, route27));
        newEncounters.add(new Encounter(ponyta, 32, 32, morningDay, 5.00,
                EncounterMethod.WALKING, heartGold, route27));

        newEncounters.add(new Encounter(doduo, 28, 30, morningDay, 40.00,
                EncounterMethod.WALKING, soulSilver, route27));
        newEncounters.add(new Encounter(arbok, 28, 28, morningDay, 30.00,
                EncounterMethod.WALKING, soulSilver, route27));
        newEncounters.add(new Encounter(raticate, 30, 30, morningDay, 20.00,
                EncounterMethod.WALKING, soulSilver, route27));
        newEncounters.add(new Encounter(ponyta, 32, 32, morningDay, 5.00,
                EncounterMethod.WALKING, soulSilver, route27));
        newEncounters.add(new Encounter(dodrio, 30, 30, morningDay, 5.00,
                EncounterMethod.WALKING, soulSilver, route27));

        newEncounters.add(new Encounter(quagsire, 28, 30, night, 50.00,
                EncounterMethod.WALKING, heartGold, route27));
        newEncounters.add(new Encounter(raticate, 28, 30, night, 40.00,
                EncounterMethod.WALKING, heartGold, route27));
        newEncounters.add(new Encounter(sandslash, 20, 20, night, 5.00,
                EncounterMethod.WALKING, heartGold, route27));
        newEncounters.add(new Encounter(ponyta, 32, 32, night, 5.00,
                EncounterMethod.WALKING, heartGold, route27));

        newEncounters.add(new Encounter(quagsire, 28, 30, night, 55.00,
                EncounterMethod.WALKING, soulSilver, route27));
        newEncounters.add(new Encounter(arbok, 28, 28, night, 30.00,
                EncounterMethod.WALKING, soulSilver, route27));
        newEncounters.add(new Encounter(raticate, 30, 30, night, 10.00,
                EncounterMethod.WALKING, soulSilver, route27));
        newEncounters.add(new Encounter(ponyta, 32, 32, night, 5.00,
                EncounterMethod.WALKING, soulSilver, route27));


        newEncounters.add(new Encounter(tentacool, 25, 30, allTimes, 90.00,
                EncounterMethod.SURFING, allVersions, route27));
        newEncounters.add(new Encounter(tentacruel, 30, 30, allTimes, 10.00,
                EncounterMethod.SURFING, allVersions, route27));

        newEncounters.add(new Encounter(tentacool, 10, 10, allTimes, 95.00,
                EncounterMethod.OLD_ROD, allVersions, route27));
        newEncounters.add(new Encounter(tentacruel, 10, 10, allTimes, 5.00,
                EncounterMethod.OLD_ROD, allVersions, route27));


        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes, 60.00,
                EncounterMethod.GOOD_ROD, allVersions, route27));
        newEncounters.add(new Encounter(tentacool, 20, 20, allTimes, 30.00,
                EncounterMethod.GOOD_ROD, allVersions, route27));
        newEncounters.add(new Encounter(chinchou, 20, 20, allTimes, 7.00,
                EncounterMethod.GOOD_ROD, allVersions, route27));
        newEncounters.add(new Encounter(shellder, 20, 20, allTimes, 3.00,
                EncounterMethod.GOOD_ROD, allVersions, route27));


        newEncounters.add(new Encounter(chinchou, 40, 40, allTimes, 60.00,
                EncounterMethod.SUPER_ROD, allVersions, route27));
        newEncounters.add(new Encounter(shellder, 40, 40, allTimes, 30.00,
                EncounterMethod.SUPER_ROD, allVersions, route27));
        newEncounters.add(new Encounter(tentacruel, 40, 40, allTimes, 7.00,
                EncounterMethod.SUPER_ROD, allVersions, route27));
        newEncounters.add(new Encounter(lanturn, 40, 40, allTimes, 3.00,
                EncounterMethod.SUPER_ROD, allVersions, route27));



        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                route27.addEncounter(encounter);

        locationService.saveLocation(route27);
    }

    @Transactional
    protected void initializeTohjoFalls() {
        newEncounters = new ArrayList<>();
        Location tohjoFalls = locationService.getLocationByName("Tohjo Falls");

        Pokemon raticate = pokemonService.getByName("raticate");
        Pokemon zubat = pokemonService.getByName("zubat");
        Pokemon golbat = pokemonService.getByName("golbat");
        Pokemon slowpoke = pokemonService.getByName("slowpoke");
        Pokemon rattata = pokemonService.getByName("rattata");
        Pokemon goldeen = pokemonService.getByName("goldeen");
        Pokemon seaking = pokemonService.getByName("seaking");
        Pokemon magikarp = pokemonService.getByName("magikarp");

        newEncounters.add(new Encounter(raticate, 22, 22, allTimes, 30.00,
                EncounterMethod.WALKING, allVersions, tohjoFalls));
        newEncounters.add(new Encounter(zubat, 22, 22, allTimes, 30.00,
                EncounterMethod.WALKING, allVersions, tohjoFalls));
        newEncounters.add(new Encounter(golbat, 22, 22, allTimes, 20.00,
                EncounterMethod.WALKING, allVersions, tohjoFalls));
        newEncounters.add(new Encounter(slowpoke, 20, 23, allTimes, 15.00,
                EncounterMethod.WALKING, allVersions, tohjoFalls));
        newEncounters.add(new Encounter(rattata, 20, 20, allTimes, 5.00,
                EncounterMethod.WALKING, allVersions, tohjoFalls));

        newEncounters.add(new Encounter(goldeen, 20, 20, allTimes, 60.00,
                EncounterMethod.SURFING, allVersions, tohjoFalls));
        newEncounters.add(new Encounter(slowpoke, 20, 20, allTimes, 30.00,
                EncounterMethod.SURFING, allVersions, tohjoFalls));
        newEncounters.add(new Encounter(seaking, 20, 20, allTimes, 10.00,
                EncounterMethod.SURFING, allVersions, tohjoFalls));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes, 95.00,
                EncounterMethod.OLD_ROD, allVersions, tohjoFalls));
        newEncounters.add(new Encounter(goldeen, 10, 10, allTimes, 5.00,
                EncounterMethod.OLD_ROD, allVersions, tohjoFalls));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes, 60.00,
                EncounterMethod.GOOD_ROD, allVersions, tohjoFalls));
        newEncounters.add(new Encounter(goldeen, 20, 20, allTimes, 40.00,
                EncounterMethod.GOOD_ROD, allVersions, tohjoFalls));

        newEncounters.add(new Encounter(goldeen, 40, 40, allTimes, 90.00,
                EncounterMethod.SUPER_ROD, allVersions, tohjoFalls));
        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes, 7.00,
                EncounterMethod.SUPER_ROD, allVersions, tohjoFalls));
        newEncounters.add(new Encounter(seaking, 40, 40, allTimes, 3.00,
                EncounterMethod.SUPER_ROD, allVersions, tohjoFalls));

        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                tohjoFalls.addEncounter(encounter);

        locationService.saveLocation(tohjoFalls);
    }

    @Transactional
    protected void initializeVictoryRoad() {
        newEncounters = new ArrayList<>();
        Location victoryRoad = locationService.getLocationByName("Victory Road");

        Pokemon golbat = pokemonService.getByName("golbat");
        Pokemon graveler = pokemonService.getByName("graveler");
        Pokemon donphan = pokemonService.getByName("donphan");
        Pokemon onix = pokemonService.getByName("onix");
        Pokemon rhyhorn = pokemonService.getByName("rhyhorn");
        Pokemon ursaring = pokemonService.getByName("ursaring");
        Pokemon geodude =  pokemonService.getByName("geodude");

        newEncounters.add(new Encounter(golbat, 32, 32, allTimes, 30.00,
                EncounterMethod.WALKING, allVersions, victoryRoad, "1F"));
        newEncounters.add(new Encounter(graveler, 32, 32, allTimes, 30.00,
                EncounterMethod.WALKING, allVersions, victoryRoad, "1F"));
        newEncounters.add(new Encounter(onix, 34, 36, allTimes, 15.00,
                EncounterMethod.WALKING, allVersions, victoryRoad, "1F"));
        newEncounters.add(new Encounter(rhyhorn, 35, 35, allTimes, 5.00,
                EncounterMethod.WALKING, allVersions, victoryRoad, "1F"));

        newEncounters.add(new Encounter(donphan, 33, 33, allTimes, 20.00,
                EncounterMethod.WALKING, heartGold, victoryRoad, "1F"));
        newEncounters.add(new Encounter(ursaring, 33, 33, allTimes, 20.00,
                EncounterMethod.WALKING, soulSilver, victoryRoad, "1F"));


        newEncounters.add(new Encounter(golbat, 32, 32, allTimes, 30.00,
                EncounterMethod.WALKING, allVersions, victoryRoad, "2F"));
        newEncounters.add(new Encounter(graveler, 32, 32, allTimes, 30.00,
                EncounterMethod.WALKING, allVersions, victoryRoad, "2F"));
        newEncounters.add(new Encounter(onix, 34, 36, allTimes, 15.00,
                EncounterMethod.WALKING, allVersions, victoryRoad, "2F"));
        newEncounters.add(new Encounter(rhyhorn, 35, 35, allTimes, 5.00,
                EncounterMethod.WALKING, allVersions, victoryRoad, "2F"));

        newEncounters.add(new Encounter(donphan, 33, 33, allTimes, 20.00,
                EncounterMethod.WALKING, heartGold, victoryRoad, "2F"));
        newEncounters.add(new Encounter(ursaring, 33, 33, allTimes, 20.00,
                EncounterMethod.WALKING, soulSilver, victoryRoad, "2F"));

        newEncounters.add(new Encounter(golbat, 32, 32, allTimes, 30.00,
                EncounterMethod.WALKING, allVersions, victoryRoad, "3F"));
        newEncounters.add(new Encounter(graveler, 32, 32, allTimes, 30.00,
                EncounterMethod.WALKING, allVersions, victoryRoad, "3F"));
        newEncounters.add(new Encounter(onix, 34, 36, allTimes, 15.00,
                EncounterMethod.WALKING, allVersions, victoryRoad, "3F"));
        newEncounters.add(new Encounter(rhyhorn, 35, 35, allTimes, 5.00,
                EncounterMethod.WALKING, allVersions, victoryRoad, "3F"));

        newEncounters.add(new Encounter(donphan, 33, 33, allTimes, 20.00,
                EncounterMethod.WALKING, heartGold, victoryRoad, "3F"));
        newEncounters.add(new Encounter(ursaring, 33, 33, allTimes, 20.00,
                EncounterMethod.WALKING, soulSilver, victoryRoad, "3F"));

        newEncounters.add(new Encounter(geodude, 24, 32, allTimes, 90.00,
                EncounterMethod.ROCK_SMASH, allVersions, victoryRoad, "3F"));
        newEncounters.add(new Encounter(graveler, 30, 33, allTimes, 10.00,
                EncounterMethod.ROCK_SMASH, allVersions, victoryRoad, "3F"));

        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                victoryRoad.addEncounter(encounter);

        locationService.saveLocation(victoryRoad);
    }

    @Transactional
    protected void initializeRoute22() {
        newEncounters = new ArrayList<>();
        Location route22 = locationService.getLocationByName("Route 22");

        Pokemon spearow = pokemonService.getByName("spearow");
        Pokemon rattata = pokemonService.getByName("rattata");
        Pokemon doduo = pokemonService.getByName("doduo");
        Pokemon fearow = pokemonService.getByName("fearow");
        Pokemon ponyta = pokemonService.getByName("ponyta");
        Pokemon poliwag = pokemonService.getByName("poliwag");
        Pokemon poliwhirl = pokemonService.getByName("poliwhirl");
        Pokemon magikarp = pokemonService.getByName("magikarp");

        newEncounters.add(new Encounter(spearow, 3, 5, morningDay, 50.00,
                EncounterMethod.WALKING, allVersions, route22));
        newEncounters.add(new Encounter(rattata, 3, 3, morningDay, 30.00,
                EncounterMethod.WALKING, allVersions, route22));
        newEncounters.add(new Encounter(doduo, 4, 4, morningDay, 10.00,
                EncounterMethod.WALKING, allVersions, route22));
        newEncounters.add(new Encounter(fearow, 7, 7, morningDay, 5.00,
                EncounterMethod.WALKING, allVersions, route22));
        newEncounters.add(new Encounter(ponyta, 6, 6, morningDay, 5.00,
                EncounterMethod.WALKING, allVersions, route22));

        newEncounters.add(new Encounter(rattata, 3, 7, night, 95.00,
                EncounterMethod.WALKING, allVersions, route22));
        newEncounters.add(new Encounter(ponyta, 6, 6, night, 5.00,
                EncounterMethod.WALKING, allVersions, route22));

        newEncounters.add(new Encounter(poliwag, 5, 10, allTimes, 90.00,
                EncounterMethod.SURFING, allVersions, route22));
        newEncounters.add(new Encounter(poliwhirl, 10, 10, allTimes, 10.00,
                EncounterMethod.SURFING, allVersions, route22));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes, 95.00,
                EncounterMethod.OLD_ROD, allVersions, route22));
        newEncounters.add(new Encounter(poliwhirl, 10, 10, allTimes, 5.00,
                EncounterMethod.OLD_ROD, allVersions, route22));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes, 60.00,
                EncounterMethod.GOOD_ROD, allVersions, route22));
        newEncounters.add(new Encounter(poliwhirl, 20, 20, allTimes, 40.00,
                EncounterMethod.GOOD_ROD, allVersions, route22));

        newEncounters.add(new Encounter(poliwag, 40, 40, allTimes, 93.00,
                EncounterMethod.SUPER_ROD, allVersions, route22));
        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes, 7.00,
                EncounterMethod.SUPER_ROD, allVersions, route22));

        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                route22.addEncounter(encounter);

        locationService.saveLocation(route22);
    }

    @Transactional
    protected void initializeRoute28() {
        newEncounters = new ArrayList<>();
        Location route28 = locationService.getLocationByName("Route 28");

        Pokemon tangela = pokemonService.getByName("tangela");
        Pokemon donphan = pokemonService.getByName("donphan");
        Pokemon rapidash = pokemonService.getByName("rapidash");
        Pokemon doduo = pokemonService.getByName("doduo");
        Pokemon dodrio = pokemonService.getByName("dodrio");
        Pokemon ponyta = pokemonService.getByName("ponyta");
        Pokemon poliwag = pokemonService.getByName("poliwag");
        Pokemon poliwhirl = pokemonService.getByName("poliwhirl");
        Pokemon magikarp = pokemonService.getByName("magikarp");
        Pokemon ursaring = pokemonService.getByName("ursaring");
        Pokemon sneasel = pokemonService.getByName("sneasel");

        newEncounters.add(new Encounter(ponyta, 40, 40, allTimes, 30.00,
                EncounterMethod.WALKING, allVersions, route28));
        newEncounters.add(new Encounter(tangela, 39, 39, allTimes, 30.00,
                EncounterMethod.WALKING, allVersions, route28));
        newEncounters.add(new Encounter(rapidash, 42, 42, allTimes, 10.00,
                EncounterMethod.WALKING, allVersions, route28));
        newEncounters.add(new Encounter(doduo, 41, 41, morningDay, 5.00,
                EncounterMethod.WALKING, allVersions, route28));
        newEncounters.add(new Encounter(dodrio, 43, 43, morningDay, 5.00,
                EncounterMethod.WALKING, allVersions, route28));

        newEncounters.add(new Encounter(donphan, 40, 40, allTimes, 20.00,
                EncounterMethod.WALKING, heartGold, route28));
        newEncounters.add(new Encounter(ursaring, 40, 40, allTimes, 20.00,
                EncounterMethod.WALKING, soulSilver, route28));

        newEncounters.add(new Encounter(sneasel, 42, 42, night, 10.00,
                EncounterMethod.WALKING, allVersions, route28));


        newEncounters.add(new Encounter(poliwag, 35, 40, allTimes, 90.00,
                EncounterMethod.SURFING, allVersions, route28));
        newEncounters.add(new Encounter(poliwhirl, 40, 40, allTimes, 10.00,
                EncounterMethod.SURFING, allVersions, route28));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes, 95.00,
                EncounterMethod.OLD_ROD, allVersions, route28));
        newEncounters.add(new Encounter(poliwhirl, 10, 10, allTimes, 5.00,
                EncounterMethod.OLD_ROD, allVersions, route28));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes, 60.00,
                EncounterMethod.GOOD_ROD, allVersions, route28));
        newEncounters.add(new Encounter(poliwhirl, 20, 20, allTimes, 40.00,
                EncounterMethod.GOOD_ROD, allVersions, route28));

        newEncounters.add(new Encounter(poliwag, 40, 40, allTimes, 93.00,
                EncounterMethod.SUPER_ROD, allVersions, route28));
        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes, 7.00,
                EncounterMethod.SUPER_ROD, allVersions, route28));


        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                route28.addEncounter(encounter);

        locationService.saveLocation(route28);
    }

    @Transactional
    protected void initializeMtSilver() {
        newEncounters = new ArrayList<>();
        Location mtSilver = locationService.getLocationByName("Mt Silver");

        Pokemon tangela = pokemonService.getByName("tangela");
        Pokemon donphan = pokemonService.getByName("donphan");
        Pokemon rapidash = pokemonService.getByName("rapidash");
        Pokemon doduo = pokemonService.getByName("doduo");
        Pokemon dodrio = pokemonService.getByName("dodrio");
        Pokemon ponyta = pokemonService.getByName("ponyta");
        Pokemon poliwag = pokemonService.getByName("poliwag");
        Pokemon poliwhirl = pokemonService.getByName("poliwhirl");
        Pokemon magikarp = pokemonService.getByName("magikarp");
        Pokemon ursaring = pokemonService.getByName("ursaring");
        Pokemon sneasel = pokemonService.getByName("sneasel");
        Pokemon quagsire = pokemonService.getByName("quagsire");
        Pokemon steelix = pokemonService.getByName("steelix");
        Pokemon golduck = pokemonService.getByName("golduck");
        Pokemon golbat = pokemonService.getByName("golbat");
        Pokemon larvitar = pokemonService.getByName("larvitar");
        Pokemon misdreavus = pokemonService.getByName("misdreavus");
        Pokemon goldeen = pokemonService.getByName("goldeen");
        Pokemon seaking = pokemonService.getByName("seaking");
        Pokemon phanpy = pokemonService.getByName("phanpy");
        Pokemon teddiursa = pokemonService.getByName("teddiursa");
        Pokemon moltres = pokemonService.getByName("moltres");
        Pokemon onix = pokemonService.getByName("onix");
        Pokemon graveler = pokemonService.getByName("graveler");
        Pokemon gyarados =  pokemonService.getByName("gyarados");
        Pokemon pupitar = pokemonService.getByName("pupitar");

        newEncounters.add(new Encounter(ponyta, 42, 42, allTimes, 30.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "outside"));
        newEncounters.add(new Encounter(tangela, 41, 42, allTimes, 30.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "outside"));
        newEncounters.add(new Encounter(rapidash, 44, 44, allTimes, 10.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "outside"));
        newEncounters.add(new Encounter(doduo, 41, 41, morningDay, 5.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "outside"));
        newEncounters.add(new Encounter(dodrio, 43, 43, morningDay, 5.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "outside"));

        newEncounters.add(new Encounter(donphan, 42, 42, allTimes, 20.00,
                EncounterMethod.WALKING, heartGold, mtSilver, "outside"));
        newEncounters.add(new Encounter(ursaring, 42, 42, allTimes, 20.00,
                EncounterMethod.WALKING, soulSilver, mtSilver, "outside"));

        newEncounters.add(new Encounter(sneasel, 41, 43, night, 10.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "outside"));


        newEncounters.add(new Encounter(poliwag, 35, 40, allTimes, 90.00,
                EncounterMethod.SURFING, allVersions, mtSilver, "outside"));
        newEncounters.add(new Encounter(poliwhirl, 40, 40, allTimes, 10.00,
                EncounterMethod.SURFING, allVersions, mtSilver, "outside"));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes, 95.00,
                EncounterMethod.OLD_ROD, allVersions, mtSilver, "outside"));
        newEncounters.add(new Encounter(poliwhirl, 10, 10, allTimes, 5.00,
                EncounterMethod.OLD_ROD, allVersions, mtSilver, "outside"));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes, 60.00,
                EncounterMethod.GOOD_ROD, allVersions, mtSilver, "outside"));
        newEncounters.add(new Encounter(poliwhirl, 20, 20, allTimes, 40.00,
                EncounterMethod.GOOD_ROD, allVersions, mtSilver, "outside"));

        newEncounters.add(new Encounter(poliwag, 40, 40, allTimes, 93.00,
                EncounterMethod.SUPER_ROD, allVersions, mtSilver, "outside"));
        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes, 7.00,
                EncounterMethod.SUPER_ROD, allVersions, mtSilver, "outside"));


        newEncounters.add(new Encounter(quagsire, 45, 45, morningDay, 40.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "1F"));
        newEncounters.add(new Encounter(steelix, 48, 48, morningDay, 40.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "1F"));
        newEncounters.add(new Encounter(golduck, 48, 48, morningDay, 40.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "1F"));
        newEncounters.add(new Encounter(golbat, 48, 48, morningDay, 40.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "1F"));
        newEncounters.add(new Encounter(larvitar, 15, 20, morningDay, 40.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "1F"));

        newEncounters.add(new Encounter(donphan, 47, 48, allTimes, 20.00,
                EncounterMethod.WALKING, heartGold, mtSilver, "1F"));
        newEncounters.add(new Encounter(ursaring, 47, 48, allTimes, 20.00,
                EncounterMethod.WALKING, soulSilver, mtSilver, "1F"));


        newEncounters.add(new Encounter(quagsire, 45, 45, night, 30.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "1F"));
        newEncounters.add(new Encounter(steelix, 48, 48, night, 20.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "1F"));
        newEncounters.add(new Encounter(golduck, 48, 48, night, 10.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "1F"));
        newEncounters.add(new Encounter(misdreavus, 45, 45, night, 10.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "1F"));
        newEncounters.add(new Encounter(golbat, 48, 48, night, 5.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "1F"));
        newEncounters.add(new Encounter(larvitar, 15, 20, night, 5.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "1F"));

        newEncounters.add(new Encounter(donphan, 47, 48, night, 20.00,
                EncounterMethod.WALKING, heartGold, mtSilver, "1F"));
        newEncounters.add(new Encounter(ursaring, 47, 48, night, 20.00,
                EncounterMethod.WALKING, soulSilver, mtSilver, "1F"));



        newEncounters.add(new Encounter(quagsire, 45, 45, allTimes, 30.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "1F Top"));
        newEncounters.add(new Encounter(sneasel, 48, 48, allTimes, 20.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "1F Top"));
        newEncounters.add(new Encounter(golduck, 48, 48, morningDay, 15.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "1F Top"));
        newEncounters.add(new Encounter(golbat, 48, 48, allTimes, 5.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "1F Top"));
        newEncounters.add(new Encounter(larvitar, 15, 20, allTimes, 5.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "1F Top"));

        newEncounters.add(new Encounter(phanpy, 46, 46, allTimes, 10.00,
                EncounterMethod.WALKING, heartGold, mtSilver, "1F Top"));
        newEncounters.add(new Encounter(teddiursa, 46, 46, allTimes, 10.00,
                EncounterMethod.WALKING, soulSilver, mtSilver, "1F Top"));
        newEncounters.add(new Encounter(donphan, 48, 50, allTimes, 10.00,
                EncounterMethod.WALKING, heartGold, mtSilver, "1F Top"));
        newEncounters.add(new Encounter(ursaring, 48, 50, allTimes, 10.00,
                EncounterMethod.WALKING, soulSilver, mtSilver, "1F Top"));

        newEncounters.add(new Encounter(misdreavus, 45, 45, night, 10.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "1F Top"));

        newEncounters.add(new Encounter(moltres, 50, 50, allTimes, 100.00,
                EncounterMethod.ENCOUNTER, soulSilver, mtSilver, "1F Top"));



        newEncounters.add(new Encounter(onix, 42, 42, allTimes, 30.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "2F"));
        newEncounters.add(new Encounter(graveler, 44, 44, allTimes, 30.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "2F"));
        newEncounters.add(new Encounter(golbat, 45, 45, morningDay, 5.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "2F"));
        newEncounters.add(new Encounter(larvitar, 15, 20, allTimes, 5.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "2F"));

        newEncounters.add(new Encounter(phanpy, 43, 43, allTimes, 10.00,
                EncounterMethod.WALKING, heartGold, mtSilver, "2F"));
        newEncounters.add(new Encounter(teddiursa, 43, 43, allTimes, 10.00,
                EncounterMethod.WALKING, soulSilver, mtSilver, "2F"));
        newEncounters.add(new Encounter(donphan, 44, 44, allTimes, 30.00,
                EncounterMethod.WALKING, heartGold, mtSilver, "2F"));
        newEncounters.add(new Encounter(ursaring, 44, 44, allTimes, 30.00,
                EncounterMethod.WALKING, soulSilver, mtSilver, "2F"));




        newEncounters.add(new Encounter(golduck, 48, 48, allTimes, 30.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "3F"));
        newEncounters.add(new Encounter(sneasel, 50, 50, allTimes, 20.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "3F"));
        newEncounters.add(new Encounter(quagsire, 45, 45, morningDay, 15.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "3F"));
        newEncounters.add(new Encounter(larvitar, 15, 20, allTimes, 5.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "3F"));
        newEncounters.add(new Encounter(golbat, 48, 48, allTimes, 5.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "3F"));

        newEncounters.add(new Encounter(donphan, 47, 47, allTimes, 20.00,
                EncounterMethod.WALKING, heartGold, mtSilver, "3F"));
        newEncounters.add(new Encounter(ursaring, 47, 47, allTimes, 20.00,
                EncounterMethod.WALKING, soulSilver, mtSilver, "3F"));

        newEncounters.add(new Encounter(misdreavus, 45, 45, night, 10.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "3F"));



        newEncounters.add(new Encounter(golduck, 48, 48, allTimes, 30.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "4F"));
        newEncounters.add(new Encounter(sneasel, 50, 50, allTimes, 20.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "4F"));
        newEncounters.add(new Encounter(quagsire, 45, 45, morningDay, 15.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "4F"));
        newEncounters.add(new Encounter(larvitar, 15, 20, allTimes, 5.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "4F"));
        newEncounters.add(new Encounter(golbat, 48, 48, allTimes, 5.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "4F"));

        newEncounters.add(new Encounter(donphan, 47, 47, allTimes, 20.00,
                EncounterMethod.WALKING, heartGold, mtSilver, "4F"));
        newEncounters.add(new Encounter(ursaring, 47, 47, allTimes, 20.00,
                EncounterMethod.WALKING, soulSilver, mtSilver, "4F"));

        newEncounters.add(new Encounter(quagsire, 45, 45, night, 10.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "4F"));
        newEncounters.add(new Encounter(misdreavus, 45, 45, night, 10.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "4F"));


        newEncounters.add(new Encounter(golbat, 48, 51, allTimes, 40.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "Mountain Side"));
        newEncounters.add(new Encounter(onix, 48, 48, allTimes, 30.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "Mountain Side"));
        newEncounters.add(new Encounter(golduck, 51, 51, allTimes, 5.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "Mountain Side"));
        newEncounters.add(new Encounter(larvitar, 15, 20, allTimes, 5.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "Mountain Side"));


        newEncounters.add(new Encounter(phanpy, 48, 48, allTimes, 10.00,
                EncounterMethod.WALKING, heartGold, mtSilver, "Mountain Side"));
        newEncounters.add(new Encounter(teddiursa, 48, 48, allTimes, 10.00,
                EncounterMethod.WALKING, soulSilver, mtSilver, "Mountain Side"));

        newEncounters.add(new Encounter(donphan, 50, 50, allTimes, 10.00,
                EncounterMethod.WALKING, heartGold, mtSilver, "Mountain Side"));
        newEncounters.add(new Encounter(ursaring, 50, 50, allTimes, 10.00,
                EncounterMethod.WALKING, soulSilver, mtSilver, "Mountain Side"));




        newEncounters.add(new Encounter(golduck, 48, 48, morningDay, 30.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "Top"));
        newEncounters.add(new Encounter(sneasel, 45, 45, morningDay, 20.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "Top"));
        newEncounters.add(new Encounter(quagsire, 45, 45, morningDay, 15.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "Top"));
        newEncounters.add(new Encounter(larvitar, 15, 30, morningDay, 10.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "Top"));
        newEncounters.add(new Encounter(golbat, 48, 48, morningDay, 5.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "Top"));

        newEncounters.add(new Encounter(donphan, 47, 47, allTimes, 20.00,
                EncounterMethod.WALKING, heartGold, mtSilver, "Top"));
        newEncounters.add(new Encounter(ursaring, 47, 47, allTimes, 20.00,
                EncounterMethod.WALKING, soulSilver, mtSilver, "Top"));


        newEncounters.add(new Encounter(golduck, 45, 45, night, 30.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "Top"));
        newEncounters.add(new Encounter(sneasel, 48, 48, night, 20.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "Top"));
        newEncounters.add(new Encounter(misdreavus, 48, 48, night, 15.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "Top"));
        newEncounters.add(new Encounter(quagsire, 45, 45, night, 10.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "Top"));
        newEncounters.add(new Encounter(larvitar, 48, 48, night, 5.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "Top"));
        newEncounters.add(new Encounter(golbat, 15, 20, night, 5.00,
                EncounterMethod.WALKING, allVersions, mtSilver, "Top"));

        newEncounters.add(new Encounter(donphan, 47, 47, night, 20.00,
                EncounterMethod.WALKING, heartGold, mtSilver, "Top"));
        newEncounters.add(new Encounter(ursaring, 47, 47, night, 20.00,
                EncounterMethod.WALKING, soulSilver, mtSilver, "Top"));





        newEncounters.add(new Encounter(seaking, 30, 45, allTimes, 90.00,
                EncounterMethod.SURFING, allVersions, mtSilver, "1F"));
        newEncounters.add(new Encounter(goldeen, 30, 40, allTimes, 10.00,
                EncounterMethod.SURFING, allVersions, mtSilver, "1F"));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes, 95.00,
                EncounterMethod.OLD_ROD, allVersions, mtSilver, "1F"));
        newEncounters.add(new Encounter(goldeen, 10, 10, allTimes, 5.00,
                EncounterMethod.OLD_ROD, allVersions, mtSilver, "1F"));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes, 60.00,
                EncounterMethod.GOOD_ROD, allVersions, mtSilver, "1F"));
        newEncounters.add(new Encounter(goldeen, 20, 20, allTimes, 40.00,
                EncounterMethod.GOOD_ROD, allVersions, mtSilver, "1F"));

        newEncounters.add(new Encounter(goldeen, 40, 40, allTimes, 90.00,
                EncounterMethod.SUPER_ROD, allVersions, mtSilver, "1F"));
        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes, 7.00,
                EncounterMethod.SUPER_ROD, allVersions, mtSilver, "1F"));
        newEncounters.add(new Encounter(seaking, 40, 40, allTimes, 3.00,
                EncounterMethod.SUPER_ROD, allVersions, mtSilver, "1F"));


        newEncounters.add(new Encounter(seaking, 30, 45, allTimes, 90.00,
                EncounterMethod.SURFING, allVersions, mtSilver, "1F Top"));
        newEncounters.add(new Encounter(goldeen, 30, 40, allTimes, 10.00,
                EncounterMethod.SURFING, allVersions, mtSilver, "1F Top"));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes, 95.00,
                EncounterMethod.OLD_ROD, allVersions, mtSilver, "1F Top"));
        newEncounters.add(new Encounter(goldeen, 10, 10, allTimes, 5.00,
                EncounterMethod.OLD_ROD, allVersions, mtSilver, "1F Top"));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes, 60.00,
                EncounterMethod.GOOD_ROD, allVersions, mtSilver, "1F Top"));
        newEncounters.add(new Encounter(goldeen, 20, 20, allTimes, 40.00,
                EncounterMethod.GOOD_ROD, allVersions, mtSilver, "1F Top"));

        newEncounters.add(new Encounter(goldeen, 40, 40, allTimes, 90.00,
                EncounterMethod.SUPER_ROD, allVersions, mtSilver, "1F Top"));
        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes, 7.00,
                EncounterMethod.SUPER_ROD, allVersions, mtSilver, "1F Top"));
        newEncounters.add(new Encounter(seaking, 40, 40, allTimes, 3.00,
                EncounterMethod.SUPER_ROD, allVersions, mtSilver, "1F Top"));

        newEncounters.add(new Encounter(seaking, 30, 45, allTimes, 90.00,
                EncounterMethod.SURFING, allVersions, mtSilver, "2F"));
        newEncounters.add(new Encounter(goldeen, 30, 40, allTimes, 10.00,
                EncounterMethod.SURFING, allVersions, mtSilver, "2F"));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes, 95.00,
                EncounterMethod.OLD_ROD, allVersions, mtSilver, "2F"));
        newEncounters.add(new Encounter(goldeen, 10, 10, allTimes, 5.00,
                EncounterMethod.OLD_ROD, allVersions, mtSilver, "2F"));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes, 60.00,
                EncounterMethod.GOOD_ROD, allVersions, mtSilver, "2F"));
        newEncounters.add(new Encounter(goldeen, 20, 20, allTimes, 40.00,
                EncounterMethod.GOOD_ROD, allVersions, mtSilver, "2F"));

        newEncounters.add(new Encounter(goldeen, 40, 40, allTimes, 90.00,
                EncounterMethod.SUPER_ROD, allVersions, mtSilver, "2F"));
        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes, 7.00,
                EncounterMethod.SUPER_ROD, allVersions, mtSilver, "2F"));
        newEncounters.add(new Encounter(seaking, 40, 40, allTimes, 3.00,
                EncounterMethod.SUPER_ROD, allVersions, mtSilver, "2F"));

        newEncounters.add(new Encounter(seaking, 30, 45, allTimes, 90.00,
                EncounterMethod.SURFING, allVersions, mtSilver, "3F"));
        newEncounters.add(new Encounter(goldeen, 30, 40, allTimes, 10.00,
                EncounterMethod.SURFING, allVersions, mtSilver, "3F"));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes, 95.00,
                EncounterMethod.OLD_ROD, allVersions, mtSilver, "3F"));
        newEncounters.add(new Encounter(goldeen, 10, 10, allTimes, 5.00,
                EncounterMethod.OLD_ROD, allVersions, mtSilver, "3F"));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes, 60.00,
                EncounterMethod.GOOD_ROD, allVersions, mtSilver, "3F"));
        newEncounters.add(new Encounter(goldeen, 20, 20, allTimes, 40.00,
                EncounterMethod.GOOD_ROD, allVersions, mtSilver, "3F"));

        newEncounters.add(new Encounter(goldeen, 40, 40, allTimes, 90.00,
                EncounterMethod.SUPER_ROD, allVersions, mtSilver, "3F"));
        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes, 7.00,
                EncounterMethod.SUPER_ROD, allVersions, mtSilver, "3F"));
        newEncounters.add(new Encounter(seaking, 40, 40, allTimes, 3.00,
                EncounterMethod.SUPER_ROD, allVersions, mtSilver, "3F"));


        newEncounters.add(new Encounter(seaking, 30, 45, allTimes, 90.00,
                EncounterMethod.SURFING, allVersions, mtSilver, "4F"));
        newEncounters.add(new Encounter(goldeen, 30, 40, allTimes, 10.00,
                EncounterMethod.SURFING, allVersions, mtSilver, "4F"));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes, 95.00,
                EncounterMethod.OLD_ROD, allVersions, mtSilver, "4F"));
        newEncounters.add(new Encounter(goldeen, 10, 10, allTimes, 5.00,
                EncounterMethod.OLD_ROD, allVersions, mtSilver, "4F"));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes, 60.00,
                EncounterMethod.GOOD_ROD, allVersions, mtSilver, "4F"));
        newEncounters.add(new Encounter(goldeen, 20, 20, allTimes, 40.00,
                EncounterMethod.GOOD_ROD, allVersions, mtSilver, "4F"));

        newEncounters.add(new Encounter(goldeen, 40, 40, allTimes, 90.00,
                EncounterMethod.SUPER_ROD, allVersions, mtSilver, "4F"));
        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes, 7.00,
                EncounterMethod.SUPER_ROD, allVersions, mtSilver, "4F"));
        newEncounters.add(new Encounter(seaking, 40, 40, allTimes, 3.00,
                EncounterMethod.SUPER_ROD, allVersions, mtSilver, "4F"));


        newEncounters.add(new Encounter(seaking, 30, 45, allTimes, 90.00,
                EncounterMethod.SURFING, allVersions, mtSilver, "Top"));
        newEncounters.add(new Encounter(goldeen, 30, 40, allTimes, 10.00,
                EncounterMethod.SURFING, allVersions, mtSilver, "Top"));

        newEncounters.add(new Encounter(magikarp, 10, 10, allTimes, 95.00,
                EncounterMethod.OLD_ROD, allVersions, mtSilver, "Top"));
        newEncounters.add(new Encounter(goldeen, 10, 10, allTimes, 5.00,
                EncounterMethod.OLD_ROD, allVersions, mtSilver, "Top"));

        newEncounters.add(new Encounter(magikarp, 20, 20, allTimes, 60.00,
                EncounterMethod.GOOD_ROD, allVersions, mtSilver, "Top"));
        newEncounters.add(new Encounter(goldeen, 20, 20, allTimes, 40.00,
                EncounterMethod.GOOD_ROD, allVersions, mtSilver, "Top"));

        newEncounters.add(new Encounter(goldeen, 40, 40, allTimes, 90.00,
                EncounterMethod.SUPER_ROD, allVersions, mtSilver, "Top"));
        newEncounters.add(new Encounter(magikarp, 40, 40, allTimes, 7.00,
                EncounterMethod.SUPER_ROD, allVersions, mtSilver, "Top"));
        newEncounters.add(new Encounter(seaking, 40, 40, allTimes, 3.00,
                EncounterMethod.SUPER_ROD, allVersions, mtSilver, "Top"));



        for (Encounter encounter : newEncounters)
            if (!encounterManager.containsEncounter(encounter))
                mtSilver.addEncounter(encounter);

        locationService.saveLocation(mtSilver);
    }

}
