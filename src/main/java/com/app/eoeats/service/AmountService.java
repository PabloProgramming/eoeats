package com.app.eoeats.service;

import com.app.eoeats.exceptionsHandler.exceptions.notFoundExceptions.AmountNotFoundException;
import com.app.eoeats.model.Amount;
import com.app.eoeats.model.dto.AmountOfPlatesAndExtrasDto;
import com.app.eoeats.repository.AmountRepository;
import com.app.eoeats.service.mapper.AmountMapper;
import com.app.eoeats.utils.Utils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        final List<Amount> amounts = amountRepository.getAmountsByOrderId(utils.stringToUuid(orderId));
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

    @SneakyThrows
    public String deleteAmountFromOrder(String amountId) {
        final Optional<Amount> amountOptional = amountRepository.findById(utils.stringToUuid(amountId));
        if (amountOptional.isPresent()) {
            Amount amount = amountOptional.get();
            amountRepository.delete(amount);
            return amountId;
        }
        throw new AmountNotFoundException(amountId);
    }
}


