package org.example.service;

import org.example.entity.Planet;

public interface PlanetCrudService {
    void create(String id, String name);

    Planet getById(String id);

    void update(String id, String name);

    void delete(String id);
}
