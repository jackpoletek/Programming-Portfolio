package com.array.onlineshopspring.service.serviceimpl;

import com.array.onlineshopspring.dto.CategoryDTO;
import com.array.onlineshopspring.exception.ResourceNotFoundException;
import com.array.onlineshopspring.model.Category;
import com.array.onlineshopspring.repository.CategoryRepository;
import com.array.onlineshopspring.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {

        Category category = Category.builder()
                .categoryDescription(categoryDTO.getCategoryDescription())
                .build();

        categoryRepository.save(category);

        return modelMapper.map(category, CategoryDTO.class);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> allCategories = categoryRepository.findAll();

        List<CategoryDTO> categories = allCategories.stream()
                .map(it -> modelMapper.map(it, CategoryDTO.class)).toList();

        return categories;
    
    @Override
    public CategoryDTO getCategoryById(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category", "id", categoryId));

        return modelMapper.map(category, CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

        category.setCategoryDescription(categoryDTO.getCategoryDescription());
        Category updatedCategory = categoryRepository.save(category);

        return modelMapper.map(updatedCategory, CategoryDTO.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
        categoryRepository.delete(category);
    }
}
