package com.pizza.order.service;

import com.pizza.order.utils.OrderRef;

public interface OrderingService {
    void validateOrder() throws Exception;
    OrderRef placeOrder();
    double calculatePrice();
}