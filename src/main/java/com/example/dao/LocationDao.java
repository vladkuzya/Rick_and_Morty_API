package com.example.dao;

import com.example.model.Location;
import java.util.List;

public interface LocationDao {
    Location add(Location location);

    Location getById(Long id);

    void addAll(List<Location> locations);
}
