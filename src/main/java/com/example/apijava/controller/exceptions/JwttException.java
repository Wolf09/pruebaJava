package com.example.apijava.controller.exceptions;

public class JwttException extends RuntimeException{
    public JwttException(String message) {
        super(message);
    }
}
