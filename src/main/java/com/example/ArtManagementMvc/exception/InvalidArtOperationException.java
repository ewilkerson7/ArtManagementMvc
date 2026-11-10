package com.example.ArtManagementMvc.exception;

public class InvalidArtOperationException extends RuntimeException {
    public InvalidArtOperationException(String message) {
        super(message);
    }
}
