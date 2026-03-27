package org.example.dao;

import org.example.entity.Planet;

public interface PlanetDaoService {
    void create(String id, String name);

    Planet getById(String id);

    void update(String id, String name);

    void delete(String id);
}
