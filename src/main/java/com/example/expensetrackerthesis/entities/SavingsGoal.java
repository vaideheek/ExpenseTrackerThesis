package com.example.expensetrackerthesis.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class SavingsGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;            // Goal name (e.g., Emergency Fund)
    private double targetAmount;    // Target savings amount
    private LocalDate deadline;     // Target deadline
    private double currentAmount;   // Current amount saved


    @OneToMany(mappedBy = "savingsGoal")  // This should match the field name in the Savings entity
    private List<Savings> associatedSavings;

    public SavingsGoal() {
    }

    public SavingsGoal(Long id, String name, double targetAmount, LocalDate deadline, double currentAmount, List<Savings> associatedSavings) {
        this.id = id;
        this.name = name;
        this.targetAmount = targetAmount;
        this.deadline = deadline;
        this.currentAmount = currentAmount;
        this.associatedSavings = associatedSavings;
    }

    public List<Savings> getAssociatedSavings() {
        return associatedSavings;
    }
    public void setAssociatedSavings(List<Savings> associatedSavings) {
        this.associatedSavings = associatedSavings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(double targetAmount) {
        this.targetAmount = targetAmount;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(double currentAmount) {
        this.currentAmount = currentAmount;
    }
}
