package com.pizza.model.crust;

import com.pizza.model.enums.CRUST;

public class FreshPanPizza implements Crust {
    @Override
    public Double getCost() {
        return null;
    }

    @Override
    public String toString() {
        return CRUST.FreshPanPizza.getName();
    }
}
