package com.anthony.pokemon.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
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

    @Column(name = "subLevel", nullable = true)
    private String subLevel;

    /* Constructor without subLevel */
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
        this.subLevel = null;
    }

    /* Constructor with subLevel */
    public Encounter(Pokemon pokemon, Integer minLevel,
                     Integer maxLevel, Set<TimeOfEncounter> timeOfEncounter, Double encounterRate,
                     EncounterMethod encounterMethod, Set<GameVersion> versions, Location location, String subLevel) {
        this.pokemon = pokemon;
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
        this.timeOfEncounter = timeOfEncounter;
        this.encounterRate = encounterRate;
        this.encounterMethod = encounterMethod;
        this.versions = versions;
        this.location = location;
        this.subLevel = subLevel;
    }


    @Override
    public String toString() {
        return "Encounter{" +
                "id=" + id +
                ", locationId=" + (location != null ? location.getId() : "none") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Encounter that)) return false;
        return Objects.equals(id, that.id) &&
                Objects.equals(pokemon, that.pokemon) &&
                Objects.equals(minLevel, that.minLevel) &&
                Objects.equals(maxLevel, that.maxLevel) &&
                Objects.equals(timeOfEncounter, that.timeOfEncounter) &&
                Objects.equals(encounterRate, that.encounterRate) &&
                encounterMethod == that.encounterMethod &&
                Objects.equals(versions, that.versions) &&
                Objects.equals(location, that.location) &&
                Objects.equals(subLevel, that.subLevel);
    }


    @Override
    public int hashCode() {
        return Objects.hash(pokemon, minLevel, maxLevel, timeOfEncounter, encounterRate, encounterMethod, versions, location, subLevel);
    }

}
