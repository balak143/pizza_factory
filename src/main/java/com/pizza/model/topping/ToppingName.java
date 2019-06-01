package com.pizza.model.topping;

import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.PizzaName;

public enum ToppingName {
    BLACK_OLIVE("Black Olive", IngredientType.VEG),
    CAPSICUM("Capsicum", IngredientType.VEG),
    PANEER("Paneer", IngredientType.VEG),
    MUSHROOM("Mushroom", IngredientType.VEG),
    FRESH_TOMATO("Fresh Tomato", IngredientType.VEG),
    // Non Veg
    CHICKEN_TIKKA("Chicken Tikka", IngredientType.VEG),
    BARBEQUE_CHICKEN("Barbeque Chicken", IngredientType.VEG),
    GRILLED_CHICKEN("Grilled Chicken", IngredientType.VEG),
    // Extra Cheese
    EXTRA_CHEESE("Extra Cheese", IngredientType.VEG);

    private String name = null;
    private IngredientType type;

    ToppingName(String name, IngredientType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public IngredientType getType() {
        return type;
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
