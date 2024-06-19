package com.expense.tracker.Mapper;

import com.expense.tracker.DTO.CategoryDTO;
import com.expense.tracker.Model.CategoryModel;

public class CategoryMapper {
    //the below function is used to change the rest api data to entity(database) for ResponseBody
    public static CategoryDTO mapToCategoryDTO(CategoryModel categoryModel){
        return new CategoryDTO(categoryModel.getId(), categoryModel.getCreated_date(), categoryModel.getMaincategory(), categoryModel.getSubcategory());
    }

    //the below function is used to convert the entity(database) to rest api data
    public static CategoryModel mapToCategoryModel(CategoryDTO categoryDTO){
        return new CategoryModel(categoryDTO.getId(), categoryDTO.getCreated_date(), categoryDTO.getMaincategory(), categoryDTO.getSubcategory());
    }
}
