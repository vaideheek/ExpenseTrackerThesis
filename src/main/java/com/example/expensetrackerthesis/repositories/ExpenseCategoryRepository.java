package com.example.expensetrackerthesis.repositories;

import com.example.expensetrackerthesis.entities.ExpenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseCategoryRepository extends JpaRepository<ExpenseCategory, Long> {

}
