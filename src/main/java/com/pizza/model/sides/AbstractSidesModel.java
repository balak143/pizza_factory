package com.pizza.model.sides;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.utils.Price;

import java.util.Date;

public class AbstractSidesModel implements SidesModel {
    private IngredientModel ingredientModel ;

    @Override
    public Price cost(Date date) {
        return null;
    }


    public IngredientModel getIngredientModel() {
        return ingredientModel;
    }

    public AbstractSidesModel setIngredientModel(IngredientModel ingredientModel) {
        this.ingredientModel = ingredientModel;
        return this;
    }
}
