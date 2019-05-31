package com.pizza.builder;

import com.pizza.input.PizzaInputData;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.PizzaModel;
import com.pizza.model.pizza.ingredients.AbstractPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.CheeseCornPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.PepperBarbecueChickenPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.PizzaIngredientsModel;
import com.pizza.model.pizza.nonveg.PepperBarbecueChickenPizzaModel;

public class PepperBarbecueChickenPizzaModelBuilder extends AbstractPizzaModelBuilder {
    public PepperBarbecueChickenPizzaModelBuilder(PizzaInputData pizzaInputData) {
        super(pizzaInputData);
    }

    @Override
    protected AbstractPizzaIngredientsModel buildPizzaIngredientModel() {
        PepperBarbecueChickenPizzaIngredientsModel ingredientsModel = new PepperBarbecueChickenPizzaIngredientsModel();
        ingredientsModel.add(buildIngredientModel("Capsicum", IngredientType.VEG, 50.0 * getMultiplier(), "GRAM"));
        ingredientsModel.add(buildIngredientModel("Sauce", IngredientType.VEG, 20.0 * getMultiplier(), "GRAM"));
        ingredientsModel.add(buildIngredientModel("Cheese", IngredientType.VEG, 40.0 * getMultiplier(), "GRAM"));
        return ingredientsModel;

    }

    @Override
    protected AbstractPizzaModel createPizzaModel() {
        return new PepperBarbecueChickenPizzaModel();
    }

    @Override
    protected IngredientType getPizzaType() {
        return IngredientType.NON_VEG;
    }
}
