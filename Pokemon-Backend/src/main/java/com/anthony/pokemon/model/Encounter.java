package com.anthony.pokemon.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Encounter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pokemon_id", nullable = false)
    private Pokemon pokemon;

    @Column(name = "min_level")
    private Integer minLevel;

    @Column(name = "max_level")
    private Integer maxLevel;

    @ElementCollection(targetClass = TimeOfEncounter.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "encounter_times", joinColumns = @JoinColumn(name = "encounter_id"))
    @Column(name = "time_of_encounter")
    @Enumerated(EnumType.STRING)
    private Set<TimeOfEncounter> timeOfEncounter;

    @Column(name = "encounter_rate")
    private Double encounterRate;

    @Column(name = "encounter_method")
    private EncounterMethod encounterMethod;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "encounter_versions", joinColumns = @JoinColumn(name = "encounter_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "version")
    private Set<GameVersion> versions;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    public Encounter(Pokemon pokemon, Integer minLevel,
                     Integer maxLevel, Set<TimeOfEncounter> timeOfEncounter, Double encounterRate,
                     EncounterMethod encounterMethod, Set<GameVersion> versions, Location location) {
        this.pokemon = pokemon;
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
        this.timeOfEncounter = timeOfEncounter;
        this.encounterRate = encounterRate;
        this.encounterMethod = encounterMethod;
        this.versions = versions;
        this.location = location;
    }


}
