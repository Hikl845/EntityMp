package org.example.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "planet")
public class Planet {

    @Id
    private String id;

    private String name;

    @OneToMany(mappedBy = "fromPlanet")
    private List<Ticket> ticketsFrom;

    @OneToMany(mappedBy = "toPlanet")
    private List<Ticket> ticketsTo;

    public Planet(){}

    public Planet(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ticket> getTicketsTo() {
        return ticketsTo;
    }

    public List<Ticket> getTicketsFrom() {
        return ticketsFrom;
    }
}