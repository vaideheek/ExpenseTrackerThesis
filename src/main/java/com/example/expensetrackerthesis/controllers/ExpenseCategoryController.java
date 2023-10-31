/*
package com.example.expensetrackerthesis.controllers;


import com.example.expensetrackerthesis.entities.ExpenseCategory;
import com.example.expensetrackerthesis.services.ExpenseCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense-categories")
public class ExpenseCategoryController {

    private final ExpenseCategoryService expenseCategoryService;

    public ExpenseCategoryController(ExpenseCategoryService expenseCategoryService) {
        this.expenseCategoryService = expenseCategoryService;
    }

    @GetMapping("/all")
    public List<ExpenseCategory> getAllExpenseCategories() {
        return expenseCategoryService.getAllExpenseCategories();
    }

    @PostMapping("/add")
    public void addExpenseCategory(@RequestBody ExpenseCategory category) {
        expenseCategoryService.addExpenseCategory(category);
    }

    @PutMapping("/update")
    public void updateExpenseCategory(@RequestBody ExpenseCategory category) {
        expenseCategoryService.updateExpenseCategory(category);
    }

    @GetMapping("/{id}")
    public ExpenseCategory getExpenseCategoryById(@PathVariable Long id) {
        return expenseCategoryService.getExpenseCategoryById(id);
    }
}
*/
