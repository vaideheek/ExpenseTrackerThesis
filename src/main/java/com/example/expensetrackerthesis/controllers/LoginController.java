package com.example.expensetrackerthesis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Thymeleaf will resolve this to login.html
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        // Handle login logic here
        // For simplicity, we'll just print the login information
        System.out.println("Login request - Username: " + username + ", Password: " + password);
        return "redirect:/"; // Redirect to the home page or dashboard
    }
}
