package com.pizza.builder;

import com.pizza.exception.ApplicationException;
import com.pizza.input.PizzaInputData;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.Size;
import com.pizza.model.pizza.ingredients.AbstractPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.ChickenTikkaPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.PizzaIngredientsName;
import com.pizza.model.pizza.nonveg.ChickenTikkaPizzaModel;

public class ChickenTikkaPizzaModelBuilder extends AbstractPizzaModelBuilder<ChickenTikkaPizzaModel> {

    public static final double LARGE_PRICE = 2.383;
    public static final double MEDIUM_PRICE = 1.755;

    public ChickenTikkaPizzaModelBuilder(PizzaInputData pizza) {
        super(pizza);
    }

    @Override
    protected AbstractPizzaIngredientsModel buildPizzaIngredientModel() throws ApplicationException {
        ChickenTikkaPizzaIngredientsModel ingredientsModel = new ChickenTikkaPizzaIngredientsModel();
        addBasicIngredients(ingredientsModel);
        ingredientsModel.add(buildIngredientModel(PizzaIngredientsName.CORN.getName()));
        ingredientsModel.add(buildIngredientModel(PizzaIngredientsName.CHICKEN.getName()));
        ingredientsModel.add(buildIngredientModel(PizzaIngredientsName.GINGER_CHICKEN.getName()));
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
    protected ChickenTikkaPizzaModel createPizzaModel() {
        return new ChickenTikkaPizzaModel();
    }

    @Override
    protected IngredientType getPizzaType() {
        return IngredientType.NON_VEG;
    }
}
