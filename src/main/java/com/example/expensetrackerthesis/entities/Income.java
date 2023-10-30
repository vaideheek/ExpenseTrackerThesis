package com.example.expensetrackerthesis.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "incomes")
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sourceName") // Match the form field name
    private String sourceName; // Change this field name to match the form

    @Column(name = "category")
    private String category;

    @Column(name = "amount")
    private double amount;

    @Column(name = "incomeDate") // Match the form field name
    private LocalDate incomeDate; // Change this field name to match the form

    public Income() {
    }

    public Income(Long id, String sourceName, String category, double amount, LocalDate incomeDate) {
        this.id = id;
        this.sourceName = sourceName;
        this.category=category;
        this.amount = amount;
        this.incomeDate = incomeDate;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public LocalDate getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(LocalDate incomeDate) {
        this.incomeDate = incomeDate;
    }

    public boolean isValid() {
        // Check if description is not empty and amount is a valid numerical value
        return this.amount >= 0 && this.incomeDate != null && this.sourceName != null && !this.sourceName.isEmpty();
    }


    public double calculateYearlyIncome() {
        return this.amount * 12;
    }
}
