package com.example.expensetrackerthesis.repositories;

import com.example.expensetrackerthesis.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    // No additional methods required for standard CRUD

    // Custom methods can be added here if needed
}
