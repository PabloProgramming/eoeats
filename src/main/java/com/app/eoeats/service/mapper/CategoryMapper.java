package com.app.eoeats.service.mapper;

import com.app.eoeats.model.Category;
import com.app.eoeats.model.Restaurant;
import com.app.eoeats.model.dto.CategoryDto;
import com.app.eoeats.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CategoryMapper {


    @Autowired
    RestaurantService restaurantService;


    public Category requestDtoToEntity(final CategoryDto categoryDto){
        Category category = new Category();
        if(categoryDto.getId() != null){
            category.setId(UUID.fromString(categoryDto.getId()));
        }
        category.setImage(categoryDto.getImage());
        category.setName(categoryDto.getName());
        final Restaurant restaurant = restaurantService.findRestaurantById(UUID.fromString(categoryDto.getRestaurantId()));
        category.setRestaurant(restaurant);
        return category;
    }

    public CategoryDto entityToDto(final Category category){
        return CategoryDto.builder()
                .id(category.getId().toString())
                .image(category.getImage())
                .name(category.getName())
                .restaurantId(category.getRestaurant().getId().toString())
                .build();
    }
}
