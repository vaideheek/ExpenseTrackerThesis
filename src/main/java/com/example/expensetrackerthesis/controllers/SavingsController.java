package com.example.expensetrackerthesis.controllers;


import com.example.expensetrackerthesis.entities.Savings;
import com.example.expensetrackerthesis.services.SavingsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class SavingsController {

    private final SavingsService savingsService;

    public SavingsController(SavingsService savingsService) {
        this.savingsService = savingsService;
    }


    @GetMapping("/savings")
    public String savingsPage() {
        return "savings";
    }

    @GetMapping("/allSavings")
    public List<Savings> getAllSavings() {
        return savingsService.getAllSavings();
    }

    @GetMapping("savings/{id}")
    public Optional<Savings> getSavingsById(@PathVariable Long id) {
        return savingsService.getSavingsById(id);
    }

    @PostMapping("/addSavings")
    public void addSavings(@RequestBody Savings savings) {
        savingsService.addSavings(savings);
    }

    @PutMapping("/updateSavings")
    public void updateSavings(@RequestBody Savings savings) {
        savingsService.updateSavings(savings);
    }

    @DeleteMapping("/deleteSavings/{id}")
    public void deleteSavings(@PathVariable Long id) {
        savingsService.deleteSavings(id);
    }
}
