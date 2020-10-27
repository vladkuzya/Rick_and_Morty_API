package com.example.service.impl;

import com.example.dao.LocationDao;
import com.example.model.Location;
import com.example.service.LocationService;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationDao locationDao;

    public LocationServiceImpl(LocationDao locationDao) {
        this.locationDao = locationDao;
    }

    @Override
    public Location add(Location location) {
        return locationDao.add(location);
    }

    @Override
    public Location getById(Long id) {
        return locationDao.getById(id);
    }
}
