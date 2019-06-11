package com.pizza.model.topping;

public class FreshTomatoToppingModel extends AbstractToppingModel
    implements VegetarianToppingModel {
  public FreshTomatoToppingModel() {
    super.setName(ToppingName.FRESH_TOMATO.getName());
  }
}
