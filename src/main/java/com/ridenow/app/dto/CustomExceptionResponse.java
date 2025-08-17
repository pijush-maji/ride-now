package com.ridenow.app.dto;



public class CustomExceptionResponse {
    private String errorMessage;

    public CustomExceptionResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
