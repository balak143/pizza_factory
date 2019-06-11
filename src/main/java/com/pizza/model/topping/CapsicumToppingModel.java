package com.pizza.model.topping;

public class CapsicumToppingModel extends AbstractToppingModel implements VegetarianToppingModel {
    public CapsicumToppingModel() {
        super.setName(ToppingName.CAPSICUM.getName());
    }
}
