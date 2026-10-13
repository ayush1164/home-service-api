package com.homeservices.booking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(BusinessRuleException.class)
    public ResponseEntity<String> handleBusinessRule(BusinessRuleException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}

/*
    Understand what each annotation does
        - @RestControllerAdvice — makes this class handle exceptions thrown by your REST controllers across the application.
        - @ExceptionHandler(...) — tells Spring which exception a particular method handles.
        - ResponseEntity — lets you control both the HTTP status code and the response body.

        The API will return:
        404 Not Found

        Response body
        "Provider not found"

        Instead of a generic 500 Internal Server Error
 */