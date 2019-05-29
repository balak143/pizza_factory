package com.pizza.model.pizza.veg;

import com.pizza.dao.CostDAO;
import com.pizza.dao.CostData;
import com.pizza.model.enums.VEGETARIAN;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.utils.Price;

import java.util.Date;

public class DeluxeVeggiePizzaModel extends AbstractPizzaModel {

    public DeluxeVeggiePizzaModel() {
        this.name = VEGETARIAN.DeluxeVeggie.getName();
    }

    @Override
    public Price cost(Date date) {
        CostData costData = null; //new CostDAO().getCostMap().get("Paneer");
        double price = costData.getPrice();
        String priceCcy = costData.getPriceCcy();
        String priceUOM = costData.getPriceUOM();
        return new Price(price, priceCcy, priceUOM);
    }
}
