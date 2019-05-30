package com.pizza.model.crust;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.utils.Price;

import java.util.Date;

public abstract class AbstractCrustModel implements CrustModel {
    protected IngredientModel ingredientModel;

    public AbstractCrustModel(IngredientModel ingredientModel) {
        this.ingredientModel = ingredientModel;
    }

    @Override
    public Price cost(Date date) {
        return null;
    }


}
