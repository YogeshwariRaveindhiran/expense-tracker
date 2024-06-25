package com.expense.tracker.DTO;

import java.util.Map;

public class ReportDTO {

    public double totalIncome;
    public double totalExpense;
    public double balance;
    public Map<String, Double> categoryBreakdown;
    //No Arg constructor

    public ReportDTO(double totalIncome, double totalExpenses, Map<String, Double> categoryBreakdown){}

    //All arg constructor

    public ReportDTO(double totalIncome, double totalExpense, double balance, Map<String, Double> categoryBreakdown) {
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.balance = balance;
        this.categoryBreakdown = categoryBreakdown;
    }

    //Getter and setter


    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Map<String, Double> getCategoryBreakdown() {
        return categoryBreakdown;
    }

    public void setCategoryBreakdown(Map<String, Double> categoryBreakdown) {
        this.categoryBreakdown = categoryBreakdown;
    }
}
