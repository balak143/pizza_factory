package com.pizza.utils;

import java.util.UUID;

public class OrderRef {
    public String getReference() {
        return UUID.randomUUID().toString().toUpperCase();
    }
}
