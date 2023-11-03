package com.example.expensetrackerthesis.repositories;

import com.example.expensetrackerthesis.entities.SavingsGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsGoalRepository extends JpaRepository<SavingsGoal, Long> {
    // Add custom query methods if needed
}
