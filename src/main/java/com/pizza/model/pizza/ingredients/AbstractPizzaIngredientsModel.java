package com.pizza.model.pizza.ingredients;

import com.pizza.model.ingredient.IngredientModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractPizzaIngredientsModel implements PizzaIngredientsModel {

    protected List<IngredientModel> ingredients = new ArrayList<>();

    public void add(IngredientModel... ingredientModels) {
        ingredients.addAll(Arrays.asList(ingredientModels));
    }

    public List<IngredientModel> getIngredients() {
        return ingredients;
    }

}
