package com.pizza.model.topping;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.utils.Price;

import java.util.Date;

public class ChickenTikkaToppingModel extends AbstractToppingModel implements NonVegetarianToppingModel{

    @Override
    public Price cost(Date date) {
        return null;
    }
}
