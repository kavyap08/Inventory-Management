package com.example.demo.ticket;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.user.User;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Long> {

	Ticket findById(long ticket_id);
	List<Ticket> findByStatus(String status);
	List<Ticket> findByAssignedTo(String assignedTo);

	List<Ticket> findByAssignedToAndStatus(String assignedTo, String status);
	
	List<Ticket> findByAssignedToIsNull();

	List<Ticket> findByAssignedToIsNullAndStatus(String status);
}