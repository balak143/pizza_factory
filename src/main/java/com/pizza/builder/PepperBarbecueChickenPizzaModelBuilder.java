package com.pizza.builder;

import com.pizza.input.PizzaInputData;
import com.pizza.model.pizza.PizzaModel;
import com.pizza.model.pizza.ingredients.PizzaIngredientsModel;

public class PepperBarbecueChickenPizzaModelBuilder extends AbstractPizzaModelBuilder {
    public PepperBarbecueChickenPizzaModelBuilder(PizzaInputData pizzaInputData) {
        super(pizzaInputData);
    }

    @Override
    protected PizzaIngredientsModel buildPizzaIngredientModel() {
        return null;
    }
}
