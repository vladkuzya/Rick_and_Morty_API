package com.example.service;

import com.example.model.Location;
import com.example.model.Personage;

import java.util.List;

public interface PersonageService {
    Personage add(Personage location);

    Personage getById(Long id);

    Personage getRandomPersonage();

    List<Personage> findByName(String name);
}
