package com.pizza.order.model.topping;

import com.pizza.order.dao.PriceDAO;
import com.pizza.order.model.enums.VEGTOPPING;

public class BlackOlive extends VegetarianTopping {
    @Override
    public Double getCost() {
        return PriceDAO.getToppingPrice(VEGTOPPING.BlackOlive);
    }


    public String toString() {
        return VEGTOPPING.BlackOlive.getName();
    }
}
