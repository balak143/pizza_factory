package com.pizza.model.topping;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.utils.Price;

import java.util.Date;
import java.util.List;

public class FreshTomatoToppingModel extends AbstractToppingModel implements VegetarianToppingModel{
    public FreshTomatoToppingModel() {
        this.setName(ToppingName.FRESH_TOMATO.getName());
    }
}
