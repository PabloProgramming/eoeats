package com.app.eoeats.exceptionsHandler.exceptions.notFoundExceptions;

public class RestaurantNotFoundException extends RuntimeException {

    private static final String DESCRIPTION = "Restaurant Not Found with id: ";

    public RestaurantNotFoundException(String restaurantId) {
        super(DESCRIPTION + restaurantId);
    }
}
