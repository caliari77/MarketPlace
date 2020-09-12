package com.store.models.responses;

/**
 * Default error message that should be triggered when custom exception are thrown.
 * Note that this class is not used by Java default and traditional exceptions, as like as, the raw RunTimeException.
 */
public class ErrorResponse {
    private String msg;
    private String operation;

    public ErrorResponse(String operation, String msg) {
        this.msg = msg;
        this.operation = operation;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
