package org.example.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(
        name = "client"
)
public class Client {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;

    private String name;
    @OneToMany(mappedBy = "client")
    private List<Ticket> tickets;

    public Client() {
    }

    public Client(String name) {
        this.name = name;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}

