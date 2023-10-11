package com.example.expensetrackerthesis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @GetMapping("/register")
    public String registerPage() {
        return "register"; // Thymeleaf will resolve this to register.html
    }

    @PostMapping("/register")
    public String register(@RequestParam("username") String username, @RequestParam("password") String password) {
        // Handle registration logic here
        // For simplicity, we'll just print the registration information
        System.out.println("Registration request - Username: " + username + ", Password: " + password);
        return "redirect:/"; // Redirect to the home page or dashboard
    }
}
