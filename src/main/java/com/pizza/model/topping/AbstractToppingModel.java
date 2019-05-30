package com.pizza.model.topping;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.utils.Price;

import java.util.Date;
import java.util.List;

public abstract class AbstractToppingModel implements ToppingModel {

    protected IngredientModel ingredientModel ;

    public IngredientModel getIngredientModel() {
        return ingredientModel;
    }

    public AbstractToppingModel setIngredientModel(IngredientModel ingredientModel) {
        this.ingredientModel = ingredientModel;
        return this;
    }


    @Override
    public List<Price> cost(Date date) {
        return null;
    }


}
