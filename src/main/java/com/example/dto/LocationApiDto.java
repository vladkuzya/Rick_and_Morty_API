package com.example.dto;

import lombok.Data;

import java.util.List;

@Data
public class LocationApiDto {
    private InfoLocationApiDto info;
    private List<LocationDto> results;
}
