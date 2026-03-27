package org.example.service;

import org.example.entity.Ticket;
import org.example.dao.TicketDaoService;

import java.util.List;

public class TicketCrudServiceImpl implements TicketCrudService{

    private final TicketDaoService dao;

    public TicketCrudServiceImpl(TicketDaoService dao) {
        this.dao = dao;
    }

    @Override
    public long create(Ticket ticket) {
        if (ticket.getClient() == null) {
            throw new IllegalArgumentException("Ticket must have a non-null client!");
        }

        // Перевірка на null планет
        if (ticket.getFromPlanet() == null || ticket.getToPlanet() == null) {
            throw new IllegalArgumentException("Ticket must have non-null from and to planets!");
        }

        // Виклик DAO для збереження
        return dao.create(ticket);
    }

    @Override
    public List<Ticket> getAll() {
        return dao.getAll();
    }

    @Override
    public Ticket getById(Long id) {
        return dao.getById(id);
    }

    @Override
    public void update(Ticket ticket) {
        if (ticket.getClient() == null) {
            throw new IllegalArgumentException("Ticket update requires a non-null client!");
        }
        if (ticket.getFromPlanet() == null || ticket.getToPlanet() == null) {
            throw new IllegalArgumentException("Ticket update requires non-null from and to planets!");
        }

        dao.update(ticket);
    }

    @Override
    public void delete(long id) {
        dao.delete(id);
    }
}
