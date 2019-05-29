package com.pizza.order.model.sides;

import com.pizza.order.model.enums.SIDE;

public class ColdDrink implements Side
{
    @Override
    public Double getCost() {
        return 55.00;
    }

    @Override
    public String toString() {
        return SIDE.ColdDrink.getName();
    }
}
