package org.example.dao;

import org.example.Entity.Client;

public interface ClientDaoService {

    Long create(String name);

    Client getById(Long id);

    void update(String name, Long id);

    void delete(Long id);
}
