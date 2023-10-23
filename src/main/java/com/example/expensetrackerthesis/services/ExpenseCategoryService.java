package com.example.expensetrackerthesis.services;


import com.example.expensetrackerthesis.entities.ExpenseCategory;
import com.example.expensetrackerthesis.repositories.ExpenseCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseCategoryService {

    private final ExpenseCategoryRepository expenseCategoryRepository;

    public ExpenseCategoryService(ExpenseCategoryRepository expenseCategoryRepository) {
        this.expenseCategoryRepository = expenseCategoryRepository;
    }

    public List<ExpenseCategory> getAllExpenseCategories() {
        return expenseCategoryRepository.findAll();
    }

    public void addExpenseCategory(ExpenseCategory category) {
        expenseCategoryRepository.save(category);
    }

    public void updateExpenseCategory(ExpenseCategory category) {
        expenseCategoryRepository.save(category);
    }

    public ExpenseCategory getExpenseCategoryById(Long id) {
        Optional<ExpenseCategory> categoryOptional = expenseCategoryRepository.findById(id);
        return categoryOptional.orElse(null);
    }
}
