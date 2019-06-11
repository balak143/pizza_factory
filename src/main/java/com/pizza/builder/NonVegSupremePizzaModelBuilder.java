package com.pizza.builder;

import com.pizza.exception.ApplicationException;
import com.pizza.input.PizzaInputData;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.Size;
import com.pizza.model.pizza.ingredients.AbstractPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.NonVegSupremePizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.PizzaIngredientsName;
import com.pizza.model.pizza.nonveg.NonVegSupremePizzaModel;

public class NonVegSupremePizzaModelBuilder extends AbstractPizzaModelBuilder {

  public static final double LARGE_PRICE = 2.24;
  public static final double MEDIUM_PRICE = 1.712;

  public NonVegSupremePizzaModelBuilder(PizzaInputData pizzaInputData) {
    super(pizzaInputData);
  }

  @Override
  protected AbstractPizzaIngredientsModel buildPizzaIngredientModel() throws ApplicationException {
    NonVegSupremePizzaIngredientsModel ingredientsModel = new NonVegSupremePizzaIngredientsModel();
    addBasicIngredients(ingredientsModel);
    ingredientsModel.add(buildIngredientModel(PizzaIngredientsName.CORN.getName()));
    ingredientsModel.add(buildIngredientModel(PizzaIngredientsName.CHICKEN.getName()));
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
  protected AbstractPizzaModel createPizzaModel() {
    return new NonVegSupremePizzaModel();
  }

  @Override
  protected IngredientType getPizzaType() {
    return IngredientType.NON_VEG;
  }
}
