package com.pizza.model.topping;

public enum ToppingName {
    BLACK_OLIVE("Black Olive"),
    CAPSICUM("Capsicum"),
    Paneer("Paneer"),
    MUSHROOM("Mushroom"),
    FRESH_TOMATO("Fresh Tomato"),
    // Non Veg
    CHICKEN_TIKKA("Chicken Tikka"),
    BARBEQUE_CHICKEN("Barbeque Chicken"),
    GRILLED_CHICKEN("Grilled Chicken"),
    // Extra Cheese
    EXTRA_CHEESE("Extra Cheese");

    String name = null;

    ToppingName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ToppingName of(String name) {
        ToppingName toppingName = BLACK_OLIVE;
        switch (name) {
            case "Black Olive":
                toppingName = BLACK_OLIVE;
                break;
            case "Capsicum":
                toppingName = CAPSICUM;
                break;
            case "Paneer":
                toppingName = Paneer;
                break;
            case "Mushroom":
                toppingName = MUSHROOM;
                break;
            case "Fresh Tomato":
                toppingName = FRESH_TOMATO;
                break;
            case "Chicken Tikka":
                toppingName = CHICKEN_TIKKA;
                break;
            case "Barbeque Chicken":
                toppingName = BARBEQUE_CHICKEN;
                break;
            case "Grilled Chicken":
                toppingName = GRILLED_CHICKEN;
                break;
            case "Extra Cheese":
                toppingName = EXTRA_CHEESE;
                break;

        }
        return toppingName;
    }
}
