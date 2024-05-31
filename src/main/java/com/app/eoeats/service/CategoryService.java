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

    @SneakyThrows
    public String deleteCategory(final String categoryId) {
        final Optional<Category> categoryOptional = categoryRepository.findById(UUID.fromString(categoryId));
        if (categoryOptional.isPresent()) {
            categoryRepository.deleteById(UUID.fromString(categoryId));
            return categoryId;

        }
        throw new Exception();
    }

    @SneakyThrows
    public Category findCategoryById(final UUID categoryId) {
        final Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isPresent()) {
            return optionalCategory.get();
        }
        throw new Exception();
    }

}





