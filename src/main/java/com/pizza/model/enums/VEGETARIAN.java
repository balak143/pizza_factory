package com.pizza.model.enums;

public enum VEGETARIAN {
    DeluxeVeggie("Deluxe Veggie"),
    CheeseAndCorn("Cheese and Corn"),
    PaneerTikka("Paneer Tikka");

    String name;

    VEGETARIAN(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}