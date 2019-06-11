package com.pizza.builder;

import com.pizza.exception.ApplicationException;
import com.pizza.input.PizzaInputData;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.Size;
import com.pizza.model.pizza.ingredients.AbstractPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.PepperBarbecueChickenPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.PizzaIngredientsName;
import com.pizza.model.pizza.nonveg.PepperBarbecueChickenPizzaModel;

public class PepperBarbecueChickenPizzaModelBuilder
    extends AbstractPizzaModelBuilder<PepperBarbecueChickenPizzaModel> {

  public static final double LARGE_PRICE = 2.39;
  public static final double MEDIUM_PRICE = 1.73;

  public PepperBarbecueChickenPizzaModelBuilder(PizzaInputData pizzaInputData) {
    super(pizzaInputData);
  }

  @Override
  protected AbstractPizzaIngredientsModel buildPizzaIngredientModel() throws ApplicationException {
    PepperBarbecueChickenPizzaIngredientsModel ingredientsModel =
        new PepperBarbecueChickenPizzaIngredientsModel();
    addBasicIngredients(ingredientsModel);
    ingredientsModel.add(buildIngredientModel(PizzaIngredientsName.CORN.getName()));
    ingredientsModel.add(buildIngredientModel(PizzaIngredientsName.CHICKEN.getName()));
    ingredientsModel.add(buildIngredientModel(PizzaIngredientsName.RED_MEAT.getName()));
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
  protected PepperBarbecueChickenPizzaModel createPizzaModel() {
    return new PepperBarbecueChickenPizzaModel();
  }

  @Override
  protected IngredientType getPizzaType() {
    return IngredientType.NON_VEG;
  }
}
