package com.pizza.builder;

import com.pizza.input.PizzaInputData;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.ingredients.AbstractPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.ChickenTikkaPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.PizzaIngredientsModel;
import com.pizza.model.pizza.nonveg.ChickenTikkaPizzaModel;

public class ChickenTikkaPizzaModelBuilder extends AbstractPizzaModelBuilder {
    public ChickenTikkaPizzaModelBuilder(PizzaInputData pizza) {
        super(pizza);
    }

    @Override
    protected AbstractPizzaIngredientsModel buildPizzaIngredientModel() {
        ChickenTikkaPizzaIngredientsModel ingredientsModel = new ChickenTikkaPizzaIngredientsModel();
        ingredientsModel.add(buildIngredientModel("Chicken", IngredientType.NON_VEG, 100.0 * getMultiplier(), "GRAM"));
        ingredientsModel.add(buildIngredientModel("Sauce", IngredientType.NON_VEG, 20.0 * getMultiplier(), "GRAM"));
        ingredientsModel.add(buildIngredientModel("Cheese", IngredientType.NON_VEG, 40.0 * getMultiplier(), "GRAM"));
        return ingredientsModel;
    }

    @Override
    protected AbstractPizzaModel createPizzaModel() {
        return new ChickenTikkaPizzaModel();
    }

    @Override
    protected IngredientType getPizzaType() {
        return IngredientType.NON_VEG;
    }
}
