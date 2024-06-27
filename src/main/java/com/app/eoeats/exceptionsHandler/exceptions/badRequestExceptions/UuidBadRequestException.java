package com.app.eoeats.exceptionsHandler.exceptions.badRequestExceptions;

public class UuidBadRequestException extends RuntimeException {

    private static final String DESCRIPTION = "Format cannot be transformed to UUID: ";

    public UuidBadRequestException(String id) {
        super(DESCRIPTION + id);
    }
}
