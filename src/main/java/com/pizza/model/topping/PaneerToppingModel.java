package com.pizza.model.topping;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.utils.Price;

import java.util.Date;

public class PaneerToppingModel extends AbstractToppingModel{
    PaneerToppingModel(IngredientModel ingredientModel){
        super(ingredientModel);
        this.ingredientModel = ingredientModel;
    }
    @Override
    public Price cost(Date date) {
        return null;
    }
}
