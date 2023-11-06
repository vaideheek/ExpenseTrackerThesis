package com.example.expensetrackerthesis.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboardPage() {
        return "dashboard";
    }
}