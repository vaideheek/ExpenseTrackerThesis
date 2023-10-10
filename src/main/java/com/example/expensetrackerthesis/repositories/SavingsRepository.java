package com.example.expensetrackerthesis.repositories;

import com.example.expensetrackerthesis.entities.Savings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingsRepository extends JpaRepository<Savings, Long> {
    // No additional methods required for standard CRUD

    // Custom methods can be added here if needed
}