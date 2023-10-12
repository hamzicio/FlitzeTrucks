package com.truck.app.exception;

public class TruckNotFoundException extends RuntimeException {

    private String message;

    public TruckNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
