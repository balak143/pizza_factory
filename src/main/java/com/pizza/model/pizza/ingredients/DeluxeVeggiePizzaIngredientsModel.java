package com.pizza.model.pizza.ingredients;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.model.ingredient.IngredientType;

public class DeluxeVeggiePizzaIngredientsModel extends AbstractPizzaIngredientsModel {
    public DeluxeVeggiePizzaIngredientsModel(){
        this.ingredients.add(new IngredientModel("Paneer", IngredientType.VEG, 50.00, "GRAM"));
        this.ingredients.add(new IngredientModel("Sauce", IngredientType.VEG, 20.00, "GRAM"));
        this.ingredients.add(new IngredientModel("Cheese", IngredientType.VEG, 50.00, "GRAM"));
    }

    /*@Override
    public void add(IngredientModel ingredientModel) {

    }*/
}
