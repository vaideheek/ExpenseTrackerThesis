package com.example.expensetrackerthesis.services;

import com.example.expensetrackerthesis.entities.Savings;
import com.example.expensetrackerthesis.entities.SavingsGoal;
import com.example.expensetrackerthesis.repositories.SavingsRepository;
import com.example.expensetrackerthesis.repositories.SavingsGoalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavingsService {

    private final SavingsRepository savingsRepository;
    private final SavingsGoalRepository savingsGoalRepository;

    public SavingsService(SavingsRepository savingsRepository, SavingsGoalRepository savingsGoalRepository) {
        this.savingsRepository = savingsRepository;
        this.savingsGoalRepository = savingsGoalRepository;
    }

    public List<Savings> getAllSavings() {
        return savingsRepository.findAll();
    }

    public Optional<Savings> getSavingsById(Long id) {
        return savingsRepository.findById(id);
    }

    public Savings createSavings(Savings savings) {
        return savingsRepository.save(savings);
    }

    public Savings updateSavings(Savings savings) {
        Optional<Savings> existingSavings = getSavingsById(savings.getId());

        if (existingSavings.isPresent()) {
            return savingsRepository.save(savings);
        } else {
            throw new IllegalArgumentException("Savings with ID " + savings.getId() + " not found.");
        }
    }

    public void deleteSavings(Long id) {
        Optional<Savings> existingSavings = getSavingsById(id);

        if (existingSavings.isPresent()) {
            savingsRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Savings with ID " + id + " not found.");
        }
    }

    public void updateCurrentAmountSaved(SavingsGoal goal) {
        List<Savings> associatedSavings = goal.getAssociatedSavings();
        double totalSavedAmount = 0.0;
        for (Savings savings : associatedSavings) {
            totalSavedAmount += savings.getAmount(); // Use the 'amount' field
        }
        goal.setCurrentAmount(totalSavedAmount);
        savingsGoalRepository.save(goal);
    }
}
