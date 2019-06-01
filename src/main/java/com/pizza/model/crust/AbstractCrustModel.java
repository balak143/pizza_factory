package com.pizza.model.crust;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.utils.Price;

import java.util.Date;
import java.util.List;

public abstract class AbstractCrustModel implements CrustModel {
    protected IngredientModel ingredientModel;

    public IngredientModel getIngredientModel() {
        return ingredientModel;
    }

    public void setIngredientModel(IngredientModel ingredientModel) {
        this.ingredientModel = ingredientModel;
    }

    @Override
    public List<Price> cost(Date date) {
        return null;
    }


}
