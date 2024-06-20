package com.expense.tracker.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="Transaction")
@Access(value = AccessType.FIELD)

public class TransactionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "created_date", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    LocalDateTime created_date;


    String description;
    double amount;
    String paidby;
    String maincategory;
    String subcategory;
    LocalDate transactionOn;


    //No Arg constructor
    public TransactionModel(){

    }

    //All arg constructor


    public TransactionModel(Long id, LocalDateTime created_date, String description, double amount, String paidby, String maincategory, String subcategory, LocalDate transactionOn) {
        this.id = id;
        this.created_date = created_date;
        this.description = description;
        this.amount = amount;
        this.paidby = paidby;
        this.maincategory = maincategory;
        this.subcategory = subcategory;
        this.transactionOn = transactionOn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
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

    public LocalDate getTransactionOn() {
        return transactionOn;
    }

    public void setTransactionOn(LocalDate transactionOn) {
        this.transactionOn = transactionOn;
    }
}
