package com.app.eoeats.service.mapper;

import com.app.eoeats.model.Extra;
import com.app.eoeats.model.dto.ExtraByOrderDto;
import com.app.eoeats.model.dto.ExtraResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExtrasResponseMapper {

    public List<ExtraResponseDto> entityListToResponseDtoList(final List<Extra> extras) {
        List<ExtraResponseDto> extrasResponseDtos = new ArrayList<>();
        for (Extra extra : extras) {
            ExtraResponseDto extraResponseDto = ExtraResponseDto.builder()
                    .id(extra.getId().toString())
                    .name(extra.getName())
                    .price(extra.getPrice())
                    .build();
            extrasResponseDtos.add(extraResponseDto);
        }
        return extrasResponseDtos;
    }

    List<ExtraByOrderDto> ExtrasToDtos(final List<Extra> extras) {
        List<ExtraByOrderDto> extraByOrderDtos = new ArrayList<>();
        for (Extra extra : extras) {
            ExtraByOrderDto extraByOrderDto = ExtraByOrderDto.builder()
                    .name(extra.getName())
                    .build();
            extraByOrderDtos.add(extraByOrderDto);
        }
        return extraByOrderDtos;
    }
}
