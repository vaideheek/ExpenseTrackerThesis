package com.example.expensetrackerthesis.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "budgets")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    private LocalDate startDate;
    private LocalDate endDate;

    public Budget() {

    }

    public Budget(Long id, double amount, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isValid() {
        // check amount is non-negative and start and end dates are valid
        return this.amount >= 0 && this.startDate != null && this.endDate != null && this.startDate.isBefore(this.endDate);
    }


    public double calculateRemainingBudget(double totalExpenses) {
        // calculate remaining budget by subtracting total expenses from the initial amount
        return Math.max(0, this.amount - totalExpenses);  // check remaining budget is non-negative
    }


    public boolean isExpired() {
        // check if the budget end date is before or equal to the current date
        LocalDate currentDate = LocalDate.now();
        return this.endDate.isBefore(currentDate) || this.endDate.isEqual(currentDate);
    }

}
