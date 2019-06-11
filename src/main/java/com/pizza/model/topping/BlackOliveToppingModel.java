package com.pizza.model.topping;

public class BlackOliveToppingModel extends AbstractToppingModel implements VegetarianToppingModel {
    public BlackOliveToppingModel() {
        this.name =ToppingName.BLACK_OLIVE.getName();
    }
}
