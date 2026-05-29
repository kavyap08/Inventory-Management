package com.example.demo.audit;
import java.time.LocalDateTime;

import com.example.demo.ticket.*;
import com.example.demo.user.*;
import jakarta.persistence.*;
@Entity
public class Audit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	private String comment;
	
	@ManyToOne
	private Ticket ticket;
	
	@ManyToOne
	private User user;
	
	 public enum AuditType {

	        COMMENT,
	        STATUS_UPDATE,
	        ASSIGN_UPDATE
	    }
	    
	    @Enumerated(EnumType.STRING)
	    private AuditType type;
	    
	    private LocalDateTime createdAt;

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

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public AuditType getType() {
			return type;
		}

		public void setType(AuditType type) {
			this.type = type;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}
		
	    
	    
}
