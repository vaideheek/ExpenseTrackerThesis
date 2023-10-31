package com.example.expensetrackerthesis.controllers;

import com.example.expensetrackerthesis.entities.Budget;
import com.example.expensetrackerthesis.services.BudgetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/budgets")
public class BudgetController {

    private final BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {

        this.budgetService = budgetService;
    }

    @GetMapping("/budgets")
    public String budgetsPage() {
        return "budgets";
    }

    @GetMapping("/allBudgets")
    public List<Budget> getAllBudgets() {

        return budgetService.getAllBudgets();
    }

    @GetMapping("budgets/{id}")
    public Optional<Budget> getBudgetById(@PathVariable Long id) {
        return budgetService.getBudgetById(id);
    }

    @PostMapping("/addBudgets")
    public void addBudget(@RequestBody Budget budget) {
        budgetService.addBudget(budget);
    }

    @PutMapping("/updateBudgets")
    public void updateBudget(@RequestBody Budget budget) {
        budgetService.updateBudget(budget);
    }

    @DeleteMapping("/deleteBudgets/{id}")
    public void deleteBudget(@PathVariable Long id) {
        budgetService.deleteBudget(id);
    }
}

