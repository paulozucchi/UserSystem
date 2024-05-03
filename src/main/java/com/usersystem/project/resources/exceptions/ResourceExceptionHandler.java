package com.usersystem.project.resources.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFound(int status, String error, String message, String path) {
        StandardError errorDetails = new StandardError(new Date(), status, error, message, path);
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

}
