package com.pizza.builder;

import com.pizza.exception.ApplicationException;
import com.pizza.input.PizzaInputData;
import com.pizza.model.crust.AbstractCrustModel;
import com.pizza.model.crust.CrustModelFactory;
import com.pizza.model.ingredient.IngredientModel;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.crust.CrustName;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.PizzaModelFactory;
import com.pizza.model.pizza.PizzaName;
import com.pizza.model.pizza.Size;
import com.pizza.model.pizza.ingredients.*;
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

    protected AbstractPizzaIngredientsModel buildPizzaIngredientModel() throws ApplicationException {
        DeluxeVeggiePizzaIngredientsModel ingredientsModel = new DeluxeVeggiePizzaIngredientsModel();
        ingredientsModel.add(getIngredientModel(PizzaIngredientsName.SAUCE));
        ingredientsModel.add(getIngredientModel(PizzaIngredientsName.CHEESE));
        ingredientsModel.add(getIngredientModel(PizzaIngredientsName.ORIGANO));
        ingredientsModel.add(getIngredientModel(PizzaIngredientsName.GARLIC));
        return ingredientsModel;
    }

    private IngredientModel getIngredientModel(PizzaIngredientsName pizzaIngredientsName) throws ApplicationException {
        IngredientRequiredQty ingredientRequiredQty = getIngredientRequiredQty(PizzaIngredientsName.GARLIC.getName());
        return buildIngredientModel(pizzaIngredientsName.getName(), IngredientType.VEG, ingredientRequiredQty.getQty()
                * getMultiplier(), ingredientRequiredQty.getQtyUom());
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
