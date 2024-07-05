package com.expense.tracker.Model;

import java.util.Map;

public class ReportModel {
    public double totalIncome;
    public double totalExpense;
    public double balance;
    public Map<String, Double> categoryBreakdown;

    //No arg constructor

    public ReportModel(){}

    //All arg constructor

    public ReportModel(double totalIncome, double totalExpense, double balance, Map<String, Double> categoryBreakdown) {
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.balance = balance;
        this.categoryBreakdown = categoryBreakdown;
    }


    //getter and setter


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
