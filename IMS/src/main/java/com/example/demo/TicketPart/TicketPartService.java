package com.example.demo.TicketPart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.audit.AuditService;
import com.example.demo.parts.Parts;
import com.example.demo.parts.PartsRepo;
import com.example.demo.ticket.Ticket;
import com.example.demo.ticket.TicketRepo;

@Service
public class TicketPartService {

    @Autowired
    private TicketPartRepo ticketPartRepo;

    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private PartsRepo partsRepo;

    @Autowired
    private AuditService auditService;
    
    public boolean assignPartToTicket(
            long ticketId,
            String sku,
            Integer quantity,
            String username) {

        Ticket ticket =
                ticketRepo.findById(ticketId);

        Parts part =
                partsRepo.findBySku(sku);

        if(part.getStock() < quantity) {

            return false;
        }

        part.setStock(
                part.getStock() - quantity
        );

        partsRepo.save(part);

        TicketPart ticketPart =
                ticketPartRepo.findByTicketAndPart(
                        ticket,
                        part
                );

        if(ticketPart == null) {

            ticketPart = new TicketPart();

            ticketPart.setTicket(ticket);

            ticketPart.setPart(part);

            ticketPart.setQuantity(quantity);

        } else {

            ticketPart.setQuantity(
                    ticketPart.getQuantity()
                    + quantity
            );
        }

        ticketPartRepo.save(ticketPart);

        auditService.addComment(
                ticketId,
                username,
                "Assigned "
                + part.getSku()
                + " x"
                + quantity
                + " to ticket"
        );

        if(part.getStock()
                <= part.getThreshold()) {

            auditService.addComment(
                    ticketId,
                    username,
                    "LOW STOCK ALERT : "
                    + part.getSku()
            );
        }

        return true;
    }
    public List<TicketPart> findByTicket(
            Ticket ticket) {

        return ticketPartRepo.findByTicket(ticket);
    }
    

}
