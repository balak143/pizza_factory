package com.pizza.model.crust;

import com.pizza.model.enums.CRUST;
import com.pizza.utils.Price;

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
