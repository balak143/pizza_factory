package com.pizza.builder;

import com.pizza.input.PizzaInputData;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.ingredients.AbstractPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.NonVegSupremePizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.PepperBarbecueChickenPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.PizzaIngredientsModel;

public class NonVegSupremePizzaModelBuilder extends AbstractPizzaModelBuilder {

    public NonVegSupremePizzaModelBuilder(PizzaInputData pizzaInputData) {
        super(pizzaInputData);
    }

    @Override
    protected AbstractPizzaIngredientsModel buildPizzaIngredientModel() {
        NonVegSupremePizzaIngredientsModel ingredientsModel = new NonVegSupremePizzaIngredientsModel();
        ingredientsModel.add(buildIngredientModel("Capsicum", IngredientType.VEG, 50.0 * getMultiplier(), "GRAM"));
        ingredientsModel.add(buildIngredientModel("Sauce", IngredientType.VEG, 20.0 * getMultiplier(), "GRAM"));
        ingredientsModel.add(buildIngredientModel("Cheese", IngredientType.VEG, 40.0 * getMultiplier(), "GRAM"));
        return ingredientsModel;
    }

    @Override
    protected AbstractPizzaModel createPizzaModel() {
        return null;
    }

    @Override
    protected IngredientType getPizzaType() {
        return null;
    }
}
