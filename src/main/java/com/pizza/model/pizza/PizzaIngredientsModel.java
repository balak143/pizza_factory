package com.pizza.model.pizza;

import com.pizza.utils.Price;

import java.util.Date;

public interface PizzaIngredientsModel extends CostModel{
    Price cost(Date date);
    void create();
}
