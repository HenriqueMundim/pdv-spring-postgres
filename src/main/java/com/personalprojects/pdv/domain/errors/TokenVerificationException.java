package com.personalprojects.pdv.domain.errors;

public class TokenVerificationException extends RuntimeException{

    public TokenVerificationException(String message) {
        super(message);
    }
}
