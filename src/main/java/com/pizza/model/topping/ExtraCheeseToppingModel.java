package com.pizza.model.topping;

public class ExtraCheeseToppingModel extends AbstractToppingModel
    implements VegetarianToppingModel {
  public ExtraCheeseToppingModel() {
    super.setName(ToppingName.EXTRA_CHEESE.getName());
  }
}
