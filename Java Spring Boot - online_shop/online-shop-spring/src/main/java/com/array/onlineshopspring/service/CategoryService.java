package com.array.onlineshopspring.service;

import com.array.onlineshopspring.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO addCategory(CategoryDTO categoryDTO);
    List<CategoryDTO> getAllCategories();
    CategoryDTO getCategoryById(Integer categoryId);
    CategoryDTO updateCategory(CategoryDTO category, Integer categoryId);
    void deleteCategory(Integer categoryId);
    //    List<Category> searchCategories(String keyword);
}
