package com.pizza.model.topping;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.utils.Price;

import java.util.Date;
import java.util.List;

public class BlackOliveToppingModel extends AbstractToppingModel implements VegetarianToppingModel{
    @Override
    public List<Price> cost(Date date) {
        return null;
    }
}
