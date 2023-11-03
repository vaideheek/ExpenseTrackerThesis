package com.example.expensetrackerthesis.controllers;

import com.example.expensetrackerthesis.entities.SavingsGoal;
import com.example.expensetrackerthesis.services.SavingsGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/savings-goals")
public class SavingsGoalController {

    private final SavingsGoalService savingsGoalService;

    @Autowired
    public SavingsGoalController(SavingsGoalService savingsGoalService) {
        this.savingsGoalService = savingsGoalService;
    }

    @GetMapping("/getAllSavingsGoals")
    public List<SavingsGoal> getAllSavingsGoals() {
        return savingsGoalService.getAllSavingsGoals();
    }

    @GetMapping("/getSavingsGoal/{id}")
    public Optional<SavingsGoal> getSavingsGoalById(@PathVariable Long id) {
        return savingsGoalService.getSavingsGoalById(id);
    }

    @PostMapping("/addSavingsGoal")
    public SavingsGoal createSavingsGoal(@RequestBody SavingsGoal savingsGoal) {
        return savingsGoalService.createSavingsGoal(savingsGoal);
    }

    @PutMapping("/updateSavingsGoal/{id}")
    public SavingsGoal updateSavingsGoal(@PathVariable Long id, @RequestBody SavingsGoal savingsGoal) {
        savingsGoal.setId(id);
        return savingsGoalService.updateSavingsGoal(savingsGoal);
    }

    @DeleteMapping("/deleteSavingsGoal/{id}")
    public ResponseEntity<?> deleteSavingsGoal(@PathVariable Long id) {
        savingsGoalService.deleteSavingsGoal(id);
        return ResponseEntity.ok("Savings goal deleted");
    }
}
