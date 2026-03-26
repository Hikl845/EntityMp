package org.example.dao;

import org.example.Entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ClientDaoServiceImpl implements ClientDaoService{

    private final SessionFactory sessionFactory;

    public ClientDaoServiceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long create(String name) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Client client = new Client(name);
        session.persist(client);

        tx.commit();
        session.close();

        return client.getId();
    }

    @Override
    public Client getById(Long id) {
        Session session = sessionFactory.openSession();
        Client client = session.get(Client.class, id);
        session.close();
        return client;
    }

    @Override
    public void update(String name, Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Client client = session.get(Client.class, id);
        client.setName(name);

        tx.commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Client client = session.get(Client.class, id);
        session.remove(client);

        tx.commit();
        session.close();
    }
}
