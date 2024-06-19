package com.expense.tracker.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name="category_table")
@Access(value = AccessType.FIELD)

public class CategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "created_date", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    LocalDateTime created_date;
    String maincategory;
    String subcategory;

    //No Argument Constructor
    public CategoryModel(){

    }
    //All Argument Constructor


    public CategoryModel(Long id, LocalDateTime createdDate, String maincategory, String subcategory) {
        this.id = id;
        this.created_date = LocalDateTime.now();;
        this.maincategory = maincategory;
        this.subcategory = subcategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }


}
