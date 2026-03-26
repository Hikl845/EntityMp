package org.example.service;

import org.example.Entity.Client;
import org.example.dao.ClientDaoService;

public class ClientServiceImpl implements ClientService{

    private final ClientDaoService dao;

    public ClientServiceImpl(ClientDaoService dao) {
        this.dao = dao;
    }

    @Override
    public Long create(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid client name");
        }
        return dao.create(name);
    }

    @Override
    public Client getById(Long id) {
        return dao.getById(id);
    }

    @Override
    public void update(String name, Long id) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid client name");
        }
        dao.update(name, id);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
}
