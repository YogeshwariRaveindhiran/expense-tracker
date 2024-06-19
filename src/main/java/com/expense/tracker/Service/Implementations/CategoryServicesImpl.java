package com.expense.tracker.Service.Implementations;

import com.expense.tracker.DTO.CategoryDTO;
import com.expense.tracker.Exception.ResourceNotFound;
import com.expense.tracker.Mapper.CategoryMapper;
import com.expense.tracker.Model.CategoryModel;
import com.expense.tracker.Repository.CategoryRepository;
import com.expense.tracker.Service.Interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServicesImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public CategoryServicesImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    //create transaction data into database
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        CategoryModel categoryModel= CategoryMapper.mapToCategoryModel(categoryDTO);
        CategoryModel savedCategory;
        savedCategory = categoryRepository.save(categoryModel);
        return CategoryMapper.mapToCategoryDTO(savedCategory);
    }

    //getAll the category
    public List<CategoryDTO> getAllCategory(){
        List<CategoryModel> categoryModel = categoryRepository.findAll();
        return categoryModel.stream().map((categoryModels) -> CategoryMapper.mapToCategoryDTO((categoryModels)))
                .collect(Collectors.toList());
    }

    //get Category by ID

    @Override
    public CategoryDTO getCategoryById(Long id) {
        CategoryModel categoryModel = categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFound("Category is not exist by the given id"+id));
        return CategoryMapper.mapToCategoryDTO(categoryModel);
    }

    //update the category
    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO updatedCategory) {
        CategoryModel categoryModel = categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFound("The transaction is not exist"+id));

        categoryModel.setMaincategory(updatedCategory.getMaincategory());
        categoryModel.setSubcategory(updatedCategory.getSubcategory());

        CategoryModel updateCategoryValue = categoryRepository.save(categoryModel);
        return CategoryMapper.mapToCategoryDTO(updateCategoryValue);
    }
    //delete by id
    @Override
    public void deleteCategory(Long id) {
        CategoryModel categoryModel = categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFound("The transaction is not exist"+id));
        categoryRepository.deleteById(id);

    }



    //delete all




}
