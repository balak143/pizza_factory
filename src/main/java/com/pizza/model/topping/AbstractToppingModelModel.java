package com.pizza.model.topping;

import com.pizza.model.pizza.IngredientModel;
import com.pizza.utils.Price;

import java.util.Date;

public abstract class AbstractToppingModelModel implements ToppingModel {
    private IngredientModel ingredientModel ;
    public AbstractToppingModelModel(IngredientModel ingredientModel){
        this.ingredientModel = ingredientModel;
    }
    @Override
    public Price cost(Date date) {
        return null;
    }


}
