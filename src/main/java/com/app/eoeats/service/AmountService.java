package com.app.eoeats.service;

import com.app.eoeats.model.Amount;
import com.app.eoeats.model.dto.AmountOfPlatesAndExtrasDto;
import com.app.eoeats.repository.AmountRepository;
import com.app.eoeats.service.mapper.AmountMapper;
import com.app.eoeats.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmountService {

    @Autowired
    private AmountRepository amountRepository;

    @Autowired
    private AmountMapper amountMapper;

    @Autowired
    private Utils utils;

    public List<AmountOfPlatesAndExtrasDto> getPlatesAndExtrasByOrder(final String orderId) {
        final List<Amount> amounts = amountRepository.getAmountsByOrderId(utils.stringToUuid(orderId));
        return amountMapper.listEntityToListDto(amounts);
    }
}


