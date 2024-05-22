package com.personalprojects.pdv.domain.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardException> resourceNotFound(ResourceNotFoundException exception, WebRequest request) {
        StandardException exceptionResponse = new StandardException(Instant.now(),
                                                    request.getDescription(false).split("=")[1],
                                                    exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<StandardException> resourceAlreadyExists(ResourceAlreadyExistsException exception, WebRequest request) {
        StandardException exceptionResponse = new StandardException(Instant.now(),
                request.getDescription(false).split("=")[1],
                exception.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }
}
