package com.example.expensetrackerthesis.repositories;


import com.example.expensetrackerthesis.entities.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
}
