package com.pizza.model.crust;

import com.pizza.model.pizza.CostModel;
import com.pizza.utils.Price;

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