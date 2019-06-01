package com.pizza.builder;

import com.pizza.input.PizzaInputData;
import com.pizza.model.crust.AbstractCrustModel;
import com.pizza.model.crust.CrustModelFactory;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.crust.CrustName;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.PizzaModelFactory;
import com.pizza.model.pizza.PizzaName;
import com.pizza.model.pizza.Size;
import com.pizza.model.pizza.ingredients.AbstractPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.DeluxeVeggiePizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.PizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.PizzaIngredientsName;
import com.pizza.model.pizza.veg.DeluxeVeggiePizzaModel;
import com.pizza.model.topping.AbstractToppingModel;
import com.pizza.model.topping.ToppingModelFactory;
import com.pizza.model.topping.ToppingName;

import java.util.ArrayList;
import java.util.List;

public class DeluxeVeggiePizzaModelBuilder extends AbstractPizzaModelBuilder<DeluxeVeggiePizzaModel> {

    public DeluxeVeggiePizzaModelBuilder(PizzaInputData pizzaInputData) {
        super(pizzaInputData);
    }

    protected AbstractPizzaIngredientsModel buildPizzaIngredientModel() {
        DeluxeVeggiePizzaIngredientsModel ingredientsModel = new DeluxeVeggiePizzaIngredientsModel();
        ingredientsModel.add(buildIngredientModel("Capsicum", IngredientType.VEG, 50.0 * getMultiplier(), "GRAM"));
        ingredientsModel.add(buildIngredientModel(PizzaIngredientsName.SAUCE.getName(), IngredientType.VEG, 20.0 * getMultiplier(), "GRAM"));
        ingredientsModel.add(buildIngredientModel("Cheese", IngredientType.VEG, 40.0 * getMultiplier(), "GRAM"));
        return ingredientsModel;
    }

    @Override
    protected DeluxeVeggiePizzaModel createPizzaModel() {
        return new DeluxeVeggiePizzaModel();
    }

    @Override
    protected IngredientType getPizzaType() {
        return IngredientType.VEG;
    }
}
