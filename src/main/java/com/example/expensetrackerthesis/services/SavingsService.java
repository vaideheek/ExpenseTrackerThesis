package com.example.expensetrackerthesis.services;


import com.example.expensetrackerthesis.entities.Savings;
import com.example.expensetrackerthesis.repositories.SavingsRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SavingsService {

    private final SavingsRepository savingsRepository;

    public SavingsService(SavingsRepository savingsRepository) {
        this.savingsRepository = savingsRepository;
    }

    public List<Savings> getAllSavings() {
        return savingsRepository.findAll();
    }

    public Optional<Savings> getSavingsById(Long id) {
        return savingsRepository.findById(id);
    }

    public void addSavings(Savings savings) {
        savingsRepository.save(savings);
    }

    public void updateSavings(Savings savings) {
        savingsRepository.save(savings);
    }

    public void deleteSavings(Long id) {
        savingsRepository.deleteById(id);
    }
}
