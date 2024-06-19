package com.expense.tracker.Service.Interfaces;

import com.expense.tracker.DTO.CategoryDTO;

import java.util.List;

public interface CategoryService{

      public CategoryDTO createCategory(CategoryDTO categoryDTO);
      //getAll the data in the transaction database
      public List<CategoryDTO> getAllCategory();
      public CategoryDTO getCategoryById(Long id);
      public CategoryDTO updateCategory(Long id, CategoryDTO updatedCategory);    //update Transaction
      public void deleteCategory(Long id);



}
