package com.anthony.pokemon.service;

import com.anthony.pokemon.model.Location;
import com.anthony.pokemon.dto.LocationDTO;

import java.util.List;

public interface LocationService {

    Location getLocationByName(String name);
    List<Location> getAllLocations();
    void initializeLocations();
    Location saveLocation(Location location);
    List<LocationDTO> getAllLocationDTOs();
    LocationDTO getLocationDTOByName(String name);

    LocationDTO convertToLocationDTO(Location location);

}
