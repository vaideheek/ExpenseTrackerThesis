package com.example.expensetrackerthesis.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "expense_categories")
public class ExpenseCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category")
    private List<Expense> expenses;

    public ExpenseCategory() {
    }

    public ExpenseCategory(Long id, String name, List<Expense> expenses) {
        this.id = id;
        this.name = name;
        this.expenses = expenses;
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

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public void addExpense(Expense expense) {
        this.expenses.add(expense);
        expense.setCategory(this);
    }

    public void removeExpense(Expense expense) {
        this.expenses.remove(expense);
        expense.setCategory(null);
    }

    public double getTotalExpenses() {
        return expenses.stream().mapToDouble(Expense::getAmount).sum();
    }

    public boolean isEmpty() {
        return expenses.isEmpty();
    }

    public boolean isValidCategory() {
        return this.name != null && !this.name.isEmpty() && !expenses.isEmpty();
    }

    public List<Expense> getExpensesInDateRange(LocalDate startDate, LocalDate endDate) {
        return expenses.stream()
                .filter(expense -> expense.getDate().isAfter(startDate) && expense.getDate().isBefore(endDate))
                .collect(Collectors.toList());
    }
}
