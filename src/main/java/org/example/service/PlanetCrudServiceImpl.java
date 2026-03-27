package org.example.service;

import org.example.entity.Planet;
import org.example.dao.PlanetDaoService;

public class PlanetCrudServiceImpl implements PlanetCrudService{

    private final PlanetDaoService dao;

    public PlanetCrudServiceImpl(PlanetDaoService dao) {
        this.dao = dao;
    }

    @Override
    public void create(String id, String name) {
        if (id == null || id.isBlank() || name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid planet data");
        }
        dao.create(id, name);
    }

    @Override
    public Planet getById(String id) {
        return dao.getById(id);
    }

    @Override
    public void update(String id, String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid planet name");
        }
        dao.update(id, name);
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }
}
