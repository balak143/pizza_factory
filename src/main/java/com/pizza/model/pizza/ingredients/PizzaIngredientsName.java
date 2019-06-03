package com.pizza.model.pizza.ingredients;

public enum PizzaIngredientsName {

    SAUCE("Sauce"),
    CHEESE("Cheese"),
    PEPERONI("Pepperoni"),
    RED_PEPPER("Red Pepper"),
    OREGANO("Oregano"),
    GARLIC("Garlic");

    private String name = null;

    PizzaIngredientsName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static PizzaIngredientsName of(String name) {
        PizzaIngredientsName crustName = null;
        switch (name) {
            case "Sauce":
                crustName = SAUCE;
                break;
            case "Cheese":
                crustName = CHEESE;
                break;
            case "Pepperoni":
                crustName = PEPERONI;
                break;
            case "Red Pepper":
                crustName = RED_PEPPER;
                break;
            case "Oregano":
                crustName = OREGANO;
                break;
            case "Garlic":
                crustName = GARLIC;
                break;
        }
        return crustName;
    }

}
