package com.hospital.api.exception;

public class ResourceExists extends RuntimeException{
    public ResourceExists(String message) {
        super(message);
    }
}
