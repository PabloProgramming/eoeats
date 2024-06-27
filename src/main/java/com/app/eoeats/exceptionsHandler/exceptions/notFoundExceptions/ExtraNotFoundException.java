package com.app.eoeats.exceptionsHandler.exceptions.notFoundExceptions;

public class ExtraNotFoundException extends RuntimeException {

    private static final String DESCRIPTION = "Extra Not Found with id: ";

    public ExtraNotFoundException(String extraId) {
        super(DESCRIPTION + extraId);
    }
}
