package com.pizza.order.model.enums;

public enum NONVEGTOPPING //implements Topping
{
    ChickenTikka("Chicken Tikka"),
    BarbequeChicken("Barbeque Chicken"),
    GrilledChicken("Grilled Chicken");

    String name;

    NONVEGTOPPING(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
};