package com.pizza.model.pizza.nonveg;

import com.pizza.dao.CostData;
import com.pizza.model.pizza.ingredients.DeluxeVeggiePizzaIngredientsModel;
import com.pizza.model.pizza.veg.VegetarianPizzaModel;
import com.pizza.utils.Price;

import java.util.Date;

public class PepperBarbecueChickenModel extends NonVegetarianPizzaModel {

    public PepperBarbecueChickenModel() {
        pizzaIngredientsModel =  new DeluxeVeggiePizzaIngredientsModel();
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
