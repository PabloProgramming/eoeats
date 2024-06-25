package com.app.eoeats.service;

import com.app.eoeats.exceptionsHandler.exceptions.notFoundExceptions.CategoryNotFoundException;
import com.app.eoeats.model.Category;
import com.app.eoeats.model.dto.CategoryDto;
import com.app.eoeats.model.dto.CategoryPlatesResponseDto;
import com.app.eoeats.repository.CategoryRepository;
import com.app.eoeats.service.mapper.CategoryMapper;
import com.app.eoeats.utils.Utils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private Utils utils;


    public CategoryDto saveCategory(final CategoryDto categoryDto) {
        final Category category = categoryMapper.requestDtoToEntity(categoryDto);
        final Category savedCategory = categoryRepository.save(category);
        return categoryMapper.entityToDto(savedCategory);
    }

    @SneakyThrows
    public String deleteCategory(final String categoryId) {
        final Optional<Category> categoryOptional = categoryRepository.findById(utils.stringToUuid(categoryId));
        if (categoryOptional.isPresent()) {
            categoryRepository.deleteById(UUID.fromString(categoryId));
            return categoryId;

        }
        throw new CategoryNotFoundException(categoryId);
    }

    @SneakyThrows
    public Category findCategoryById(final String categoryId) {
        final Optional<Category> optionalCategory = categoryRepository.findById(utils.stringToUuid(categoryId));
        if (optionalCategory.isPresent()) {
            return optionalCategory.get();
        }
        throw new CategoryNotFoundException(categoryId);
    }

    public CategoryPlatesResponseDto getCategoryWithPlatesInfo(final String categoryId) {
        Category category = findCategoryById(categoryId);
        return categoryMapper.entityToResponseDto(category);

    }

}






