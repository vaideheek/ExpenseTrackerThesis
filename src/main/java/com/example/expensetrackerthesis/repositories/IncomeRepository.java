package com.example.expensetrackerthesis.repositories;


import com.example.expensetrackerthesis.Entities.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long> {
    // No additional methods required for standard CRUD

    // Custom methods can be added here if needed
}
