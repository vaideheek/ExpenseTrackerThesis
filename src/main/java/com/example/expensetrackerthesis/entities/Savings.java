package com.example.expensetrackerthesis.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "savings")
public class Savings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private double amount;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "savings_goal_id")  // This matches the column name in the database
    private SavingsGoal savingsGoal;

    public Savings() {

    }

    public Savings(Long id, String description, double amount, LocalDate date) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isValid() {
        return this.amount >= 0 && this.date != null;
    }


    public void deposit(double amount) {
        if (amount > 0) {
            // Add the specified amount to the savings
            this.amount += amount;
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }


    public void withdraw(double amount) {
        if (amount > 0) {
            // Check if there are sufficient funds
            if (this.amount >= amount) {
                this.amount -= amount;
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void updateCurrentAmountSaved(SavingsGoal goal) {
        List<Savings> associatedSavings = goal.getAssociatedSavings();
        double totalSavedAmount = 0.0;
        for (Savings savings : associatedSavings) {
            totalSavedAmount += savings.getAmount(); // Use the 'amount' field
        }
        goal.setCurrentAmount(totalSavedAmount);
    }



}

