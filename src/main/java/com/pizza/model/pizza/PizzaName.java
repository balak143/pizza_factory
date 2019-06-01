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

    public static PizzaName of(String name) {
        PizzaName pizzaName = null;
        switch (name) {
            case "Deluxe Veggie":
                pizzaName = DELUXE_VEGGIE;
                break;
            case "Cheese And Corn":
                pizzaName = CHEESE_CORN;
                break;
            case "Paneer Tikka":
                pizzaName = PANEER_TIKKA;
                break;
            case "Non-Veg Supreme":
                pizzaName = NONVEG_SUPREME;
                break;
            case "Chicken Tikka":
                pizzaName = CHICKEN_TIKKA;
                break;
            case "Pepper Barbecue":
                pizzaName = PEPPER_BARBECUE;
                break;
        }
        return pizzaName;
    }
}
