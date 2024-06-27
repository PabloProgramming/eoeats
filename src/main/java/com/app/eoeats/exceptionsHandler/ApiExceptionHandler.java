package com.app.eoeats.exceptionsHandler;

import com.app.eoeats.exceptionsHandler.exceptions.badRequestExceptions.UuidBadRequestException;
import com.app.eoeats.exceptionsHandler.exceptions.notFoundExceptions.ExtraNotFoundException;
import com.app.eoeats.exceptionsHandler.exceptions.notFoundExceptions.PlateNotFoundException;
import com.app.eoeats.exceptionsHandler.exceptions.notFoundExceptions.RestaurantNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({PlateNotFoundException.class, RestaurantNotFoundException.class, ExtraNotFoundException.class})
    @ResponseBody
    public ErrorMessage notFoundRequest(HttpServletRequest request, Exception exception) {
        return new ErrorMessage(exception, request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({UuidBadRequestException.class})
    @ResponseBody
    public ErrorMessage badRequest(HttpServletRequest request, Exception exception) {
        return new ErrorMessage(exception, request.getRequestURI());


    }
}
