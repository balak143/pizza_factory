package com.pizza.model.topping;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.utils.Price;

import java.util.Date;

public abstract class AbstractToppingModel implements ToppingModel {
    protected IngredientModel ingredientModel ;
    public AbstractToppingModel(IngredientModel ingredientModel){
        this.ingredientModel = ingredientModel;
    }
    @Override
    public Price cost(Date date) {
        return null;
    }


}
