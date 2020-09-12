package com.store.controllers.handlers;

import com.store.exceptions.NotFoundException;
import com.store.exceptions.UnprocessableEntityException;
import com.store.models.responses.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * This class is responsible for capturing all the listed exceptions that may occur anywhere within this service
 * and prepare them to a proper and respective HTTP response.
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity notFoundExceptionHandler(NotFoundException e) {
        return new ResponseEntity(new ErrorResponse(e.getOperation(), e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({UnprocessableEntityException.class})
    public ResponseEntity unprocessableEntityExceptionHandler(NotFoundException e) {
        return new ResponseEntity(new ErrorResponse(e.getOperation(), e.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
