package com.pizza.order.model.pizza.ingredients;

import com.pizza.order.model.pizza.AbstractPizzaIngredientsModel;
import com.pizza.order.model.pizza.IngredientModel;
import com.pizza.order.model.pizza.IngredientType;

public class DeluxeVeggiePizzaIngredientsModel extends AbstractPizzaIngredientsModel {
    public void create(){
        this.ingredients.add(new IngredientModel("Paneer", IngredientType.VEG, 50.00, "GRAM"));
        this.ingredients.add(new IngredientModel("Cheese", IngredientType.VEG, 20.00, "GRAM"));
        this.ingredients.add(new IngredientModel("Capsicum", IngredientType.VEG, 50.00, "GRAM"));
    }

}
