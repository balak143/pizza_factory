package com.pizza.order.model.topping;

import com.pizza.order.dao.PriceDAO;
import com.pizza.order.model.enums.NONVEGTOPPING;

public class ChickenTikka extends NonVegetarianTopping {
    @Override
    public Double getCost() {
        return PriceDAO.getToppingPrice(NONVEGTOPPING.ChickenTikka);
    }

    @Override
    public String toString() {
        return NONVEGTOPPING.ChickenTikka.getName();
    }
}
