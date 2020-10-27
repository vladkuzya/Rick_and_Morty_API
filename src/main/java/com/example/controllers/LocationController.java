package com.example.controllers;

import com.example.dto.PersonageApiDto;
import com.example.dto.PersonageDto;
import com.example.model.Personage;
import com.example.service.DataService;
import com.example.service.PersonageService;
import com.example.service.mapper.PersonageMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class LocationController {
    private final DataService dataService;
    private final PersonageService personageService;
    private final PersonageMapper personageMapper;

    public LocationController(DataService dataService, PersonageService personageService,
                              PersonageMapper personageMapper) {
        this.dataService = dataService;
        this.personageService = personageService;
        this.personageMapper = personageMapper;
    }

    @GetMapping("/insert")
    public void insertAll() {
        PersonageApiDto data = dataService.getData("https://rickandmortyapi.com/api/character",
                PersonageApiDto.class);
        for (int i = 1; i < data.getInfo().getCount() - 1; i++) {
            List<PersonageDto> results = data.getResults();
            for (PersonageDto dto : results) {
                personageService.add(personageMapper.mapToEntity(dto));
            }
            data = dataService.getData(data.getInfo().getNext(), PersonageApiDto.class);
        }
    }

    @GetMapping("/random")
    public PersonageDto getRandom() {
        return personageMapper.mapToDto(personageService.getRandomPersonage());
    }

    @GetMapping("/search")
    public List<PersonageDto> findPersonagesByNameContains(
            @RequestParam String name) {
        return personageService.findByName(name).stream()
                                    .map(personageMapper::mapToDto)
                                    .collect(Collectors.toList());
    }
}
