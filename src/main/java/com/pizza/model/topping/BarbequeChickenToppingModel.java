package com.pizza.model.topping;

public class BarbequeChickenToppingModel extends AbstractToppingModel
    implements NonVegetarianToppingModel {
  public BarbequeChickenToppingModel() {
    this.name = ToppingName.BARBEQUE_CHICKEN.getName();
  }
}
