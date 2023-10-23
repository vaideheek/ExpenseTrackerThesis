package com.example.expensetrackerthesis.controllers;


import com.example.expensetrackerthesis.entities.Expense;
import com.example.expensetrackerthesis.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/all")
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/{id}")
    public Optional<Expense> getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }

    @PostMapping("/add")
    public void addExpense(@RequestBody Expense expense) {
        expenseService.addExpense(expense);
    }

    @PutMapping("/update")
    public void updateExpense(@RequestBody Expense expense) {
        expenseService.updateExpense(expense);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }
}
