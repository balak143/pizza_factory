package com.pizza.model.topping;

public enum ToppingName {
    BLACK_OLIVE("Black Olive"),
    CAPSICUM("Capsicum"),
    PANEER("Paneer"),
    MUSHROOM("Mushroom"),
    FRESH_TOMATO("Fresh Tomato"),
    // Non Veg
    CHICKEN_TIKKA("Chicken Tikka"),
    BARBEQUE_CHICKEN("Barbeque Chicken"),
    GRILLED_CHICKEN("Grilled Chicken"),
    // Extra Cheese
    EXTRA_CHEESE("Extra Cheese");

    private String name = null;

    ToppingName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
