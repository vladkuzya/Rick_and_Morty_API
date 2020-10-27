package com.example.service.impl;

import com.example.dao.PersonageDao;
import com.example.model.Personage;
import com.example.service.PersonageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PersonageServiceImpl implements PersonageService {
    private static final int FIRST_ID = 1;
    private static final int LAST_ID = 761;
    private final PersonageDao personageDao;

    public PersonageServiceImpl(PersonageDao personageDao) {
        this.personageDao = personageDao;
    }

    @Override
    public Personage add(Personage personage) {
        return personageDao.add(personage);
    }

    @Override
    public Personage getById(Long id) {
        return personageDao.getById(id);
    }

    @Override
    public Personage getRandomPersonage() {
        Random random = new Random();
        long l = FIRST_ID + random.nextInt(LAST_ID);
        return personageDao.getById(l);
    }

    @Override
    public List<Personage> findByName(String name) {
        return personageDao.findByName(name);
    }
}
