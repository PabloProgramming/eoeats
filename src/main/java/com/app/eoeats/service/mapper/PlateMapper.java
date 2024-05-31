package com.app.eoeats.service.mapper;

import com.app.eoeats.model.Allergen;
import com.app.eoeats.model.Category;
import com.app.eoeats.model.Plate;
import com.app.eoeats.model.dto.PlateDto;
import com.app.eoeats.model.dto.PlateResponseDto;
import com.app.eoeats.service.AllergenService;
import com.app.eoeats.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlateMapper {


    @Autowired
    CategoryService categoryService;

    @Autowired
    AllergenService allergenService;

    @Autowired
    AllergenMapper allergenMapper;


    public Plate requestDtoToEntity(final PlateDto plateDto) {
        Plate plate = new Plate();
        if (plateDto.getId() != null) {
            plate.setId(UUID.fromString(plateDto.getId()));
        }
        plate.setType(plateDto.getType());
        plate.setName(plateDto.getName());
        plate.setPrice(plateDto.getPrice());
        Category category = categoryService.findCategoryById(UUID.fromString(plateDto.getCategoryId()));
        plate.setCategory(category);
        List<Allergen> allergens = allergenService.findAllergensById(plateDto.getAllergens());
        plate.setAllergens(allergens);
        plate.setAvailable(plateDto.isAvailable());
        plate.setKitchenPrinter(plateDto.isKitchenPrinter());

        return plate;
    }

    public PlateResponseDto entityToDto(final Plate plate) {
        return PlateResponseDto.builder()
                .id(plate.getId().toString())
                .type(plate.getType())
                .name(plate.getName())
                .price(plate.getPrice())
                .categoryId(plate.getCategory().getId().toString())
                .allergensList(allergenMapper.entityToDto(plate.getAllergens()))
                .isAvailable(plate.isAvailable())
                .isKitchenPrinter(plate.isKitchenPrinter())
                .build();
    }


}
