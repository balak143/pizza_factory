package com.pizza.builder;

import com.pizza.exception.ApplicationException;
import com.pizza.input.PizzaInputData;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.Size;
import com.pizza.model.pizza.ingredients.AbstractPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.PepperBarbecueChickenPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.PizzaIngredientsName;
import com.pizza.model.pizza.nonveg.PepperBarbecueChickenPizzaModel;

public class PepperBarbecueChickenPizzaModelBuilder extends AbstractPizzaModelBuilder {
    public PepperBarbecueChickenPizzaModelBuilder(PizzaInputData pizzaInputData) {
        super(pizzaInputData);
    }

    @Override
    protected AbstractPizzaIngredientsModel buildPizzaIngredientModel() throws ApplicationException {
        PepperBarbecueChickenPizzaIngredientsModel ingredientsModel = new PepperBarbecueChickenPizzaIngredientsModel();
        addCommonIngredients(ingredientsModel);
        ingredientsModel.add(getIngredientModel(PizzaIngredientsName.CORN));
        ingredientsModel.add(getIngredientModel(PizzaIngredientsName.CHICKEN));
        ingredientsModel.add(getIngredientModel(PizzaIngredientsName.RED_MEAT));
        ingredientsModel.add(getIngredientModel(PizzaIngredientsName.FISH));
        return ingredientsModel;

    }
    @Override
    protected double getMultiplier() {
        Size pizzaSize = Size.of(getPizzaInputData().getPizzaSize());
        if (pizzaSize == Size.LARGE) {
            return 2.39;
        } else if (pizzaSize == Size.MEDIUM) {
            return 1.73;
        } else {
            return 1;
        }
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
