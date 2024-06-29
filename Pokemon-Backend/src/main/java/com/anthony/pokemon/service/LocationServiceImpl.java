package com.anthony.pokemon.service;

import com.anthony.pokemon.dto.EncounterDTO;
import com.anthony.pokemon.dto.LocationDTO;
import com.anthony.pokemon.exception.LocationNotFoundException;
import com.anthony.pokemon.model.Encounter;
import com.anthony.pokemon.model.Location;
import com.anthony.pokemon.repository.LocationRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location getLocationByName(String name) {
        return locationRepository.findByName(name).orElseThrow(() -> new LocationNotFoundException("Location not found " + name));
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Transactional
    public void initializeLocations() {

        List<Location> existingLocations = new ArrayList<>(locationRepository.findAll());
        Set<String> set = new HashSet<>();
        for (Location location : existingLocations)
            set.add(location.getName());


        List<Location> newLocations = Arrays.asList(
                new Location("New Bark Town"),
                new Location("Route 29"),
                new Location("Cherrygrove City"),
                new Location("Route 30"),
                new Location("Route 31"),
                new Location("Violet City"),
                new Location("Sprout Tower"),
                new Location("Route 32"),
                new Location("Ruins of Alph"),
                new Location("Union Cave"),
                new Location("Route 33"),
                new Location("Azalea Town"),
                new Location("Slowpoke Well"),
                new Location("Ilex Forest"),
                new Location("Route 34"),
                new Location("Goldenrod City"),
                new Location("National Park"),
                new Location("Route 35"),
                new Location("Route 36"),
                new Location("Route 37"),
                new Location("Ecruteak City"),
                new Location("Burned Tower"),
                new Location("Bell Tower"),
                new Location("Route 38"),
                new Location("Route 39"),
                new Location("Olivine City"),
                new Location("Route 40"),
                new Location("Route 41"),
                new Location("Cianwood City"),
                new Location("Route 42"),
                new Location("Mt. Mortar"),
                new Location("Mahogany Town"),
                new Location("Route 43"),
                new Location("Lake of Rage"),
                new Location("Route 44"),
                new Location("Ice Path"),
                new Location("Blackthorn City"),
                new Location("Route 45"),
                new Location("Route 46"),
                new Location("Route 47"),
                new Location("Route 48"),
                new Location("Safari Zone"),
                new Location("Whirl Islands"),
                new Location("Dragon's Den"),
                new Location("Dark cave Route 31"),
                new Location("Dark cave Route 45"),
                new Location("Sinjoh Ruins"),
                new Location("Cliff Cave")
        );

        for (Location newLocation: newLocations)
            if (!set.contains(newLocation.getName()))
                existingLocations.add(newLocation);

        locationRepository.saveAll(existingLocations);
    }

    @Override
    @Transactional
    public Location saveLocation(Location location) {
        locationRepository.save(location);
        return location;
    }

    @Override
    @Transactional
    public LocationDTO convertToLocationDTO(Location location) {

        List<EncounterDTO> encounterDTOs = new ArrayList<>();

        if (location != null) {
            for (Encounter encounter : location.getEncounters()) {
                EncounterDTO dto = new EncounterDTO();
                dto.setId(encounter.getId());
                dto.setPokemonName(encounter.getPokemon().getName());
                dto.setMinLevel(encounter.getMinLevel());
                dto.setMaxLevel(encounter.getMaxLevel());
                dto.setTimeOfEncounter(encounter.getTimeOfEncounter());
                dto.setEncounterRate(encounter.getEncounterRate());
                dto.setEncounterMethod(encounter.getEncounterMethod());
                dto.setVersions(encounter.getVersions());
                encounterDTOs.add(dto);
            }
        }

        return new LocationDTO(location.getId(), location.getName(), encounterDTOs);
    }

    public List<LocationDTO> getAllLocationDTOs() {

        List<Location> locations = locationRepository.findAll();
        List<LocationDTO> locationDTOS = new ArrayList<>();

        for (Location location : locations)
            locationDTOS.add(convertToLocationDTO(location));

        return locationDTOS;
    }

    public LocationDTO getLocationDTOByName(String name) {
        Location location = locationRepository.findByName(name)
                .orElseThrow(() -> new LocationNotFoundException("Location not found with name: " + name));
        return convertToLocationDTO(location);
    }

}