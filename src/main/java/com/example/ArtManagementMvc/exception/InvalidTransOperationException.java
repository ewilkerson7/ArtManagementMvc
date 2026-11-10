package com.example.ArtManagementMvc.exception;

public class InvalidTransOperationException extends RuntimeException {
    public InvalidTransOperationException(String message) {
        super(message);
    }
}