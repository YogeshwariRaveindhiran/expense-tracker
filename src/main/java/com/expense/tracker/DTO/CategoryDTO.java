package com.expense.tracker.DTO;

import java.time.LocalDateTime;

public class CategoryDTO
{
    long id;
    LocalDateTime created_date;
    String maincategory;
    String subcategory;

    public CategoryDTO( long id, LocalDateTime created_date, String maincategory, String subcategory) {
        this.id = id;
        this.created_date = created_date;
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
