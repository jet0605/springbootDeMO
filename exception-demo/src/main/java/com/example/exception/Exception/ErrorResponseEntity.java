package com.example.exception.Exception;

public class ErrorResponseEntity {
    public ErrorResponseEntity(){}

    public ErrorResponseEntity(int code,String message){
        this.code = code;
        this.message = message;
    }
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
