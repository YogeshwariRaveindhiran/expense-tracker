package com.expense.tracker.DTO;

public class CategoryComparisonDTO {

    private String category;
    private double month1Amount;
    private double month2Amount;
    private double difference;

    public CategoryComparisonDTO(String category, double month1Amount, double month2Amount, double difference) {
        this.category = category;
        this.month1Amount = month1Amount;
        this.month2Amount = month2Amount;
        this.difference = difference;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getMonth1Amount() {
        return month1Amount;
    }

    public void setMonth1Amount(double month1Amount) {
        this.month1Amount = month1Amount;
    }

    public double getMonth2Amount() {
        return month2Amount;
    }

    public void setMonth2Amount(double month2Amount) {
        this.month2Amount = month2Amount;
    }

    public double getDifference() {
        return difference;
    }

    public void setDifference(double difference) {
        this.difference = difference;
    }
}
