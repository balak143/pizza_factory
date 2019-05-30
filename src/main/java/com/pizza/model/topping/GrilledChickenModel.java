package com.pizza.model.topping;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.utils.Price;

import java.util.Date;

public class GrilledChickenModel extends AbstractToppingModel {

    public GrilledChickenModel(IngredientModel ingredientModel) {
        super(ingredientModel);
        this.ingredientModel = ingredientModel;
    }

    @Override
    public Price cost(Date date) {
        return null;
    }
}
