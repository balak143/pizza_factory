package com.pizza.builder;

import com.pizza.input.PizzaInputData;
import com.pizza.input.PizzaOrderInputData;
import com.pizza.model.pizza.ingredients.PizzaIngredientsModel;
import com.pizza.model.pizza.veg.CheeseAndCornPizzaModel;

public class CheeseCornPizzaModelBuilder extends AbstractPizzaModelBuilder {

    public CheeseCornPizzaModelBuilder(PizzaInputData pizzaInputData) {
        super(pizzaInputData);
    }

    @Override
    protected PizzaIngredientsModel buildPizzaIngredientModel() {
        return null;
    }

}
