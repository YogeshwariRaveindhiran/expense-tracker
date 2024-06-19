package com.expense.tracker.DTO;

import java.time.LocalDateTime;

public class TransactionDTO {

    long id;
    LocalDateTime created_date;
    int transaction_date;
    String description;
    double amount;
    String paidby;
    String maincategory;
    String subcategory;

    public TransactionDTO(long id, LocalDateTime created_date, int transaction_date, String description, double amount, String paidby, String maincategory, String subcategory) {
        this.id = id;
        this.created_date = created_date;
        this.transaction_date = transaction_date;
        this.description = description;
        this.amount = amount;
        this.paidby = paidby;
        this.maincategory = maincategory;
        this.subcategory = subcategory;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }

    public int getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(int transaction_date) {
        this.transaction_date = transaction_date;
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

    public String getPaidby() {
        return paidby;
    }

    public void setPaidby(String paidby) {
        this.paidby = paidby;
    }

    public String getMaincategory() {
        return maincategory;
    }

    public void setMaincategory(String maincategory) {
        this.maincategory = maincategory;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }
}
