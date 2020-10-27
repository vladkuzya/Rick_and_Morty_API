package com.example.dao;

import com.example.model.Location;
import com.example.model.Personage;

import java.util.List;

public interface PersonageDao {
    Personage add(Personage location);

    Personage getById(Long id);

    List<Personage> findByName(String name);
}
