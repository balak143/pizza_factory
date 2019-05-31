package com.pizza.builder;

import com.pizza.input.PizzaInputData;
import com.pizza.input.PizzaOrderInputData;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.ingredients.AbstractPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.CheeseCornPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.DeluxeVeggiePizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.PizzaIngredientsModel;
import com.pizza.model.pizza.nonveg.ChickenTikkaPizzaModel;
import com.pizza.model.pizza.veg.CheeseAndCornPizzaModel;

public class CheeseCornPizzaModelBuilder extends AbstractPizzaModelBuilder<ChickenTikkaPizzaModel> {


    public CheeseCornPizzaModelBuilder(PizzaInputData pizzaInputData) {
        super(pizzaInputData);
    }

    @Override
    protected AbstractPizzaIngredientsModel buildPizzaIngredientModel() {
        CheeseCornPizzaIngredientsModel ingredientsModel = new CheeseCornPizzaIngredientsModel();
        ingredientsModel.add(buildIngredientModel("Capsicum", IngredientType.VEG, 50.0 * getMultiplier(), "GRAM"));
        ingredientsModel.add(buildIngredientModel("Sauce", IngredientType.VEG, 20.0 * getMultiplier(), "GRAM"));
        ingredientsModel.add(buildIngredientModel("Cheese", IngredientType.VEG, 40.0 * getMultiplier(), "GRAM"));
        return ingredientsModel;
    }

    @Override
    protected ChickenTikkaPizzaModel createPizzaModel() {
        return new ChickenTikkaPizzaModel();
    }

    @Override
    protected IngredientType getPizzaType() {
        return IngredientType.VEG;
    }
}
