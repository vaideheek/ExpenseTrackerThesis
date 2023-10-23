package com.example.expensetrackerthesis.services;


import com.example.expensetrackerthesis.entities.Income;
import com.example.expensetrackerthesis.repositories.IncomeRepository;
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

    public Optional<Income> getIncomeById(Long id) {
        return incomeRepository.findById(id);
    }

    public void addIncome(Income income) {
        incomeRepository.save(income);
    }

    public void updateIncome(Income income) {
        incomeRepository.save(income);
    }

    public void deleteIncome(Long id) {
        incomeRepository.deleteById(id);
    }
}
