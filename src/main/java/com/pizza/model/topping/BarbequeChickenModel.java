package com.pizza.model.topping;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.utils.Price;

import java.util.Date;

public class BarbequeChickenModel extends AbstractToppingModel {

    public BarbequeChickenModel(IngredientModel ingredientModel){
        super(ingredientModel);
    }

    @Override
    public Price cost(Date date) {
        return null;
    }
}
