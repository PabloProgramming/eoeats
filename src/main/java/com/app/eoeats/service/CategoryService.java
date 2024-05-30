package com.app.eoeats.service;

import com.app.eoeats.model.Category;
import com.app.eoeats.model.dto.CategoryDto;
import com.app.eoeats.repository.CategoryRepository;
import com.app.eoeats.service.mapper.CategoryMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryMapper categoryMapper;


    public CategoryDto saveCategory(final CategoryDto categoryDto) {

        final Category category = categoryMapper.requestDtoToEntity(categoryDto);
        final Category savedCategory = categoryRepository.save(category);
        return categoryMapper.entityToDto(savedCategory);
    }

    public CategoryDto updateCategory(final CategoryDto categoryDto) {
        final Category category = categoryMapper.requestDtoToEntity(categoryDto);
        final Category updatedCategory = categoryRepository.save(category);
        return categoryMapper.entityToDto(updatedCategory);
    }

    @SneakyThrows
    public CategoryDto deleteCategory(UUID categoryID) {
        final Optional<Category> categoryOptional = categoryRepository.findById(categoryID);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            categoryRepository.delete(category);
            return categoryMapper.entityToDto(category);

        }
        throw new Exception();
    }

    @SneakyThrows
    public Category findCategoryById(UUID categoryId) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isPresent()) {
            return optionalCategory.get();
        }
        throw new Exception();
    }

}





