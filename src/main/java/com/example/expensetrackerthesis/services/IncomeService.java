package com.example.expensetrackerthesis.services;


import com.example.expensetrackerthesis.entities.Income;
import com.example.expensetrackerthesis.repositories.ExpenseCategoryRepository;
import com.example.expensetrackerthesis.repositories.IncomeRepository;
import jakarta.xml.bind.ValidationException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class IncomeService {

    private final IncomeRepository incomeRepository;

    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public List<Income> getAllIncomes() {
        return incomeRepository.findAll();
    }

    public List<String> getAllCategories() {
        return incomeRepository.findDistinctCategories();
    }


    public Optional<Income> getIncomeById(Long id) {
        return incomeRepository.findById(id);
    }

    public void addIncome(Income income) throws ValidationException {
        if (income.isValid()) {
            incomeRepository.save(income);
        } else {
            // Handle validation error, e.g., throw an exception or return an error message
                throw new ValidationException("Income data is not valid.");
            }


    }

    public void updateIncome(Income income) throws ValidationException {
        if (income.isValid()) {
            incomeRepository.save(income);
        } else {
            // Handle validation error, e.g., throw an exception or return an error message
            throw new ValidationException("Income data is not valid.");
        }
    }

    public void deleteIncome(Long id) {
        incomeRepository.deleteById(id);
    }
}
