package com.pizza.model.crust;

import com.pizza.model.enums.CRUST;

public class CheeseBurst implements Crust {
    @Override
    public Double getCost() {
        return null;
    }

    @Override
    public String toString() {
        return CRUST.CheeseBurst.getName();
    }
}
