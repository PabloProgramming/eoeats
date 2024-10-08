package com.app.eoeats.service.mapper;

import com.app.eoeats.model.Plate;
import com.app.eoeats.model.dto.PlateByCategoryResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatesResponseMapper {

    public List<PlateByCategoryResponseDto> platesToPlatesDto(final List<Plate> plates) {
        List<PlateByCategoryResponseDto> platesResponseDtos = new ArrayList<>();
        for (Plate plate : plates) {
            PlateByCategoryResponseDto plateResponseDto = PlateByCategoryResponseDto.builder()
                    .id(plate.getId().toString())
                    .type(plate.getType())
                    .name(plate.getName())
                    .image(plate.getImage())
                    .isAvailable(plate.isAvailable())
                    .build();
            platesResponseDtos.add(plateResponseDto);
        }
        return platesResponseDtos;
    }
}
