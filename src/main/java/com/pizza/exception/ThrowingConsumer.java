package com.pizza.exception;

import java.util.function.Consumer;

public interface ThrowingConsumer<T extends Throwable> {

    @SuppressWarnings("unchecked")
    static <T extends Exception, R> R sneakyThrow(Exception t) throws T {
        throw (T) t;
    }
}