package com.app.eoeats.exceptionsHandler.exceptions.notFoundExceptions;

public class OrderNotFoundException extends RuntimeException {

    private static final String DESCRIPTION = "Order Not Found with id: ";

    public OrderNotFoundException(String orderId) {
        super(DESCRIPTION + orderId);
    }
}
