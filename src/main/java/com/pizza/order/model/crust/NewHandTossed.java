package com.pizza.order.model.crust;

import com.pizza.order.model.enums.CRUST;

public class NewHandTossed implements Crust {
    @Override
    public Double getCost() {
        return null;
    }
    @Override
    public String toString() {
        return CRUST.NewHandTossed.getName();
    }
}
