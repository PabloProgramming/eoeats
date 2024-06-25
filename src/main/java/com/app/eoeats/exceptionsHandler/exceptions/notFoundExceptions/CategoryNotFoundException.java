package com.app.eoeats.exceptionsHandler.exceptions.notFoundExceptions;

public class CategoryNotFoundException extends RuntimeException {

    private static final String DESCRIPTION = "Category Not Found with id: ";

    public CategoryNotFoundException(String categoryId) {
        super(DESCRIPTION + categoryId);
    }
}
