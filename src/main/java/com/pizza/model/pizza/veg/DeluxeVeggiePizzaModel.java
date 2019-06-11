package com.pizza.model.pizza.veg;

import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.PizzaName;

public class DeluxeVeggiePizzaModel extends AbstractPizzaModel implements VegetarianPizzaModel {
  public DeluxeVeggiePizzaModel() {
    this.name = PizzaName.DELUXE_VEGGIE.getName();
  }

  @Override
  public IngredientType getPizzaType() {
    return IngredientType.VEG;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
