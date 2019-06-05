package com.pizza.model.pizza.ingredients;

public enum PizzaIngredientsName {

    SAUCE("Sauce"),
    CHEESE("Cheese"),
    CORN("Corn"),
    PANEER_CHOP("Paneer Chop"),
    PEPPERONI("Pepperoni"),
    CHICKEN("Chicken"),
    RED_MEAT("Red meat"),
    FISH("Fish"),
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
        PizzaIngredientsName ingredientsName = null;
        switch (name) {
            case "Sauce":
                ingredientsName = SAUCE;
                break;
            case "Cheese":
                ingredientsName = CHEESE;
                break;
            case "Corn":
                ingredientsName = CORN;
                break;
            case "Pepperoni":
                ingredientsName = PEPPERONI;
                break;
            case "Red Pepper":
                ingredientsName = RED_PEPPER;
                break;
            case "Oregano":
                ingredientsName = OREGANO;
                break;
            case "Garlic":
                ingredientsName = GARLIC;
                break;
            case "Paneer":
                ingredientsName = PANEER_CHOP;
                break;
            case "Grill Chicken":
                ingredientsName = CHICKEN;
                break;
            case "Red meat":
                ingredientsName = RED_MEAT;
                break;
            case "Fish":
                ingredientsName = FISH;
                break;
        }
        return ingredientsName;
    }

}
