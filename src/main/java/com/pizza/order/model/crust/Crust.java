package com.pizza.order.model.crust;

import com.pizza.order.model.pizza.CostModel;
import com.pizza.order.utils.Price;

import java.util.Date;

public interface Crust extends CostModel {
    Price cost(Date date);
}

/*
NewHandTossed,
    WheatThinCrust,
    CheeseBurst,
    FreshPanPizza;
 */