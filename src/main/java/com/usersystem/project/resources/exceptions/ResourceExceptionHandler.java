package com.usersystem.project.resources.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFound(ResourceNotFoundException ex, WebRequest request) {
        StandardError errorDetails = new StandardError(new Date(), 404, "Usuário não encontrado", "o usuário requisitado não foi encontrado", "/users/{id}");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

}
