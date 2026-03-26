package org.example;

import org.example.dao.*;
import org.example.Entity.Client;
import org.example.Entity.Planet;
import org.example.Entity.Ticket;
import org.example.service.*;
import org.example.Util.HibernateUtil;
import org.hibernate.SessionFactory;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getInstance();

        // DAO та сервіси
        ClientDaoService clientDao = new ClientDaoServiceImpl(sessionFactory);
        ClientService clientService = new ClientServiceImpl(clientDao);

        PlanetDaoService planetDao = new PlanetDaoServiceImpl(sessionFactory);
        PlanetCrudService planetService = new PlanetCrudServiceImpl(planetDao);

        TicketDaoService ticketDao = new TicketDaoServiceImpl(sessionFactory);
        TicketCrudService ticketService = new TicketCrudServiceImpl(ticketDao);

        try {
            // ================= CREATE =================
            Long clientId = clientService.create("John Doe");
            planetService.create("MARS", "Mars");
            planetService.create("VENUS", "Venus");

            System.out.println("Client ID: " + clientId);
            System.out.println("Planets created: MARS, VENUS");

            Client client = clientService.getById(clientId);
            Planet fromPlanet = planetService.getById("MARS");
            Planet toPlanet = planetService.getById("VENUS");

            // Створюємо квиток
            Ticket ticket = new Ticket();
            ticket.setClient(client);
            ticket.setFromPlanet(fromPlanet);
            ticket.setToPlanet(toPlanet);

            Long ticketId = ticketService.create(ticket);
            System.out.println("Ticket created with ID: " + ticketId);

            // ================= READ =================
            Ticket savedTicket = ticketService.getById(ticketId);
            System.out.println("Ticket info: Client=" + savedTicket.getClient().getName() +
                    ", From=" + savedTicket.getFromPlanet().getName() +
                    ", To=" + savedTicket.getToPlanet().getName());

            // ================= UPDATE =================
            clientService.update("John Updated", clientId);
            planetService.update("MARS", "Mars Planet");
            ticket.setFromPlanet(planetService.getById("MARS")); // оновлюємо планету у квитку
            ticketService.update(ticket);

            System.out.println("Updated client: " + clientService.getById(clientId).getName());
            System.out.println("Updated ticket from planet: " + ticketService.getById(ticketId).getFromPlanet().getName());

            // ================= DELETE =================
            ticketService.delete(ticketId);
            clientService.delete(clientId);
            planetService.delete("MARS");
            planetService.delete("VENUS");

            System.out.println("Ticket after delete: " + (ticketService.getById(ticketId) == null ? "deleted" : "exists"));
            System.out.println("Client after delete: " + (clientService.getById(clientId) == null ? "deleted" : "exists"));
            System.out.println("Planets after delete: " +
                    (planetService.getById("MARS") == null ? "MARS deleted" : "MARS exists") + ", " +
                    (planetService.getById("VENUS") == null ? "VENUS deleted" : "VENUS exists"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Закриваємо SessionFactory через HibernateUtil
            HibernateUtil.shutdown();
        }
    }
}