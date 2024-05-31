package com.personalprojects.pdv.domain.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardException> methodArgumentNotValidException(MethodArgumentNotValidException exception, WebRequest request) {
        List<String> errorMessages = new ArrayList<>();
        exception.getBindingResult().getAllErrors().forEach(objectError -> errorMessages.add(objectError.getDefaultMessage()));
        StandardException exceptionResponse = new StandardException(Instant.now(),
                request.getDescription(false).split("=")[1],
                errorMessages.toString()
                );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<StandardException> authenticationException(AuthenticationException exception, WebRequest request) {
        StandardException exceptionResponse = new StandardException(Instant.now(),
            request.getDescription(false).split("=")[1],
            "username or password are incorrect"
        );

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exceptionResponse);
    }
}
