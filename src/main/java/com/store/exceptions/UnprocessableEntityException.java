package com.store.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This is custom exception class that should be thrown in any case that would result in a UnprocessableEntity Http status.
 */
@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntityException extends RuntimeException{
    private final String operation;

    public UnprocessableEntityException(String operation, String message) {
        super(message);
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
