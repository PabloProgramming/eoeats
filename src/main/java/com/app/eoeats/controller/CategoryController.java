package com.app.eoeats.controller;

import com.app.eoeats.model.dto.CategoryDto;
import com.app.eoeats.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping
    private ResponseEntity<CategoryDto> saveCategory(@RequestBody final CategoryDto categoryDto){
        return ResponseEntity.ok(categoryService.saveCategory(categoryDto));
    }

    @PutMapping
    private ResponseEntity<CategoryDto> updateCategory(@RequestBody final CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryService.updateCategory(categoryDto));

    }

    @DeleteMapping ("/{categoryId}")
    private ResponseEntity<CategoryDto> deleteCategory(@PathVariable final UUID categoryId){
        return ResponseEntity.ok(categoryService.deleteCategory(categoryId));
    }
}
