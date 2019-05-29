package com.pizza.service;

import com.pizza.utils.OrderRef;

public interface OrderingService {
    void validateOrder() throws Exception;
    OrderRef placeOrder();
    double calculatePrice();
}