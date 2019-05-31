package com.pizza.builder;

import com.pizza.input.PizzaInputData;
import com.pizza.model.crust.AbstractCrustModel;
import com.pizza.model.crust.CrustModelFactory;
import com.pizza.model.crust.CrustName;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.Size;
import com.pizza.model.pizza.ingredients.AbstractPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.PaneerTikkaPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.PizzaIngredientsModel;
import com.pizza.model.pizza.veg.PaneerTikkaPizzaModel;
import com.pizza.model.topping.AbstractToppingModel;
import com.pizza.model.topping.ToppingModelFactory;
import com.pizza.model.topping.ToppingName;

import java.util.ArrayList;
import java.util.List;

public class PaneerTikkaPizzaModelBuilder extends AbstractPizzaModelBuilder {

    public PaneerTikkaPizzaModelBuilder(PizzaInputData pizzaInputData) {
        super(pizzaInputData);
    }

    protected AbstractPizzaIngredientsModel buildPizzaIngredientModel() {
        PaneerTikkaPizzaIngredientsModel ingredientsModel = new PaneerTikkaPizzaIngredientsModel();
        ingredientsModel.add(buildIngredientModel("Paneer", IngredientType.VEG, 100.0 * getMultiplier(), "GRAM"));
        ingredientsModel.add(buildIngredientModel("Capsicum", IngredientType.VEG, 100.0 * getMultiplier(), "GRAM"));
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
