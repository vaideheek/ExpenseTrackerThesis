package com.example.expensetrackerthesis.controllers;


import com.example.expensetrackerthesis.entities.Income;
import com.example.expensetrackerthesis.services.IncomeService;
import jakarta.xml.bind.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class IncomeController {

    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }


    @GetMapping("/incomes")
    public String incomesPage() {
        return "incomes"; // This should match the template name without the ".html" extension
    }

    @GetMapping("/allIncomes")
    public List<Income> getAllIncomes() {
        return incomeService.getAllIncomes();
    }

    @GetMapping("incomes/{id}")
    public Optional<Income> getIncomeById(@PathVariable Long id) {
        return incomeService.getIncomeById(id);
    }

    @PostMapping("/addIncomes")
    public void addIncome(@RequestBody Income income) throws ValidationException {
        incomeService.addIncome(income);
    }

    @PutMapping("/updateIncomes/{id}")
    public void updateIncome(@PathVariable Long id, @RequestBody Income income) throws ValidationException {
        incomeService.updateIncome(income);
    }

    @DeleteMapping("/deleteIncomes/{id}")
    public void deleteIncome(@PathVariable Long id) {
        incomeService.deleteIncome(id);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<String>> getAllCategories() {
        List<String> categories = incomeService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
