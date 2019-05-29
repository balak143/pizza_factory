package com.pizza.order.model.pizza;

import com.pizza.order.utils.Price;

import java.util.Date;

public interface CostModel {
    Price cost(Date date);
}
