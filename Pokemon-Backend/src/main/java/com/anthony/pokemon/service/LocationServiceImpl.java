package com.anthony.pokemon.service;

import com.anthony.pokemon.dto.EncounterDTO;
import com.anthony.pokemon.dto.LocationDTO;
import com.anthony.pokemon.exception.LocationNotFoundException;
import com.anthony.pokemon.exception.PokemonNotFoundException;
import com.anthony.pokemon.model.*;
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
    public List<LocationDTO> getEncountersByMethodAndVersion(Long locationId,
                                                             Set<EncounterMethod> encounterMethods,
                                                             GameVersion requestedVersion,
                                                             TimeOfEncounter requestedTime) {

        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new LocationNotFoundException("Location with id, " + locationId + " not found."));

        List<EncounterDTO> filteredEncounters = new ArrayList<>();
        for (Encounter encounter : location.getEncounters()) {
            boolean matchesMethod = (encounterMethods == null || encounterMethods.isEmpty() || encounterMethods.contains(encounter.getEncounterMethod()));
            boolean matchesVersion = (requestedVersion == null || encounter.getVersions().contains(requestedVersion));
            boolean matchesTime = (requestedTime == null || encounter.getTimeOfEncounter().contains(requestedTime));

            if (matchesMethod && matchesVersion && matchesTime) {
                filteredEncounters.add(convertToEncounterDTO(encounter));
            }
        }

        LocationDTO locationDTO = new LocationDTO(location.getId(), location.getName(), filteredEncounters, location.getDescription());
        return Collections.singletonList(locationDTO);
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
                new Location("New Bark Town", "A town where the wind blows and tells of impending change. New Bark Town is located in southeastern Johto and is the hometown of the Johto player character."),
                new Location("Route 29", "Route 29 is in a mountainous region of Johto, which means that the Headbutt-able trees that line the route hold Pokémon often found in the mountains, namely Spearow and Aipom."),
                new Location("Cherrygrove City", "A city where you can smell small flowers and a sea breeze. . The city acts mainly as a tutorial, introducing the player to the main tools of the game"),
                new Location("Route 30", "Route 30 is the second route encountered by Trainers in Johto. From its southern terminus at Cherrygrove, the route turns northeast to avoid a ledge on the route that overlooks a patch of grass. Heading south, this ledge can be used to avoid the grass altogether."),
                new Location("Route 31", "This route is the third route that Trainers starting in New Bark Town will arrive at. Like the route before it, Route 31 contains more than an even share of ledges that players need to go around to get to Violet City, but may jump over on their way back."),
                new Location("Violet City", "This old village is still surrounded by trees and other scenery. Violet City is located in central Johto. It is the third city encountered in Johto by the player. Pokémon Trainers often come to Violet City in order to win the Zephyr Badge from Falkner, the Violet Gym Leader, who specializes in Flying-type Pokémon."),
                new Location("Sprout Tower", "Sprout Tower is a three-tiered tower with multiple eaves. Like the Bell Tower and the Burned Tower, it is constructed solely out of wood, creating a multi-story effect."),
                new Location("Route 32", "The fourth route that Trainers from New Bark Town encounter, Route 32 is the first in Johto to see the player's destination to the south – and a far-off one at that. After exiting Violet City through a small path with a Yellow Apricorn in a clearing, the player comes to a three-way intersection."),
                new Location("Ruins of Alph", "The Ruins of Alph are located in Johto near Violet City, with entrances to the south of Route 36 and west of Route 32. The ruins are filled with Unown once any of the four slide puzzles inside the chambers have been activated."),
                new Location("Union Cave", "Union Cave is a cave located in the Johto region. The main cave divides Route 32 from Route 33, though two other exits in the basement levels of the cave lead to the Ruins of Alph"),
                new Location("Route 33", "The fifth route that Trainers from New Bark Town encounter, Route 33 is a short route that travels west to Azalea Town where it is always raining. This rain does persist into each battle."),
                new Location("Azalea Town", "The town is best known for being the residence of Kurt, a custom Poké Ball creator who makes Poké Balls out of Apricorns. He lives in the northwest portion of town on the east edge of Ilex Forest."),
                new Location("Slowpoke Well", "The Slowpoke Well is a man-made cave located at the edge of Azalea Town. It is located just north-west of Route 33, first seen on the way to Azalea Town. The cave is home to a wide variety of wild Pokémon, but is unique for being the home of Azalea Town's Slowpoke, which they use as pets. "),
                new Location("Ilex Forest", "Ilex Forest is a dense forest located in Johto, to the west of Azalea Town and to the south of Goldenrod City. When the player first visits Ilex Forest, they can find a man who is looking for his Farfetch'd."),
                new Location("Route 34", "The route is essentially straightforward after exiting Ilex Forest. There is a path where no long grass grows; however, it is filled with many Trainers. The Day Care, run by an old couple, is one of the most prominent things located here."),
                new Location("Goldenrod City", "Goldenrod City is the largest city in the region, and one of the largest cities in the Pokémon world. Goldenrod is the center of the region's economy and telecommunications. Major attractions for Trainers include the Goldenrod Radio Tower, the city's Goldenrod Department Store, Game Corner, Name Rater, Magnet Train, Global Terminal and Gym."),
                new Location("National Park", "The National Park is a location in Johto. It is located to the north of Goldenrod City, between Route 35 and Route 36."),
                new Location("Route 35", "The route is a relatively short route, leading the player in an S-like curve, around a small body of water, and north to the southern entrance to the National Park. At the gate leading from Goldenrod, a guard named Webster will give the player a Spearow with Mail attached to deliver to his friend."),
                new Location("Route 36", "Route 36 is a route in central Johto connecting Route 37, Violet City, and National Park. The northern entrance to the Ruins of Alph is located at eastern end of the route. The route also contains a shortcut to Route 35."),
                new Location("Route 37", "Route 37 begins not too far north of where Sudowoodo was found on Route 36. On its western half, there is a bi-directional path which Trainers can take both to and from Ecruteak City. This road makes its way north from Route 36 and loops around a small tree, which a pair of Twins are training together. From there, a large gap in a wide ledge, which allows the path to continue north past a large patch of tall grass, several more Trainers, and a signpost, until they reach Ecruteak City."),
                new Location("Ecruteak City", "As with many of the larger cities in the Pokémon world, Ecruteak has a Ecruteak Gym, led by Morty, who specializes in Ghost-type Pokémon and hands out the Fog Badge to those who defeat him. Ecruteak is known as a historical and mythical city;"),
                new Location("Burned Tower", "The Burned Tower is a location within Ecruteak City formerly as tall as the Bell Tower to the east. It burned down due to a lightning strike 150 years prior."),
                new Location("Bell Tower", "The Bell Tower is located in the northeast of Ecruteak City. Ho-Oh formerly perched at the top of this ten-story tower, but flew away after the other tower in the west of Ecruteak City burned down mysteriously. The Bell Tower is an icon of Ecruteak City and a place of high sanctity among people in Johto, with only select people being qualified to enter it."),
                new Location("Route 38", "Even though Route 38 maintains a pure east-west alignment as a whole, there are no fewer than four separate paths that Trainers can take between Ecruteak and Route 39. The northern-most path leads Trainers into the path of three other Trainers, two of which offer to give out their phone number for rematches at a later date. Over half of this path is made up of grass patches."),
                new Location("Route 39", "Route 39 is almost perfectly straight and has no major obstacles. There is only one patch of grass that contains wild Pokémon, and this area is located off the beaten path. Along Route 39, there are four Trainers: one near the entrance to Moomoo Farm and three near the southern end of the route."),
                new Location("Olivine City", "Olivine is a major port city and is the home of the Glitter Lighthouse. The Glitter Lighthouse guides ships to the harbor as well as the S.S. Aqua connecting it to the port city in its sister region, Vermilion City in Kanto. Pokémon Trainers often come to Olivine City in order to win the Mineral Badge from Jasmine, the Olivine Gym Leader who specializes in Steel-type Pokémon."),
                new Location("Route 40", "This route consists of a small amount of land that is dwarfed in proportion by the surrounding ocean. All that a Trainer must do is head south, towards the Whirl Islands, defeating a few Trainers along the way. The Pokémon selection in this route is equally bland, comprising only of the most commonly appearing sea route Pokémon: Tentacool and Tentacruel. Some of trainer in this route can be bugged in a way that you'll fight them with level 100 pokémons. Please report this at the forums"),
                new Location("Route 41", "Route 41 consists of the Whirl Islands and their surrounding area. The entrances to the four islands are inaccessible due to whirlpools until the Trainer has the HM - Whirlpool to traverse them. Three of the four islands yield valuable Pokémon and items, but if the player has the Silver Wing in their Bag, Lugia can be found through the northeast portal. This route is also home to Mantine."),
                new Location("Cianwood City", "Cianwood City is located on the far western edge of Johto, apparently on a totally different landmass than the rest of the region. Cianwood City is a notable destination due to the Safari Zone located to the west of the city. Tales of Lugia and the whirlpools it creates circulate among the sailors that stop in this port town."),
                new Location("Route 42", "Upon leaving from either the western or eastern terminus, a Trainer must have a Pokémon with Surf to continue, as the route is divided twice over by small lakes. Alternatively, they can pass through Mt. Mortar to the north. On the small landmass between the two, there is a tree that is able to be Cut, leading to a trio of Apricorn trees, much like those on Route 37."),
                new Location("Mt. Mortar", "Mt. Mortar is a large cave in Johto with three entrances on Route 42. Part of the large range of mountains in the north of Johto, it is known to be a confusing maze-like area with an interior cave known as the Waterfall Cave."),
                new Location("Mahogany Town", "Mahogany Town is a small town in northern Johto where ninjas once resided in what eventually became the Team Rocket HQ. There are three exits out of town. To the west is Route 42, to the east is Route 44, and to the north is Route 43, which leads directly to the famous Lake of Rage"),
                new Location("Route 43", "Route 43 has two paths to travel on. One of these paths, while more convenient (as there is no long grass on it), will cost $1000 if a Trainer travels on it before vanquishing Team Rocket. The other path, however, features many Trainers and a lot of long grass to pass through in order to reach the lake."),
                new Location("Lake of Rage", "The Lake of Rage is located just north of Mahogany Town, through Route 43, it is the northern-most accessible point of the Johto region. The Layout changes once it rains. It is also known as Gyarados Lake for it's shiny inhabitant."),
                new Location("Route 44", "Route 44 is a route in northern Johto, connecting the Ice Path to Mahogany Town. It is forked around a pair of calm ponds. Trainers gather on either side of the ponds, and provide a challenge before the chilling Ice Path. Battling wild Pokémon is entirely optional, as the only patch of straight grass is surrounded by a pair of calm ponds."),
                new Location("Ice Path", "The Ice Path is a four-floored cave located in Johto that connects Route 44 with Blackthorn City. The Ice Path has numerous ice puzzles, which vary in size and difficulty, such as a HM - Strength puzzle involving pushing boulders into holes in order to progress."),
                new Location("Blackthorn City", "Pokémon Trainers often come to Blackthorn City in order to win the Rising Badge from Clair, the Blackthorn Gym Leader, who specializes in Dragon-type Pokémon. Many famous Dragon-type Trainers, including Clair and Lance, come from Blackthorn City."),
                new Location("Route 45", "Route 45 is a route in eastern Johto, connecting Blackthorn City and Route 46. It is also known as Mountain Road. The route can only be entered from the northern terminus, as the steep ledges that one can jump over make traveling northward towards Blackthorn City impossible. One of the entrances to Dark Cave lies at its northern edge."),
                new Location("Route 46", "Early in the region, players can only access the southern part of the route, below the ledges that can be jumped over. The northern part of the route can be accessed via Dark Cave, or the one-way Route 45 south of Blackthorn City. At least three Badges are required for access via Dark Cave; Strength is required to clear the path through the cave."),
                new Location("Route 47", "Only accessible after the SecretPotion has been given to Jasmine in the Glitter Lighthouse, Route 47 is vastly different from all other routes in Johto, being carved out of the face of the sheer cliffs west of Cianwood. The route begins rather high up as Trainers exit from Cliff Edge Gate, and heads due west past a Hiker, where it takes its first branch."),
                new Location("Route 48", "Route 48 begins on the east side of the river that runs over the west waterfall on Route 47. Almost immediately, it crosses over the river by way of a bridge, toward long grass. Various Pokémon can be found in the grass. North of the grass, another bridge crosses the river again, and the route ends at the Safari Zone Gate."),
                new Location("Safari Zone", "The Safari Zone is a wildlife preserve located to the north of Route 48, which is accessed through the Safari Zone Gate from Cianwood City via Route 48. Pokémon Trainers often come here in order to catch Pokémon."),
                new Location("Whirl Islands", "The Whirl Islands are a small archipelago located between the mainland of Johto and Cianwood City, on Route 41. Beneath the sea, a maze of dark caves sprawl, with explorers able to travel between the four islands with some amount of difficulty."),
                new Location("Dragon's Den", "The Dragon's Den is inaccessible before defeating Clair in the Blackthorn Gym, as it is blocked off by a man in front of the cave. After defeating Clair, it must be traversed to obtain the Rising Badge."),
                new Location("Dark cave Route 31", "Dark Cave is a single-level cave located in eastern Johto. It is not necessary to enter the cave to complete the storyline. As its name implies, HM - Flash is required to illuminate the cave. The cave is unique in that the cave is separated into two parts, yet the cave does not change floors between the two areas."),
                new Location("Dark cave Route 45", "Dark Cave is a single-level cave located in eastern Johto. It is not necessary to enter the cave to complete the storyline. As its name implies, HM - Flash is required to illuminate the cave. The cave is unique in that the cave is separated into two parts, yet the cave does not change floors between the two areas."),
                new Location("Sinjoh Ruins", "As revealed by Cynthia and a Hiker in the cabin, the Sinjoh Ruins are the remains of a temple created hundreds of years ago by two groups of humans: one who had come from Sinnoh, and another who had hailed from Johto, or specifically the Ruins of Alph. Because of this, the ruins contain elements of both the Spear Pillar and the Ruins of Alph, as a sign of the blending of the two cultures. It is unknown what brought the two clans together to build a temple for Arceus, but this probably has to do with the underlying relationship between it and the Unown."),
                new Location("Cliff Cave", "Cliff Cave is a cave on Johto's Route 47. There are three floors. The lower floor contains breakable rocks. However, they do not appear until the player has acquired the National Pokédex. Inside Cliff Cave, the player can either go up or down; each path contains its own perks. Going down and out from Cliff Cave leads the player to the sea.")
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

        return new LocationDTO(location.getId(), location.getName() , encounterDTOs, location.getDescription());
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

    private EncounterDTO convertToEncounterDTO(Encounter encounter) {
        if (encounter == null) {
            throw new PokemonNotFoundException("Encounter not found");
        }
        EncounterDTO dto = new EncounterDTO();
        dto.setId(encounter.getId());
        dto.setPokemonName(encounter.getPokemon().getName());
        dto.setMinLevel(encounter.getMinLevel());
        dto.setMaxLevel(encounter.getMaxLevel());
        dto.setTimeOfEncounter(encounter.getTimeOfEncounter());
        dto.setEncounterRate(encounter.getEncounterRate());
        dto.setEncounterMethod(encounter.getEncounterMethod());
        dto.setVersions(encounter.getVersions());
        dto.setSubLevel(encounter.getSubLevel());
        return dto;
    }

}