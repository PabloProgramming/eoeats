package com.app.eoeats.utils;

import com.app.eoeats.exceptionsHandler.exceptions.badRequestExceptions.UuidBadRequestException;
import org.springframework.stereotype.Service;

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


}
