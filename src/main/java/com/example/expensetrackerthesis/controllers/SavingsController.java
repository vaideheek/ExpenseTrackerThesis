package com.example.expensetrackerthesis.controllers;

import com.example.expensetrackerthesis.entities.Savings;
import com.example.expensetrackerthesis.services.SavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/savings-allocations")
public class SavingsController {

    private final SavingsService savingsService;

    @Autowired
    public SavingsController(SavingsService savingsService) {
        this.savingsService = savingsService;
    }

    @GetMapping("/getAllSavings")
    public List<Savings> getAllSavings() {
        return savingsService.getAllSavings();
    }

    @GetMapping("/getSavings/{id}")
    public Optional<Savings> getSavingsById(@PathVariable Long id) {
        return savingsService.getSavingsById(id);
    }

    @PostMapping("/addSavingsAllocation")
    public Savings addSavingsAllocation(@RequestBody Savings savings) {
        return savingsService.createSavings(savings);
    }

    @PutMapping("/updateSavingsAllocation/{id}")
    public Savings updateSavingsAllocation(@PathVariable Long id, @RequestBody Savings savings) {
        savings.setId(id);
        return savingsService.updateSavings(savings);
    }

    @DeleteMapping("/deleteSavingsAllocation/{id}")
    public ResponseEntity<?> deleteSavingsAllocation(@PathVariable Long id) {
        savingsService.deleteSavings(id);
        return ResponseEntity.ok("Savings allocation deleted");
    }


}
