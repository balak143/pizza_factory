package com.pizza.model.topping;

public class ChickenTikkaToppingModel extends AbstractToppingModel implements NonVegetarianToppingModel {
    public ChickenTikkaToppingModel() {
        super.setName(ToppingName.CHICKEN_TIKKA.getName());
    }
}
