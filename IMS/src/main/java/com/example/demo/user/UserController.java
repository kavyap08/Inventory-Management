package com.example.demo.user;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/staff")
	public String staff(Model model, HttpServletRequest request) {
		 List <User> users= service.findalluser();
		model.addAttribute("users",users);
		return "staff";
	}
	@RequestMapping("/add-staff")
	public String addstaff(HttpServletRequest request) {
		    String inputUsername = request.getParameter("username");
	        String inputPassword = request.getParameter("password");
	        String inputRole= request.getParameter("role");
	        String inputName = request.getParameter("name");
	        
	        
	        User user= new User();
	        user.setUsername(inputUsername);
	        user.setName(inputName);
	        user.setPassword(inputPassword);
	        user.setRole(inputRole);        
	        service.addUser(user);
	        return "success";
	}

}
