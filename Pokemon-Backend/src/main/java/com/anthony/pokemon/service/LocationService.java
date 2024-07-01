package com.anthony.pokemon.service;

import com.anthony.pokemon.model.EncounterMethod;
import com.anthony.pokemon.model.GameVersion;
import com.anthony.pokemon.model.Location;
import com.anthony.pokemon.dto.LocationDTO;
import com.anthony.pokemon.model.TimeOfEncounter;

import java.util.List;
import java.util.Set;

public interface LocationService {

    Location getLocationByName(String name);
    List<Location> getAllLocations();
    void initializeLocations();
    Location saveLocation(Location location);
    List<LocationDTO> getAllLocationDTOs();
    LocationDTO getLocationDTOByName(String name);
    List<LocationDTO> getEncountersByMethodAndTimeAndVersion(Long locationId,
                                                     EncounterMethod encounterMethod,
                                                     Set<TimeOfEncounter> timeOfEncounters);

    LocationDTO convertToLocationDTO(Location location);

}
