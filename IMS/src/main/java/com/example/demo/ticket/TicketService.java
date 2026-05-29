package com.example.demo.ticket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.audit.AuditService;
import com.example.demo.user.User;

@Service
public class TicketService {

	@Autowired
	private TicketRepo ticrepo;
	
	public List<Ticket> findAllTicket() {
		return ticrepo.findAll();
	}
	
	
	
	public void addTicket(Ticket ticket) {
		ticrepo.save(ticket);
	}
	
	public Ticket findTicket(long ticket_id) {
		return ticrepo.findById(ticket_id);
	}
	
	public void assignTicket(long ticket_id, String assignedTo) {

	    Ticket ticket = ticrepo.findById(ticket_id);

	    if(ticket != null) {

	        ticket.setAssignedTo(assignedTo);
	        ticket.setStatus("IN_PROGRESS");

	        ticrepo.save(ticket);
	    }
	}
	public void closeTicket(long ticket_id) {

	    Ticket ticket = ticrepo.findById(ticket_id);
	    if(ticket != null) {

	        ticket.setStatus("CLOSE");

	        ticrepo.save(ticket);
	    }
	}
	public void changeStatus(long ticket_id,String status) {
		
		Ticket oldTicket=ticrepo.findById(ticket_id);
		
		if(oldTicket != null) {
			
			oldTicket.setStatus(status);
			
			ticrepo.save(oldTicket);
		}
	}
	
	public List<Ticket> showStatus(String status){
		return ticrepo.findByStatus(status);
	}
	
	
	public void delTicket(long ticket_id) {

	    Ticket ticket = ticrepo.findById(ticket_id);

	 

	    ticrepo.deleteById(ticket_id);
	}
	
	 public List<Ticket> findTicketsByEngineer(String username) {
		 List<Ticket> assignedTickets = ticrepo.findByAssignedTo(username);

		    List<Ticket> unassignedTickets = ticrepo.findByAssignedToIsNull();

		    assignedTickets.addAll(unassignedTickets);

		    return assignedTickets;
		}

		public List<Ticket> findTicketsByEngineerAndStatus(String username, String status) {
		    List<Ticket> assignedTickets = ticrepo.findByAssignedToAndStatus(username, status);

		    List<Ticket> unassignedTickets = ticrepo.findByAssignedToIsNullAndStatus(status);

		    assignedTickets.addAll(unassignedTickets);

		    return assignedTickets;
		}
	
}