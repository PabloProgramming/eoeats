package com.app.eoeats.service.mapper;

import com.app.eoeats.model.Amount;
import com.app.eoeats.model.AmountExtra;
import com.app.eoeats.model.Plate;
import com.app.eoeats.model.dto.AmountDto;
import com.app.eoeats.model.dto.AmountOfPlatesAndExtrasDto;
import com.app.eoeats.service.PlateService;
import com.app.eoeats.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AmountMapper {

    @Autowired
    private Utils utils;

    @Autowired
    private PlateService plateService;

    @Autowired
    private AmountExtraMapper amountExtraMapper;

    @Autowired
    private ExtrasResponseMapper extrasResponseMapper;


    public List<Amount> listDtoToEntity(final List<AmountDto> amountDtos) {
        List<Amount> amounts = new ArrayList<>();
        for (AmountDto amountDto : amountDtos) {
            Amount amount = new Amount();
            amount.setAmount(amountDto.getAmount());
            amount.setDescription(amountDto.getDescription());
            amount.setSubTotalPrice(amountDto.getSubTotalPrice());
            amount.setType(amountDto.getType());
            final Plate plate = plateService.findPlateById(amountDto.getPlateId());
            amount.setPlate(plate);
            List<AmountExtra> amountExtras = amountExtraMapper.dtosToEntities(amountDto.getAmountExtraDtos());
            for (AmountExtra amountExtra : amountExtras) {
                amountExtra.setAmount(amount);
            }
            amount.setAmountExtras(amountExtras);

            amounts.add(amount);
        }
        return amounts;
    }

    public List<AmountOfPlatesAndExtrasDto> listEntityToListDto(final List<Amount> amounts) {
        List<AmountOfPlatesAndExtrasDto> amountOfPlatesAndExtrasDtos = new ArrayList<>();
        for (Amount amount : amounts) {
            AmountOfPlatesAndExtrasDto amountOfPlatesAndExtrasDto = AmountOfPlatesAndExtrasDto.builder()
                    .amountOfPlate(amount.getAmount())
                    .description(amount.getDescription())
                    .name(amount.getPlate().getName())
                    .extraByOrderDtos(extrasResponseMapper.ExtrasToDtos(amount.getPlate().getExtras()))
                    .build();
            amountOfPlatesAndExtrasDtos.add(amountOfPlatesAndExtrasDto);
        }
        return amountOfPlatesAndExtrasDtos;
    }

}
