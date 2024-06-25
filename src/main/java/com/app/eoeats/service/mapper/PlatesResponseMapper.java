package com.app.eoeats.service.mapper;

import com.app.eoeats.model.Plate;
import com.app.eoeats.model.dto.PlateByCategoryResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatesResponseMapper {
    public List<PlateByCategoryResponseDto> platesToPlatesDto(final List<Plate> plates) {
        List<PlateByCategoryResponseDto> platesResponseDto = new ArrayList<>();
        for (Plate plate : plates) {
            PlateByCategoryResponseDto plateResponseDto = PlateByCategoryResponseDto.builder()
                    .id(plate.getId().toString())
                    .type(plate.getType())
                    .name(plate.getName())
                    .isAvailable(plate.isAvailable())
                    .build();
            platesResponseDto.add(plateResponseDto);
        }
        return platesResponseDto;
    }
}
