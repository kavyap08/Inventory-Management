package com.example.demo.ticket;
import java.time.LocalDate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ticket_id;
	
	private LocalDate createdDate;

	@Transient
	private String customTicketId;

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public void setCustomTicketId(String customTicketId) {
		this.customTicketId = customTicketId;
	}

	

	public String getCustomTicketId() {
		if(createdDate == null) {
	        return "TKT-" + ticket_id;
	    }

	    String formattedDate = createdDate.toString().replace("-", "");

	    return "TKT-" + formattedDate + "-" + ticket_id;
	}
	
	private String issue;
	
	private String priority;
	
	@Column(name = "assigned_to")
	private String assignedTo;
	
	private String status;

	public long getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(long ticket_id) {
		this.ticket_id = ticket_id;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	} 
	

	
	
}

