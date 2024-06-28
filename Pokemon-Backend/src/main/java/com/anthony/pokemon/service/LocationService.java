package com.anthony.pokemon.service;

import com.anthony.pokemon.model.Location;
import com.anthony.pokemon.repository.LocationRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location getLocationByName(String name) {
        return locationRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("No location found with name: " + name));
    }

    public void initializeLocations() {
        List<Location> locations = Arrays.asList(
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
                new Location("Safari Zone")
        );
        locationRepository.saveAll(locations);
    }

    @Transactional
    public void deleteAllLocations() {
        locationRepository.deleteAll();
    }

}
