package com.app.eoeats.service.mapper;

import com.app.eoeats.model.Category;
import com.app.eoeats.model.Plate;
import com.app.eoeats.model.dto.PlateDto;
import com.app.eoeats.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PlateMapper {


    @Autowired
    CategoryService categoryService;


    public Plate requestDtoToEntity(final PlateDto plateDto){
        Plate plate = new Plate();
        if (plateDto.getId() != null){
            plate.setId(UUID.fromString(plateDto.getId()));
        }
        plate.setType(plateDto.getType());
        plate.setName(plateDto.getName());
        plate.setPrice(plateDto.getPrice());
        Category category = categoryService.findCategoryById(UUID.fromString(plateDto.getCategoryId()));
        plate.setCategory(category);

        plate.setAllergens(allergensOptional.get());
        return plate;
    }

    public PlateDto entityToDto(final Plate plate){
        return PlateDto.builder()
                .id(plate.getId().toString())
                .type(plate.getType())
                .name(plate.getName())
                .price(plate.getPrice())
                .build();
    }






}
