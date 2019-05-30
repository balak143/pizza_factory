package com.pizza.model.crust;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.utils.Price;

import java.util.Date;

public class WheatThinCrustModel extends AbstractCrustModel {
    public WheatThinCrustModel(IngredientModel ingredientModel) {
        super(ingredientModel);
    }

    @Override
    public Price cost(Date date) {
        return null;
    }
}
