package com.pizza.order.model.crust;

import com.pizza.order.model.enums.CRUST;
import com.pizza.order.utils.Price;

import java.util.Date;

public class WheatThinCrust implements Crust{
    @Override
    public String toString() {
        return CRUST.WheatThinCrust.getName();
    }

    @Override
    public Price cost(Date date) {
        return null;
    }
}
