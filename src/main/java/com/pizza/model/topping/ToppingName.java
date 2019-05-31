package com.pizza.model.topping;

import com.pizza.model.ingredient.IngredientType;

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
}
