package com.example.demo.TicketPart;

import com.example.demo.ticket.Ticket;
import com.example.demo.parts.Parts;

import jakarta.persistence.*;

@Entity
public class TicketPart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Ticket ticket;

    @ManyToOne
    private Parts part;

    private Integer quantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Parts getPart() {
        return part;
    }

    public void setPart(Parts part) {
        this.part = part;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
