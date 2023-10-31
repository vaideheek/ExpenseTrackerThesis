package com.example.expensetrackerthesis.repositories;


import com.example.expensetrackerthesis.entities.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {

}
