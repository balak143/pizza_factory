package com.pizza.model.pizza.ingredients;

public enum PizzaIngredientsName {

    SAUCE("Sauce"),
    CHEESE("Cheese"),
    CORN("Corn"),
    PANEER_CHOP("Paneer Chop"),
    PEPPERONI("Pepperoni"),
    CHICKEN("Chicken"),
    RED_MEAT("Red meat"),
    GINGER_CHICKEN("Ginger Chicken"),
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
                return SAUCE;
            case "Cheese":
                return CHEESE;
            case "Corn":
                return CORN;
            case "Pepperoni":
                return PEPPERONI;
            case "Red Pepper":
                return RED_PEPPER;
            case "Oregano":
                return OREGANO;
            case "Garlic":
                return GARLIC;
            case "Paneer":
                return PANEER_CHOP;
            case "Grill Chicken":
                return CHICKEN;
            case "Red meat":
                return RED_MEAT;
            case "Ginger Chicken":
                return GINGER_CHICKEN;
        }
        throw new RuntimeException(" Pizza Ingredients - '" + name + "'  is not available in store");
    }

}
