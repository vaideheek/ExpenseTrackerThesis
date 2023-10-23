package com.example.expensetrackerthesis.repositories;

import com.example.expensetrackerthesis.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
