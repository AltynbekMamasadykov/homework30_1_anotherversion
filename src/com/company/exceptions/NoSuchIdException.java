package com.company.exceptions;

public class NoSuchIdException extends RuntimeException{
    public NoSuchIdException() {
    }

    public NoSuchIdException(String message) {
        super(message);
    }
}