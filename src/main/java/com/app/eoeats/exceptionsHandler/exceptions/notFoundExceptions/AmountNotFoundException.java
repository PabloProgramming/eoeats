package com.app.eoeats.exceptionsHandler.exceptions.notFoundExceptions;

public class AmountNotFoundException extends RuntimeException {

    private static final String DESCRIPTION = "Amount Not Found with id: ";

    public AmountNotFoundException(String amountId) {
        super(DESCRIPTION + amountId);
    }
}
