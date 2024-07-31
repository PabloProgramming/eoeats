package com.app.eoeats.utils;

import com.app.eoeats.exceptionsHandler.exceptions.badRequestExceptions.UuidBadRequestException;
import com.app.eoeats.model.Amount;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class Utils {

    public UUID stringToUuid(String id) {
        try {
            return UUID.fromString(id);
        } catch (Exception e) {
            throw new UuidBadRequestException(id);
        }
    }

    public int getAmountOfPlates(final List<Amount> amounts) {
        int total = 0;
        for (Amount amount : amounts) {
            total = total + amount.getAmount();
        }
        return total;
    }
    
}
