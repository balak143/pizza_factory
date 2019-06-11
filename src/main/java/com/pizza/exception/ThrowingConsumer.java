package com.pizza.exception;

public interface ThrowingConsumer{

    static <T extends Exception, R> R sneakyThrow(ApplicationException t) throws T {
        throw (T) t;
    }
}