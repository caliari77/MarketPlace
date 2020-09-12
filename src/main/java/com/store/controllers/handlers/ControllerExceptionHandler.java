package com.store.controllers.handlers;

import com.store.exceptions.NotFoundException;
import com.store.exceptions.UnprocessableEntityException;
import com.store.models.responses.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ErrorResponse> notFoundExceptionHandler(NotFoundException e) {
        return new ResponseEntity(new ErrorResponse(e.getOperation(), e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({UnprocessableEntityException.class})
    public ResponseEntity<ErrorResponse> unprocessableEntityExceptionHandler(NotFoundException e) {
        return new ResponseEntity(new ErrorResponse(e.getOperation(), e.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
