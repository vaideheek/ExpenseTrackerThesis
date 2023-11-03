package com.example.expensetrackerthesis.services;

import com.example.expensetrackerthesis.entities.Savings;
import com.example.expensetrackerthesis.entities.SavingsGoal;
import com.example.expensetrackerthesis.repositories.SavingsGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavingsGoalService {

    private final SavingsGoalRepository savingsGoalRepository;
    private final SavingsService savingsService;

    @Autowired
    public SavingsGoalService(SavingsGoalRepository savingsGoalRepository, SavingsService savingsService) {
        this.savingsGoalRepository = savingsGoalRepository;
        this.savingsService = savingsService;
    }

    public List<SavingsGoal> getAllSavingsGoals() {
        return savingsGoalRepository.findAll();
    }

    public Optional<SavingsGoal> getSavingsGoalById(Long id) {
        return savingsGoalRepository.findById(id);
    }

    public SavingsGoal createSavingsGoal(SavingsGoal savingsGoal) {
        return savingsGoalRepository.save(savingsGoal);
    }

    public SavingsGoal updateSavingsGoal(SavingsGoal savingsGoal) {
        Optional<SavingsGoal> existingSavingsGoal = getSavingsGoalById(savingsGoal.getId());

        if (existingSavingsGoal.isPresent()) {
            return savingsGoalRepository.save(savingsGoal);
        } else {
            throw new IllegalArgumentException("SavingsGoal with ID " + savingsGoal.getId() + " not found.");
        }
    }

    public void deleteSavingsGoal(Long id) {
        Optional<SavingsGoal> existingSavingsGoal = getSavingsGoalById(id);

        if (existingSavingsGoal.isPresent()) {
            List<Savings> associatedSavings = existingSavingsGoal.get().getAssociatedSavings();
            for (Savings savings : associatedSavings) {
                savingsService.deleteSavings(savings.getId());
            }
            savingsGoalRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("SavingsGoal with ID " + id + " not found.");
        }
    }

}
