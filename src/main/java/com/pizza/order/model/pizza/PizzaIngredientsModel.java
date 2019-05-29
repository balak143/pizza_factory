package com.pizza.order.model.pizza;

import com.pizza.order.utils.Price;

import java.util.Date;

public interface PizzaIngredientsModel extends CostModel{
    Price cost(Date date);
    void create();
}
