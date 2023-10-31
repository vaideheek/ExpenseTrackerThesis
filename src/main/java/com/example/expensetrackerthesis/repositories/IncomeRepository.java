package com.example.expensetrackerthesis.repositories;


import com.example.expensetrackerthesis.entities.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {

    @Query("SELECT DISTINCT i.category FROM Income i")
    List<String> findDistinctCategories();
}
