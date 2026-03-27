package org.example.service;

import org.example.entity.Ticket;

import java.util.List;

public interface TicketCrudService {
    long create(Ticket ticket);

    List<Ticket> getAll();

    Ticket getById(Long id);

    void update(Ticket ticket);

    void delete(long id);
}
