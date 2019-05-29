package com.pizza.order.model.pizza.nonveg;

import com.pizza.order.dao.PriceDAO;
import com.pizza.order.model.enums.NONVEGETARIAN;

public class PepperBarbeQueue extends NonVegetarianPizza {
    @Override
    public Double getCost() {
        return PriceDAO.pizzaPriceMap.get(NONVEGETARIAN.PepperBarbecue +"."+this.getSize())
                + getToppingsCost();
    }
}
