package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserRepo userRepo;

    // Login Page
    @GetMapping("/login")
    public String form() {
        return "login";
    }

    // Check Login
    @PostMapping("/login")
    public String loginUser(HttpServletRequest request) {

        String inputUsername = request.getParameter("username");
        String inputPassword = request.getParameter("password");

        User user = userRepo.findByUsernameAndPassword(
                inputUsername,
                inputPassword
        );

        if (user != null) {

            System.out.println("Login Success");
            System.out.println(user.getUsername());
            System.out.println(user.getRole());

            return "success";

        } else {

            System.out.println("Invalid Login");

            return "login";
        }
    }
}