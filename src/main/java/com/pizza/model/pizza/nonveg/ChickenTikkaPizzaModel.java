package com.pizza.model.pizza.nonveg;

import com.pizza.dao.CostData;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.ingredients.DeluxeVeggiePizzaIngredientsModel;
import com.pizza.model.pizza.veg.VegetarianPizzaModel;
import com.pizza.utils.Price;

import java.util.Date;
import java.util.List;

public class ChickenTikkaPizzaModel extends AbstractPizzaModel implements NonVegetarianPizzaModel {

    @Override
    public List<Price> cost(Date date) {
        CostData costData = null; //new CostDAO().getCostMap().get("Paneer");
        double price = costData.getPrice();
        String priceCcy = costData.getPriceCcy();
        String priceUOM = costData.getPriceUOM();
        return null;
    }
}
