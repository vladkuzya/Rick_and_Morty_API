package com.example.service;

import com.example.model.Location;

public interface LocationService {
    Location add(Location location);

    Location getById(Long id);
}
