package com.app.eoeats.service.mapper;

import com.app.eoeats.model.Category;
import com.app.eoeats.model.Restaurant;
import com.app.eoeats.model.dto.CategoryDto;
import com.app.eoeats.model.dto.CategoryPlatesResponseDto;
import com.app.eoeats.service.RestaurantService;
import com.app.eoeats.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {


    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private PlatesResponseMapper platesResponseMapper;

    @Autowired
    private Utils utils;


    public Category requestDtoToEntity(final CategoryDto categoryDto) {
        Category category = new Category();
        if (categoryDto.getId() != null) {
            category.setId(utils.stringToUuid(categoryDto.getId()));
        }
        category.setImage(categoryDto.getImage());
        category.setImageId(categoryDto.getImageId());
        category.setName(categoryDto.getName());
        final Restaurant restaurant = restaurantService.findRestaurantById(categoryDto.getRestaurantId());
        category.setRestaurant(restaurant);
        return category;
    }

    public CategoryDto entityToDto(final Category category) {
        return CategoryDto.builder()
                .id(category.getId().toString())
                .image(category.getImage())
                .imageId(category.getImageId())
                .name(category.getName())
                .restaurantId(category.getRestaurant().getId().toString())
                .build();
    }

    public CategoryPlatesResponseDto entityToResponseDto(final Category category) {
        return CategoryPlatesResponseDto.builder()
                .id(category.getId().toString())
                .image(category.getImage())
                .name(category.getName())
                .platesByCategory(platesResponseMapper.platesToPlatesDto(category.getPlates()))
                .build();
    }
}
