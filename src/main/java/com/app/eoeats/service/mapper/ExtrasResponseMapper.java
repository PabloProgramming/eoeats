package com.app.eoeats.service.mapper;

import com.app.eoeats.model.Extra;
import com.app.eoeats.model.dto.ExtraResponseDto;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExtrasResponseMapper {
    @SneakyThrows
    public List<ExtraResponseDto> entityListToResponseDtoList(final List<Extra> extras) {
        List<ExtraResponseDto> extrasResponseDtos = new ArrayList<>();
        for (Extra extra : extras) {
            if (extra != null) {
                ExtraResponseDto extraResponseDto = ExtraResponseDto.builder()
                        .id(extra.getId().toString())
                        .name(extra.getName())
                        .price(extra.getPrice())
                        .build();
                extrasResponseDtos.add(extraResponseDto);
            } else throw new Exception();
        }
        return extrasResponseDtos;
    }
}
