package com.pizza.builder;

import com.pizza.exception.ApplicationException;
import com.pizza.input.PizzaInputData;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.Size;
import com.pizza.model.pizza.ingredients.AbstractPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.PaneerTikkaPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.PizzaIngredientsName;
import com.pizza.model.pizza.veg.PaneerTikkaPizzaModel;

public class PaneerTikkaPizzaModelBuilder extends AbstractPizzaModelBuilder {

    public PaneerTikkaPizzaModelBuilder(PizzaInputData pizzaInputData) {
        super(pizzaInputData);
    }

    protected AbstractPizzaIngredientsModel buildPizzaIngredientModel() throws ApplicationException {
        PaneerTikkaPizzaIngredientsModel ingredientsModel = new PaneerTikkaPizzaIngredientsModel();
        addCommonIngredients(ingredientsModel);
        ingredientsModel.add(getIngredientModel(PizzaIngredientsName.PANEER_CHOP));
        return ingredientsModel;
    }

    @Override
    protected double getMultiplier() {
        Size pizzaSize = Size.of(getPizzaInputData().getPizzaSize());
        if (pizzaSize == Size.LARGE) {
            return 2.125;
        } else if (pizzaSize == Size.MEDIUM) {
            return 1.815;
        } else {
            return 1;
        }
    }

    @Override
    protected AbstractPizzaModel createPizzaModel() {
        return new PaneerTikkaPizzaModel();
    }

    @Override
    protected IngredientType getPizzaType() {
        return null;
    }


}
