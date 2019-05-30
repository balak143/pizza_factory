package com.pizza.model.topping;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.model.pizza.veg.VegetarianPizzaModel;
import com.pizza.utils.Price;

import java.util.Date;

public class CapsicumToppingModel extends AbstractToppingModel implements VegetarianToppingModel {

    @Override
    public Price cost(Date date) {
        return null;
    }
}
