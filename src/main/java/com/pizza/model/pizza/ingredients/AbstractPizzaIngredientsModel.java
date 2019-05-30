package com.pizza.model.pizza.ingredients;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.utils.Price;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class AbstractPizzaIngredientsModel implements PizzaIngredientsModel {

    protected List<IngredientModel> ingredients = new ArrayList<>();

    @Override
    public Price cost(Date date) {
        return null;
    }

    //public abstract void add(IngredientModel ingredientModel);
    public List<IngredientModel> getIngredients() {
        return ingredients;
    }

}
