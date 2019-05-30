package com.pizza.model.cost;

import com.pizza.utils.Price;

import java.util.Date;

public interface CostModel {
    Price cost(Date date);
}
