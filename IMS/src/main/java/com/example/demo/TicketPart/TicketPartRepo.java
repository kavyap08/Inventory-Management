package com.example.demo.TicketPart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.ticket.Ticket;
import com.example.demo.parts.*;
@Repository
public interface TicketPartRepo
        extends JpaRepository<TicketPart, Long> {

    List<TicketPart> findByTicket(Ticket ticket);
    TicketPart findByTicketAndPart(
            Ticket ticket,
            Parts part
    );

}
