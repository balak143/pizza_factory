package com.pizza.builder;

import com.pizza.exception.ApplicationException;
import com.pizza.input.PizzaInputData;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.Size;
import com.pizza.model.pizza.ingredients.AbstractPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.ChickenTikkaPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.PizzaIngredientsName;
import com.pizza.model.pizza.nonveg.ChickenTikkaPizzaModel;

public class ChickenTikkaPizzaModelBuilder extends AbstractPizzaModelBuilder {
    public ChickenTikkaPizzaModelBuilder(PizzaInputData pizza) {
        super(pizza);
    }

    @Override
    protected AbstractPizzaIngredientsModel buildPizzaIngredientModel() throws ApplicationException {
        ChickenTikkaPizzaIngredientsModel ingredientsModel = new ChickenTikkaPizzaIngredientsModel();
        addCommonIngredients(ingredientsModel);
        ingredientsModel.add(getIngredientModel(PizzaIngredientsName.CORN));
        ingredientsModel.add(getIngredientModel(PizzaIngredientsName.CHICKEN));
        ingredientsModel.add(getIngredientModel(PizzaIngredientsName.FISH));
        return ingredientsModel;
    }

    @Override
    protected double getMultiplier() {
        Size pizzaSize = Size.of(getPizzaInputData().getPizzaSize());
        if (pizzaSize == Size.LARGE) {
            return 2.383;
        } else if (pizzaSize == Size.MEDIUM) {
            return 1.755;
        } else {
            return 1;
        }
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
