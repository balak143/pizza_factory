package com.pizza.model.pizza.nonveg;

import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.PizzaName;

public class PepperBarbecueChickenPizzaModel extends AbstractPizzaModel
    implements NonVegetarianPizzaModel {
  public PepperBarbecueChickenPizzaModel() {
    this.name = PizzaName.PEPPER_BARBECUE.getName();
  }

  @Override
  public IngredientType getPizzaType() {
    return IngredientType.NON_VEG;
  }
}
