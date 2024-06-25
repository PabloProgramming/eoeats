package com.app.eoeats.exceptionsHandler.exceptions.badRequestExceptions;

public class BadRequestException extends RuntimeException {

    private static final String DESCRIPTION = "Format cannot be transformed to UUID: ";

    public BadRequestException(String id) {
        super(DESCRIPTION + id);
    }
}
