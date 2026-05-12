package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.user.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private HomeRepo homeRepo;

    // Login Page
    @GetMapping("/login")
    public String form() {
        return "login";
    }
    @GetMapping("/dashboard")
    public String dash() {
    	return "dashboard";
    }
    // Check Login
    @PostMapping("/login")
    public String loginUser(HttpServletRequest request, Model model) {

        String inputUsername = request.getParameter("username");
        String inputPassword = request.getParameter("password");

        User user = homeRepo.findByUsernameAndPassword(
                inputUsername,
                inputPassword
        );

        if (user != null) {
        	
        	model.addAttribute("user", user);
            model.addAttribute("username", user.getUsername());
            model.addAttribute("role", user.getRole());


            System.out.println("Login Success");
            System.out.println(user.getUsername());
            System.out.println(user.getRole());

            return "dashboard";

        } else {

            System.out.println("Invalid Login");

            return "login";
        }
    }
    @GetMapping("/logout")
    public String logout() {
    	return "redirect:/login";
    }
}