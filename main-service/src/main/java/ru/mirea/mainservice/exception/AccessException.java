package ru.mirea.mainservice.exception;

public class AccessException extends RuntimeException {
    public AccessException(String message) {
        super(message);
    }
}
