package com.example.expensetrackerthesis.controllers;


import com.example.expensetrackerthesis.entities.Savings;
import com.example.expensetrackerthesis.services.SavingsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/savings")
public class SavingsController {

    private final SavingsService savingsService;

    public SavingsController(SavingsService savingsService) {
        this.savingsService = savingsService;
    }

    @GetMapping("/all")
    public List<Savings> getAllSavings() {
        return savingsService.getAllSavings();
    }

    @GetMapping("/{id}")
    public Optional<Savings> getSavingsById(@PathVariable Long id) {
        return savingsService.getSavingsById(id);
    }

    @PostMapping("/add")
    public void addSavings(@RequestBody Savings savings) {
        savingsService.addSavings(savings);
    }

    @PutMapping("/update")
    public void updateSavings(@RequestBody Savings savings) {
        savingsService.updateSavings(savings);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSavings(@PathVariable Long id) {
        savingsService.deleteSavings(id);
    }
}
