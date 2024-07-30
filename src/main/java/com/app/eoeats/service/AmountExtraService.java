package com.app.eoeats.service;

import com.app.eoeats.model.AmountExtra;
import com.app.eoeats.repository.AmountExtraRepository;
import com.app.eoeats.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AmountExtraService {

    @Autowired
    private AmountExtraRepository amountExtraRepository;

    @Autowired
    private Utils utils;

    public List<String> deleteAmountsExtraByAmountId(String amountId) {
        List<AmountExtra> amountExtras = amountExtraRepository.getAmountsExtraByAmountId(utils.stringToUuid(amountId));
        List<String> amountExtraIds = new ArrayList<>();
        for (AmountExtra amountExtra : amountExtras) {
            String amountExtraId = amountExtra.getId().toString();
            amountExtraIds.add(amountId);
        }
        return amountExtraIds;
    }

}


