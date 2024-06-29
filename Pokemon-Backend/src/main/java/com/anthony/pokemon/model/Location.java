package com.anthony.pokemon.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Encounter> encounters = new ArrayList<>();

    /* Only populate name of location first */
    public Location(String name) {
        this.name = name;
    }

    public void addEncounter(Encounter encounter) {
        if (encounters.stream().noneMatch(e -> e.equals(encounter))) {
            encounters.add(encounter);
            encounter.setLocation(this);
        }
    }


    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }



}