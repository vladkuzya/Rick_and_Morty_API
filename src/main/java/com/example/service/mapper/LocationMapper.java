package com.example.service.mapper;

import com.example.dto.LocationDto;
import com.example.model.Location;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {
    public LocationDto mapToDto(Location location) {
        LocationDto dto = new LocationDto();
        dto.setId(location.getId());
        dto.setName(location.getName());
        dto.setType(location.getName());
        dto.setDimension(location.getDimension());
        dto.setUrl(location.getUrl());
        dto.setCreated(location.getCreated());
        return dto;
    }
    public Location mapToEntity(LocationDto dto) {
        Location location = new Location();
        location.setId(dto.getId());
        location.setName(dto.getName());
        location.setType(dto.getType());
        location.setDimension(dto.getDimension());
        location.setUrl(dto.getUrl());
        location.setCreated(dto.getCreated());
        return location;
    }
}
