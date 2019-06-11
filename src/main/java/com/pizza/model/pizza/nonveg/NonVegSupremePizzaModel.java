package com.pizza.model.pizza.nonveg;

import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.PizzaName;

public class NonVegSupremePizzaModel extends AbstractPizzaModel implements NonVegetarianPizzaModel {
  public NonVegSupremePizzaModel() {
    this.name = PizzaName.NONVEG_SUPREME.getName();
  }

  @Override
  public IngredientType getPizzaType() {
    return IngredientType.NON_VEG;
  }
}
