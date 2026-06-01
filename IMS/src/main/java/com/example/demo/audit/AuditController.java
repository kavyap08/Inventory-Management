package com.example.demo.audit;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.parts.Parts;
import com.example.demo.ticket.Ticket;
import com.example.demo.ticket.TicketService;
import com.example.demo.user.User;
import com.example.demo.ticket.*;
import com.example.demo.TicketPart.*;
import com.example.demo.parts.*;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AuditController {
	
	@Autowired
	private AuditService auditservice;
	
	@Autowired
	private TicketService ticketservice;
	
	@Autowired
	private PartsService partsservice;
	
	@Autowired
	private TicketPartService ticketpartservice;
	
	@GetMapping("/audit")
	public String audit(HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("sessionUser");

        if(user == null) {
            return "redirect:/login";
        }
        List<Audit> audits = auditservice.findAllAudits();

        model.addAttribute("audits", audits);

        model.addAttribute("user", user);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("role", user.getRole());

        return "audit";
	}
	@GetMapping("/ticket-overview")
	public String ticketOverview(
	        HttpServletRequest request,
	        Model model) {
		User user = (User) request.getSession().getAttribute("sessionUser");

        if(user == null) {
            return "redirect:/login";
        }

	    long ticket_id =
	            Long.parseLong(
	                    request.getParameter("ticket_id")
	            );

	    Ticket ticket =
	            ticketservice.findTicket(ticket_id);
	    

	    List<Audit> audits =
	            auditservice.findByTicket(ticket);

	    List<Parts> parts =
	            partsservice.findAllParts();

	    List<TicketPart> ticketParts =
	            ticketpartservice.findByTicket(ticket);
	    String error =
	            request.getParameter("error");

	    model.addAttribute("error", error);

	    model.addAttribute("ticket", ticket);
	    model.addAttribute("audits", audits);
	    model.addAttribute("parts", parts);
	    model.addAttribute("ticketParts", ticketParts);
	    model.addAttribute("user", user);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("role", user.getRole());
	    return "ticket-overview";
	}
	@PostMapping("/add-comment")
	public String addcomment(HttpServletRequest request, Model model){
		User user = (User) request.getSession().getAttribute("sessionUser");

        if(user == null) {
            return "redirect:/login";
        }
        String Id = request.getParameter("ticket_id");
        long ticket_id = Long.parseLong(Id);
        String comment= request.getParameter("comment");
        auditservice.addComment(ticket_id, user.getUsername(), comment);
        
         return "redirect:/ticket-overview?ticket_id=" + ticket_id;
       
         
	}
	

}
