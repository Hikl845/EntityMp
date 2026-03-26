package org.example.dao;

import org.example.Entity.Client;
import org.example.Entity.Planet;
import org.example.Entity.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class TicketDaoServiceImpl implements TicketDaoService {

    private final SessionFactory sessionFactory;

    public TicketDaoServiceImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long create(Ticket ticket) throws IllegalArgumentException {
        // Перевірки на null
        if (ticket.getClient() == null) {
            throw new IllegalArgumentException("Ticket must have a non-null client!");
        }
        if (ticket.getFromPlanet() == null || ticket.getToPlanet() == null) {
            throw new IllegalArgumentException("Ticket must have non-null from and to planets!");
        }

        try (Session session = sessionFactory.openSession()) {
            Client client = session.get(Client.class, ticket.getClient().getId());
            Planet fromPlanet = session.get(Planet.class, ticket.getFromPlanet().getId());
            Planet toPlanet = session.get(Planet.class, ticket.getToPlanet().getId());

            if (client == null) {
                throw new IllegalArgumentException("Client does not exist in DB!");
            }
            if (fromPlanet == null || toPlanet == null) {
                throw new IllegalArgumentException("One or both planets do not exist in DB!");
            }

            // Встановлюємо реальні об'єкти з БД
            ticket.setClient(client);
            ticket.setFromPlanet(fromPlanet);
            ticket.setToPlanet(toPlanet);

            Transaction tx = session.beginTransaction();
            session.persist(ticket);
            tx.commit();

            return ticket.getId();
        }
    }

    @Override
    public Ticket getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Ticket.class, id);
        }
    }

    @Override
    public List<Ticket> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Ticket", Ticket.class).list();
        }
    }

    @Override
    public void update(Ticket ticket) throws IllegalArgumentException {
        if (ticket.getClient() == null) {
            throw new IllegalArgumentException("Ticket update requires a non-null client!");
        }
        if (ticket.getFromPlanet() == null || ticket.getToPlanet() == null) {
            throw new IllegalArgumentException("Ticket update requires non-null from and to planets!");
        }

        try (Session session = sessionFactory.openSession()) {
            Client client = session.get(Client.class, ticket.getClient().getId());
            Planet fromPlanet = session.get(Planet.class, ticket.getFromPlanet().getId());
            Planet toPlanet = session.get(Planet.class, ticket.getToPlanet().getId());

            if (client == null) {
                throw new IllegalArgumentException("Client does not exist in DB!");
            }
            if (fromPlanet == null || toPlanet == null) {
                throw new IllegalArgumentException("One or both planets do not exist in DB!");
            }

            ticket.setClient(client);
            ticket.setFromPlanet(fromPlanet);
            ticket.setToPlanet(toPlanet);

            Transaction tx = session.beginTransaction();
            session.merge(ticket);
            tx.commit();
        }
    }

    @Override
    public void delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Ticket ticket = session.get(Ticket.class, id);
            if(ticket != null){
                Transaction tx = session.beginTransaction();
                session.remove(ticket);
                tx.commit();
            }
        }
    }
}