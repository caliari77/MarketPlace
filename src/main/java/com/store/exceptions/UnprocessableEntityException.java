package com.store.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntityException extends RuntimeException{
    private String operation;

    public UnprocessableEntityException(String operation, String message) {
        super(message);
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
