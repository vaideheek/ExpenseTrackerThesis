package com.example.expensetrackerthesis.controllers;


import com.example.expensetrackerthesis.entities.Income;
import com.example.expensetrackerthesis.services.IncomeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/incomes")
public class IncomeController {

    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping("/all")
    public List<Income> getAllIncomes() {
        return incomeService.getAllIncomes();
    }

    @GetMapping("/{id}")
    public Optional<Income> getIncomeById(@PathVariable Long id) {
        return incomeService.getIncomeById(id);
    }

    @PostMapping("/add")
    public void addIncome(@RequestBody Income income) {
        incomeService.addIncome(income);
    }

    @PutMapping("/update")
    public void updateIncome(@RequestBody Income income) {
        incomeService.updateIncome(income);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteIncome(@PathVariable Long id) {
        incomeService.deleteIncome(id);
    }
}
