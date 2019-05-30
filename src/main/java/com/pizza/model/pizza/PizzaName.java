package com.pizza.model.pizza;

public enum PizzaName {
    DELUXE_VEGGIE("Deluxe Veggie"),
    CHEESE_CORN("Cheese And Corn"),
    PANEER_TIKKA("Paneer Tikka"),
    // Non Veg
    NONVEG_SUPREME("Non-Veg Supreme"),
    CHICKEN_TIKKA("Chicken Tikka"),
    PEPPER_BARBECUE("Pepper Barbecue");

    private String name = null;

    PizzaName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
