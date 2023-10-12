package com.truck.app.exception;

public class TruckException extends  RuntimeException {

    private String message;

        public TruckException (String message){
            super(message);
            this.message= message;
        }
}


