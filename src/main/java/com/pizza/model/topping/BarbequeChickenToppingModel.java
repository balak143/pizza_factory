package com.pizza.model.topping;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.utils.Price;

import java.util.Date;

public class BarbequeChickenToppingModel extends AbstractToppingModel implements NonVegetarianToppingModel {

    @Override
    public Price cost(Date date) {
        return null;
    }
}
