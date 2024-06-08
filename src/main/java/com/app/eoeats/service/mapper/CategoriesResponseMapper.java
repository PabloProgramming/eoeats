package com.app.eoeats.service.mapper;

import com.app.eoeats.model.Category;
import com.app.eoeats.model.dto.CategoryResponseDto;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoriesResponseMapper {

    @SneakyThrows
    public List<CategoryResponseDto> listEntityToListResponseDto(List<Category> categories) {
        List<CategoryResponseDto> categoryResponseDtoList = new ArrayList<>();
        for (Category category : categories) {
            if (category != null) {
                CategoryResponseDto categoryResponseDto = CategoryResponseDto.builder()
                        .id(category.getId().toString())
                        .name(category.getName())
                        .image(category.getImage())
                        .build();
                categoryResponseDtoList.add(categoryResponseDto);
            }else
                throw new Exception();
        }
        return categoryResponseDtoList;
    }
}
