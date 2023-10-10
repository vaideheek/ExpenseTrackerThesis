package com.example.expensetrackerthesis.repositories;


import com.example.expensetrackerthesis.entities.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
    // Custom query methods if needed
}
