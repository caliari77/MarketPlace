package com.store.models.responses;

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
