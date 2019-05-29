package com.pizza.order.model.enums;

public enum NONVEGETARIAN {
    NonVegSupreme("Non-Veg Supreme"),
    ChickenTikka("Chicken Tikka"),
    PepperBarbecue("Pepper Barbecue");

    String name;

    NONVEGETARIAN(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}