package com.truck.app.exception.handler;

import com.truck.app.exception.ApiError;
import com.truck.app.exception.TruckException;
import com.truck.app.exception.TruckNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestApiHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TruckException.class)
    protected ResponseEntity<ApiError> handleTruckException(
            TruckException ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,"Internal Error Occurred",ex);
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(TruckNotFoundException.class)
    protected ResponseEntity<ApiError> handleTruckNotFoundException(
            TruckNotFoundException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND,"Internal Error Occurred",ex);
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(Exception.class)
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> details = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, details, ex);
        return new ResponseEntity(apiError, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ApiError> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

}

