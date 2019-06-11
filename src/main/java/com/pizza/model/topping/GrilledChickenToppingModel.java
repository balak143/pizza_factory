package com.pizza.model.topping;

public class GrilledChickenToppingModel extends AbstractToppingModel
    implements NonVegetarianToppingModel {
  public GrilledChickenToppingModel() {
    super.setName(ToppingName.GRILLED_CHICKEN.getName());
  }
}
