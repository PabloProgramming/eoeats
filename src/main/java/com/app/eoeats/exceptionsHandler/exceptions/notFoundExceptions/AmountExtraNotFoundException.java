package com.app.eoeats.exceptionsHandler.exceptions.notFoundExceptions;

public class AmountExtraNotFoundException extends RuntimeException {

    private static final String DESCRIPTION = "AmountExtra Not Found with id: ";

    public AmountExtraNotFoundException(String amountExtraId) {
        super(DESCRIPTION + amountExtraId);
    }
}
