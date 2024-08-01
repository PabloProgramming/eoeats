package com.app.eoeats.service;

import com.app.eoeats.model.Amount;
import com.app.eoeats.model.dto.AmountAndExtraResponseDto;
import com.app.eoeats.model.dto.AmountOfPlatesAndExtrasDto;
import com.app.eoeats.repository.AmountRepository;
import com.app.eoeats.service.mapper.AmountMapper;
import com.app.eoeats.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AmountService {

    @Autowired
    private AmountRepository amountRepository;

    @Autowired
    private AmountExtraService amountExtraService;

    @Autowired
    private AmountMapper amountMapper;

    @Autowired
    private Utils utils;

    public List<String> deleteAmountsByOrderId(String orderId) {
        List<Amount> amounts = amountRepository.getAmountsByOrderId(utils.stringToUuid(orderId));
        List<String> amountIds = new ArrayList<>();
        for (Amount amount : amounts) {
            String amountId = amount.getId().toString();
            amountIds.add(amountId);
            amountExtraService.deleteAmountsExtraByAmountId(amountId);
        }
        return amountIds;
    }

    public List<AmountOfPlatesAndExtrasDto> getPlatesAndExtrasByOrder(final String orderId) {
        final List<Amount> amounts = amountRepository.getAmountsByOrderId(utils.stringToUuid(orderId));
        return amountMapper.listEntityToListDto(amounts);
    }

    public List<AmountAndExtraResponseDto> getAmountAndExtrasByTableNumber(final int tableNumber) {
        final List<Amount> amounts = amountRepository.getAmountsByOrderTableNumber(tableNumber);
        return amountMapper.listEntityToListResponseDto(amounts);

    }
}


