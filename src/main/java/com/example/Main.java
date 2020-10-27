package com.example;

import com.example.config.AppConfig;
import com.example.controllers.LocationController;
import com.example.dto.PersonageApiDto;
import com.example.dto.PersonageDto;
import com.example.model.Location;
import com.example.model.Personage;
import com.example.service.DataService;
import com.example.service.LocationService;
import com.example.service.PersonageService;
import com.example.service.mapper.PersonageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    private static final AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);
    private static final PersonageService personageService =
            context.getBean(PersonageService.class);
    private static final LocationService locationService =
            context.getBean(LocationService.class);

    @Autowired
    private static DataService dataService;
    @Autowired
    private static PersonageMapper personageMapper;



    public static void main(String[] args) {
        PersonageApiDto data = dataService.getData("https://rickandmortyapi.com/api/character",
                PersonageApiDto.class);
        List<PersonageDto> results = data.getResults();
        for (PersonageDto dto : results) {
            personageService.add(personageMapper.mapToEntity(dto));
        }
    }
}
