package com.example.demo.ticket;

import com.example.demo.user.UserService;
import com.example.demo.user.User;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TicketController {

    @Autowired
    public TicketService service;

    @Autowired
    public UserService userservice;


    @GetMapping("/add-ticket")
    public String ticket(HttpServletRequest request, Model model) {

        User user = (User) request.getSession().getAttribute("sessionUser");

        if(user == null) {
            return "redirect:/login";
        }

        if(!user.getRole().equals("SUPERADMIN")) {
            return "redirect:/tickets";
        }

       
        model.addAttribute("user", user);
        model.addAttribute("role", user.getRole());
        model.addAttribute("username", user.getUsername());
        return "add-ticket";
    }


    @PostMapping("/save-ticket")
    public String addTicket(HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("sessionUser");

        if(user == null) {
            return "redirect:/login";
        }

        if(!user.getRole().equals("SUPERADMIN")) {
            return "redirect:/tickets";
        }

        String inputIssue = request.getParameter("issue");
        String inputPriority = request.getParameter("priority");

        Ticket ticket = new Ticket();

        ticket.setPriority(inputPriority);
        ticket.setIssue(inputIssue);
        ticket.setAssignedTo(null);
        ticket.setStatus("OPEN");
        ticket.setCreatedDate(LocalDate.now());

        service.addTicket(ticket);

        return "redirect:/tickets";
    }


	/*
	 * @GetMapping("/tickets/status/{status}") public String statusOpen(Model
	 * model, @PathVariable String status, HttpServletRequest request) {
	 * 
	 * User user = (User) request.getSession().getAttribute("sessionUser");
	 * 
	 * if(user == null) { return "redirect:/login"; }
	 * 
	 * List<Ticket> tickets;
	 * 
	 * if(user.getRole().equals("SUPERADMIN")) { tickets =
	 * service.showStatus(status); } else { tickets =
	 * service.findTicketsByEngineerAndStatus(user.getUsername(), status); }
	 * 
	 * model.addAttribute("tickets", tickets); model.addAttribute("user", user);
	 * model.addAttribute("role", user.getRole());
	 * model.addAttribute("username",user.getUsername());
	 * 
	 * return "tickets"; }
	 */


    @PostMapping("/change-status")
    public String change(HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("sessionUser");

        if(user == null) {
            return "redirect:/login";
        }

        String inputId = request.getParameter("ticket_id");
        String inputStatus = request.getParameter("status");

        long ticket_id = Long.parseLong(inputId);

        service.changeStatus(ticket_id, inputStatus);

        return "redirect:/tickets";
    }


	/*
	 * @GetMapping("/tickets") public String show(Model model, HttpServletRequest
	 * request) {
	 * 
	 * User user = (User) request.getSession().getAttribute("sessionUser");
	 * 
	 * if(user == null) { return "redirect:/login"; }
	 * 
	 * List<Ticket> tickets;
	 * 
	 * if(user.getRole().equals("SUPERADMIN")) { tickets = service.findAllTicket();
	 * } else { tickets = service.findTicketsByEngineer(user.getUsername()); }
	 * 
	 * model.addAttribute("tickets", tickets); model.addAttribute("user", user);
	 * model.addAttribute("role", user.getRole()); model.addAttribute("username",
	 * user.getUsername());
	 * 
	 * return "tickets"; }
	 */
    
    @GetMapping("/tickets")
    public String showTickets(Model model, HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("sessionUser");

        if(user == null) {
            return "redirect:/login";
        }

        String status = request.getParameter("status");

        List<Ticket> tickets;

        if(status == null || status.trim().isEmpty()) {

            if(user.getRole().equals("SUPERADMIN")) {
                tickets = service.findAllTicket();
            } else {
                tickets = service.findTicketsByEngineer(user.getUsername());
            }

        } else {

            if(user.getRole().equals("SUPERADMIN")) {
                tickets = service.showStatus(status);
            } else {
                tickets = service.findTicketsByEngineerAndStatus(user.getUsername(), status);
            }

        }

        model.addAttribute("tickets", tickets);
        model.addAttribute("user", user);
        model.addAttribute("role", user.getRole());
        model.addAttribute("username", user.getUsername());

        return "tickets";
    }


    @PostMapping("/delete-ticket")
    public String del(HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("sessionUser");

        if(user == null) {
            return "redirect:/login";
        }

        if(!user.getRole().equals("SUPERADMIN")) {
            return "redirect:/tickets";
        }

        String idValue = request.getParameter("ticket_id");

        long ticket_id = Long.parseLong(idValue);

        service.delTicket(ticket_id);

        return "redirect:/tickets";
    }


    @GetMapping("/assign-ticket")
    public String showassignticket(Model model, HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("sessionUser");

        if(user == null) {
            return "redirect:/login";
        }

        if(!user.getRole().equals("SUPERADMIN")) {
            return "redirect:/tickets";
        }

        String idValue = request.getParameter("ticket_id");

        long ticket_id = Long.parseLong(idValue);

        Ticket ticket = service.findTicket(ticket_id);

        List<User> engineers = userservice.findByRole("ENGINEER");

        model.addAttribute("engineers", engineers);
        model.addAttribute("ticket", ticket);
        model.addAttribute("user", user);
        model.addAttribute("role", user.getRole());
        model.addAttribute("username", user.getUsername());

        return "assign-ticket";
    }


    @PostMapping("/assign-ticket")
    public String assignTic(HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("sessionUser");

        if(user == null) {
            return "redirect:/login";
        }

        if(!user.getRole().equals("SUPERADMIN")) {
            return "redirect:/tickets";
        }

        String assignedTo = request.getParameter("assignedTo");
        String id = request.getParameter("ticket_id");

        long ticket_id = Long.parseLong(id);

        service.assignTicket(ticket_id, assignedTo);

        return "redirect:/tickets";
    }


    @PostMapping("/close-ticket")
    public String close(HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("sessionUser");

        if(user == null) {
            return "redirect:/login";
        }

        String idValue = request.getParameter("ticket_id");

        long ticket_id = Long.parseLong(idValue);

        Ticket ticket = service.findTicket(ticket_id);

        if(ticket == null) {
            return "redirect:/tickets";
        }

        if(user.getRole().equals("SUPERADMIN") || ticket.getAssignedTo().equals(user.getUsername())) {
            service.closeTicket(ticket_id);
        }

        return "redirect:/tickets";
    }
}