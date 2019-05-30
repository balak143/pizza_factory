package com.pizza.builder;

import com.pizza.input.PizzaInputData;
import com.pizza.model.pizza.ingredients.PizzaIngredientsModel;

public class NonVegSupremePizzaModelBuilder extends AbstractPizzaModelBuilder {

    public NonVegSupremePizzaModelBuilder(PizzaInputData pizzaInputData) {
        super(pizzaInputData);
    }

    @Override
    protected PizzaIngredientsModel buildPizzaIngredientModel() {
        return null;
    }
}
