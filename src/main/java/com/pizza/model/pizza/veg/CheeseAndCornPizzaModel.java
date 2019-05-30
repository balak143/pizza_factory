package com.pizza.model.pizza.veg;

import com.pizza.dao.CostData;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.ingredients.CheeseCornPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.DeluxeVeggiePizzaIngredientsModel;
import com.pizza.utils.Price;

import java.util.Date;

public class CheeseAndCornPizzaModel extends AbstractPizzaModel implements VegetarianPizzaModel {

    public CheeseAndCornPizzaModel() {
        pizzaIngredientsModel =  new CheeseCornPizzaIngredientsModel();
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
