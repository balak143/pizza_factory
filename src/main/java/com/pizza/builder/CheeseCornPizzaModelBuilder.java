package com.pizza.builder;

import com.pizza.exception.ApplicationException;
import com.pizza.input.PizzaInputData;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.Size;
import com.pizza.model.pizza.ingredients.AbstractPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.CheeseCornPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.PizzaIngredientsName;
import com.pizza.model.pizza.veg.CheeseAndCornPizzaModel;

public class CheeseCornPizzaModelBuilder extends AbstractPizzaModelBuilder<CheeseAndCornPizzaModel> {


    public static final double LARGE_PRICE = 2.7143;
    public static final double MEDIUM_PRICE = 2.145;

    public CheeseCornPizzaModelBuilder(PizzaInputData pizzaInputData) {
        super(pizzaInputData);
    }

    @Override
    protected AbstractPizzaIngredientsModel buildPizzaIngredientModel()throws ApplicationException {
        CheeseCornPizzaIngredientsModel ingredientsModel = new CheeseCornPizzaIngredientsModel();
        addBasicIngredients(ingredientsModel);
        ingredientsModel.add(buildIngredientModel(PizzaIngredientsName.CORN.getName()));
        return ingredientsModel;
    }

    @Override
    protected double getMultiplier() {
        Size pizzaSize = Size.of(getPizzaInputData().getPizzaSize());
        if (pizzaSize == Size.LARGE) {
            return LARGE_PRICE;
        } else if (pizzaSize == Size.MEDIUM) {
            return MEDIUM_PRICE;
        } else {
            return 1;
        }
    }

    @Override
    protected CheeseAndCornPizzaModel createPizzaModel() {
        return new CheeseAndCornPizzaModel();
    }

    @Override
    protected IngredientType getPizzaType() {
        return IngredientType.VEG;
    }
}
