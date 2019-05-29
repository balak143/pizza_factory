package com.pizza.model.enums;

public enum NONVEGTOPPING //implements ToppingModel
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