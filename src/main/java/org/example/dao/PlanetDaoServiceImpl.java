package org.example.dao;

import org.example.Entity.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PlanetDaoServiceImpl implements PlanetDaoService{

    private final SessionFactory sessionFactory;

    public PlanetDaoServiceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(String id, String name) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Planet planet = new Planet(id, name);
        session.persist(planet);

        tx.commit();
        session.close();
    }

    @Override
    public Planet getById(String id) {
        Session session = sessionFactory.openSession();
        Planet planet = session.get(Planet.class, id);
        session.close();
        return planet;
    }

    @Override
    public void update(String id, String name) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Planet planet = session.get(Planet.class, id);
        planet.setName(name);

        tx.commit();
        session.close();
    }

    @Override
    public void delete(String id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Planet planet = session.get(Planet.class, id);
        if (planet != null) {
            session.remove(planet);
        }

        tx.commit();
        session.close();
    }
}
