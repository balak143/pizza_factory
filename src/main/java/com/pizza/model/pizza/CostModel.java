package com.pizza.model.pizza;

import com.pizza.utils.Price;

import java.util.Date;

public interface CostModel {
    Price cost(Date date);
}
