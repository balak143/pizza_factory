package com.pizza.order.model.topping;

import com.pizza.order.model.pizza.IngredientModel;
import com.pizza.order.utils.Price;

import java.util.Date;

public abstract class AbstractToppingModel implements Topping {
    private IngredientModel ingredientModel ;
    AbstractToppingModel(IngredientModel ingredientModel){
        this.ingredientModel = ingredientModel;
    }
    @Override
    public Price cost(Date date) {
        return null;
    }


}
