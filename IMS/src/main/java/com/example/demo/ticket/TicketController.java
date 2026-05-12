package com.example.demo.ticket;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TicketController {
	
	@Autowired
	public TicketService service;

	@GetMapping("/add-ticket")
	public String ticket() {
		return "add-ticket";
	}
	
	
	  @PostMapping("/save-ticket") 
	  public String addTicket(HttpServletRequest request) {
	  String inputIssue = request.getParameter("issue");
	  String inputPriority = request.getParameter("priority");
	  String inputStatus = request.getParameter("status");
	  String inputassTo = request.getParameter("ass_to");
	  
	  Ticket ticket = new Ticket();
	  
	  ticket.setPriority(inputPriority);
	  ticket.setIssue(inputIssue);
	  ticket.setAss_to(inputassTo);
	  ticket.setStatus(inputStatus);
	  
	  service.addTicket(ticket);
	  
	  return "redirect:/tickets";
	  }
	  
	  @GetMapping("/tickets")
	  public String show(Model model,HttpServletRequest request) {
		  
		  List<Ticket> tickets = service.findAllTicket();
		  
		  model.addAttribute("tickets", tickets);
		  return "tickets";
	  }
	  
	  @PostMapping("/delete-ticket")
	  public String del(HttpServletRequest request) {
		
		  String idValue = request.getParameter("ticket_id");

		  long ticket_id = Long.parseLong(idValue);
		  
		  service.delTicket(ticket_id);
		  return "redirect:/tickets";
	  }
	 
	

}