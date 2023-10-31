package com.example.expensetrackerthesis.controllers;

import com.example.expensetrackerthesis.entities.User;
import com.example.expensetrackerthesis.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
        User user = userService.findUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            // Authentication successful, redirect to a new page
            return "redirect:/incomes"; // Replace with your desired redirect URL
        } else {
            // Authentication failed, return to the login page with an error message
            return "redirect:/login?error=1"; // Add an error query parameter
        }
    }

}
