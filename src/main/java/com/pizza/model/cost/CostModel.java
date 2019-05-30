package com.pizza.model.cost;

import com.pizza.utils.Price;

import java.util.Date;
import java.util.List;

public interface CostModel {
    List<Price> cost(Date date);
}
