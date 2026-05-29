package com.example.demo.audit;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.ticket.*;
import com.example.demo.user.*;


public interface AuditRepo extends JpaRepository<Audit, Long> {
	List<Audit> findByTicketOrderByCreatedAtAsc(Ticket ticket);
	

}
