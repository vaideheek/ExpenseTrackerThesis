package com.example.expensetrackerthesis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
        System.out.println("Login request - Email: " + email + ", Password: " + password);
        return "redirect:/";
    }
}

