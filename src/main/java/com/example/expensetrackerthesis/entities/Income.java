package com.example.expensetrackerthesis.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "incomes")
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private double amount;
    private LocalDate date;

    public Income() {
    }

    public Income(Long id, String description, double amount, LocalDate date) {
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
        // Check if description is not empty and amount is a valid numerical value
        return this.amount >= 0 && this.date != null && this.description != null && !this.description.isEmpty();
    }


    public double calculateYearlyIncome() {
        // Calculate the yearly income by multiplying the monthly income by 12
        return this.amount * 12;
    }
}
