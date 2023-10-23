package com.example.expensetrackerthesis.repositories;

import com.example.expensetrackerthesis.entities.Savings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingsRepository extends JpaRepository<Savings, Long> {
}