package org.example.exception;

public class insufficientBalanceException extends RuntimeException {
    public insufficientBalanceException(String message) {
        super(message);
    }

    public insufficientBalanceException(String message, Throwable cause) {
        super(message, cause);
    }
}
