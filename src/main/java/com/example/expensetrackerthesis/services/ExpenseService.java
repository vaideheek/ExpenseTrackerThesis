package com.example.expensetrackerthesis.services;


import com.example.expensetrackerthesis.entities.Expense;
import com.example.expensetrackerthesis.repositories.ExpenseRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    public void addExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    public void updateExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
