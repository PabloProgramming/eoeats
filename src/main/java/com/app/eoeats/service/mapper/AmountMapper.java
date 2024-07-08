package com.app.eoeats.service.mapper;

import com.app.eoeats.model.Amount;
import com.app.eoeats.model.Plate;
import com.app.eoeats.model.dto.AmountDto;
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
            amount.setAmountExtras(amountExtraMapper.dtosToEntities(amountDto.getAmountExtraDtos()));
            amounts.add(amount);
        }
        return amounts;
    }


}
