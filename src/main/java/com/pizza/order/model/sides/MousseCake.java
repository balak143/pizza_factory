package com.pizza.order.model.sides;

import com.pizza.order.model.enums.SIDE;

public class MousseCake implements Side {
    @Override
    public Double getCost() {
        return 65.0;
    }

    @Override
    public String toString() {
        return SIDE.MousseCake.getName();
    }
}
