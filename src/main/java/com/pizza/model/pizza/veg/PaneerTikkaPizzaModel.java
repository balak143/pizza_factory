package com.pizza.model.pizza.veg;

import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.PizzaName;

public class PaneerTikkaPizzaModel extends AbstractPizzaModel implements VegetarianPizzaModel {
  public PaneerTikkaPizzaModel() {
    this.name = PizzaName.PANEER_TIKKA.getName();
  }

  @Override
  public IngredientType getPizzaType() {
    return IngredientType.VEG;
  }
}
