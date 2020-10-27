package com.example.service.mapper;

import com.example.dto.LocationDto;
import com.example.dto.PersonageDto;
import com.example.model.Location;
import com.example.model.Personage;
import com.example.service.DataService;
import com.example.service.LocationService;
import org.springframework.stereotype.Component;

@Component
public class PersonageMapper {
    private final DataService dataService;
    private final LocationService locationService;
    private final LocationMapper locationMapper;


    public PersonageMapper(DataService dataService, LocationService locationService, LocationMapper locationMapper) {
        this.dataService = dataService;
        this.locationService = locationService;
        this.locationMapper = locationMapper;
    }

    public PersonageDto mapToDto(Personage personage) {
        PersonageDto dto = new PersonageDto();
        dto.setId(personage.getId());
        dto.setName(personage.getName());
        dto.setStatus(personage.getStatus());
        dto.setSpecies(personage.getSpecies());
        dto.setType(personage.getType());
        dto.setGender(personage.getGender());
        dto.setOrigin(locationMapper.mapToDto(personage.getOrigin()));
        dto.setLocation(locationMapper.mapToDto(personage.getLocation()));
        dto.setImage(personage.getImage());
        dto.setEpisode(personage.getEpisode());
        dto.setUrl(personage.getUrl());
        dto.setCreated(personage.getCreated());
        return dto;
    }

    public Personage mapToEntity(PersonageDto dto) {
        Personage personage = new Personage();
        personage.setId(dto.getId());
        personage.setName(dto.getName());
        personage.setStatus(dto.getStatus());
        personage.setSpecies(dto.getSpecies());
        personage.setType(dto.getType());
        personage.setGender(dto.getGender());
        personage.setOrigin(getLocation(dto.getOrigin().getUrl()));
        personage.setLocation(getLocation(dto.getLocation().getUrl()));
        personage.setImage(dto.getImage());
        personage.setEpisode(dto.getEpisode());
        personage.setUrl(dto.getUrl());
        personage.setCreated(dto.getCreated());
        return personage;
    }

    private Location getLocation(String url) {
        Location location = new Location();
        if (!url.equals("")) {
            Long id = Long.parseLong(url.replaceAll("\\D+", ""));
            location = locationService.getById(id);
        } else {
            location.setId(0l);
            location.setName("unknown");
            if (locationService.getById(0l) == null) {
                locationService.add(location);
            }
        }
        if (location == null) {
            location = locationMapper.mapToEntity(dataService.getData(url,
                    LocationDto.class));
            locationService.add(location);
        }
        return location;
    }
}
