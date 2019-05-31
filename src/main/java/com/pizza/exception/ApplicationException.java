package com.pizza.exception;

public class ApplicationException extends Exception {

    private static final long serialVersionUID = 1L;

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ApplicationException(Throwable throwable) {
        super(throwable);
    }
}
