package com.pizza.model.topping;

import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.PizzaName;

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

    public static ToppingName of(String name) {
        ToppingName toppingName = null;
        switch (name) {
            case "Black Olive":
                toppingName = BLACK_OLIVE;
                break;
            case "Capsicum":
                toppingName = CAPSICUM;
                break;
            case "Paneer":
                toppingName = PANEER;
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
        }
        return toppingName;
    }
}
