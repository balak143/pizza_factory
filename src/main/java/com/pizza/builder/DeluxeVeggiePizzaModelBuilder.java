package com.pizza.builder;

import com.pizza.exception.ApplicationException;
import com.pizza.input.PizzaInputData;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.Size;
import com.pizza.model.pizza.ingredients.AbstractPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.DeluxeVeggiePizzaIngredientsModel;
import com.pizza.model.pizza.veg.DeluxeVeggiePizzaModel;

public class DeluxeVeggiePizzaModelBuilder
    extends AbstractPizzaModelBuilder<DeluxeVeggiePizzaModel> {

  public static final double LARGE_PRICE = 2.168;
  public static final double MEDIUM_PRICE = 1.338;

  public DeluxeVeggiePizzaModelBuilder(PizzaInputData pizzaInputData) {
    super(pizzaInputData);
  }

  @Override
  protected AbstractPizzaIngredientsModel buildPizzaIngredientModel() throws ApplicationException {
    DeluxeVeggiePizzaIngredientsModel ingredientsModel = new DeluxeVeggiePizzaIngredientsModel();
    addBasicIngredients(ingredientsModel);
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
  protected DeluxeVeggiePizzaModel createPizzaModel() {
    return new DeluxeVeggiePizzaModel();
  }

  @Override
  protected IngredientType getPizzaType() {
    return IngredientType.VEG;
  }
}
