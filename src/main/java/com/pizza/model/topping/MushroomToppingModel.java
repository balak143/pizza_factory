package com.pizza.model.topping;

public class MushroomToppingModel extends AbstractToppingModel implements VegetarianToppingModel {
  public MushroomToppingModel() {
    super.setName(ToppingName.MUSHROOM.getName());
  }
}
