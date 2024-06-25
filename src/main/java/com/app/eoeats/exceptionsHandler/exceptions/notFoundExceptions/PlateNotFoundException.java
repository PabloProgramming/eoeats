package com.app.eoeats.exceptionsHandler.exceptions.notFoundExceptions;

public class PlateNotFoundException extends RuntimeException {

    private static final String DESCRIPTION = "Plate Not Found with id: ";

    public PlateNotFoundException(String plateId) {
        super(DESCRIPTION + plateId);
    }
}
