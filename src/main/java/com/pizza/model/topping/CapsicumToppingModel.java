package com.pizza.model.topping;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.model.pizza.veg.VegetarianPizzaModel;
import com.pizza.utils.Price;

import java.util.Date;
import java.util.List;

public class CapsicumToppingModel extends AbstractToppingModel implements VegetarianToppingModel {

    @Override
    public List<Price> cost(Date date) {
        return null;
    }
}
