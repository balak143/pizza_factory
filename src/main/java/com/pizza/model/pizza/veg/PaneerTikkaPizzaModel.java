package com.pizza.model.pizza.veg;

import com.pizza.dao.CostData;
import com.pizza.model.pizza.ingredients.DeluxeVeggiePizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.PaneerTikkaPizzaIngredientsModel;
import com.pizza.utils.Price;

import java.util.Date;

public class PaneerTikkaPizzaModel extends VegetarianPizzaModel {

    public PaneerTikkaPizzaModel() {
        pizzaIngredientsModel =  new PaneerTikkaPizzaIngredientsModel();
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
