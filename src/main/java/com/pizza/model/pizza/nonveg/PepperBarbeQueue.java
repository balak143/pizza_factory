package com.pizza.model.pizza.nonveg;

import com.pizza.model.enums.NONVEGETARIAN;
import com.pizza.order.dao.PriceDAO;

public class PepperBarbeQueue extends NonVegetarianPizza {
    @Override
    public Double getCost() {
        return PriceDAO.pizzaPriceMap.get(NONVEGETARIAN.PepperBarbecue +"."+this.getSize())
                + getToppingsCost();
    }
}
