package com.app.eoeats.service;

import com.app.eoeats.exceptionsHandler.exceptions.notFoundExceptions.AmountExtraNotFoundException;
import com.app.eoeats.model.AmountExtra;
import com.app.eoeats.repository.AmountExtraRepository;
import com.app.eoeats.utils.Utils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AmountExtraService {

    @Autowired
    private AmountExtraRepository amountExtraRepository;

    @Autowired
    private Utils utils;

    public List<String> deleteAmountsExtraByAmountId(String amountId) {
        final List<AmountExtra> amountExtras = amountExtraRepository.getAmountsExtraByAmountId(utils.stringToUuid(amountId));
        List<String> amountExtraIds = new ArrayList<>();
        for (AmountExtra amountExtra : amountExtras) {
            String amountExtraId = amountExtra.getId().toString();
            amountExtraIds.add(amountId);
        }
        return amountExtraIds;
    }

    @SneakyThrows
    public String deleteAmountExtraFromOrder(String amountExtraId) {
        final Optional<AmountExtra> optionalAmountExtra = amountExtraRepository.findById(utils.stringToUuid(amountExtraId));
        if (optionalAmountExtra.isPresent()) {
            AmountExtra amountExtra = optionalAmountExtra.get();
            amountExtraRepository.delete(amountExtra);
            return amountExtraId;
        }
        throw new AmountExtraNotFoundException(amountExtraId);
    }

}


