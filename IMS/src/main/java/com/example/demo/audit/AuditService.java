package com.example.demo.audit;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ticket.*;
import com.example.demo.user.*;

import jakarta.transaction.Transactional;

@Service
public class AuditService {
	@Autowired 
	private UserRepo userrepo;
	
	@Autowired
	private TicketRepo ticketrepo;
	
	@Autowired
	private AuditRepo auditrepo;
	
	public void addComment(long ticket_id,
	        String username,
	        String comment) {

	Ticket ticket = ticketrepo.findById(ticket_id);

	User user = userrepo.findByUsername(username);

	Audit audit = new Audit();

	audit.setTicket(ticket);

	audit.setUser(user);

	audit.setType(Audit.AuditType.COMMENT);

	audit.setComment(comment);

	audit.setCreatedAt(LocalDateTime.now());

	auditrepo.save(audit);
	}

	public void addStatusUpdate(long ticket_id,
	             String username,
	             String message) {

	Ticket ticket = ticketrepo.findById(ticket_id);

	User user = userrepo.findByUsername(username);

	Audit audit = new Audit();

	audit.setTicket(ticket);

	audit.setUser(user);

	audit.setType(Audit.AuditType.STATUS_UPDATE);

	audit.setComment(message);

	audit.setCreatedAt(LocalDateTime.now());

	auditrepo.save(audit);
	}

	public void addAssignUpdate(long ticket_id,
	             String username,
	             String message) {

	Ticket ticket = ticketrepo.findById(ticket_id);

	User user = userrepo.findByUsername(username);

	Audit audit = new Audit();

	audit.setTicket(ticket);

	audit.setUser(user);

	audit.setType(Audit.AuditType.ASSIGN_UPDATE);

	audit.setComment(message);

	audit.setCreatedAt(LocalDateTime.now());

	auditrepo.save(audit);
	}
	public List<Audit> findByTicket(Ticket ticket) {

        return auditrepo.findByTicketOrderByCreatedAtAsc(ticket);
    }

    public List<Audit> findAllAudits() {

        return auditrepo.findAll();
    }
    public void addPartAssignmentAudit(
            long ticket_id,
            String username,
            String sku,
            Integer quantity) {

        Ticket ticket =
                ticketrepo.findById(ticket_id);

        User user =
                userrepo.findByUsername(username);

        Audit audit =
                new Audit();

        audit.setTicket(ticket);

        audit.setUser(user);

        audit.setType(
                Audit.AuditType.ASSIGN_PART
        );

        audit.setComment(
                "Assigned "
                + sku
                + " x"
                + quantity
                + " to ticket"
        );

        audit.setCreatedAt(
                LocalDateTime.now()
        );

        auditrepo.save(audit);
    }
   
}
