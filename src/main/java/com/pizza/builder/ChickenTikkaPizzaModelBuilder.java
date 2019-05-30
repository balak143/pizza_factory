package com.pizza.builder;

import com.pizza.input.PizzaInputData;
import com.pizza.model.pizza.ingredients.PizzaIngredientsModel;

public class ChickenTikkaPizzaModelBuilder extends AbstractPizzaModelBuilder {
    public ChickenTikkaPizzaModelBuilder(PizzaInputData pizza) {
        super(pizza);
    }

    @Override
    protected PizzaIngredientsModel buildPizzaIngredientModel() {
        return null;
    }
}
