package com.pizza.model.crust;

public enum CrustName {
    NEW_HAND_TOSSED("New Hand Tossed"),
    WHEAT_THIN_CRUST("Wheat Thin"),
    CHEESE_BURST("Cheese Burst"),
    FRESH_PAN_PIZZA("Fresh Pan Pizza");

    private String name = null;

    CrustName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CrustName of(String name) {
        CrustName crustName = null;
        switch (name) {
            case "New Hand Tossed":
                crustName = NEW_HAND_TOSSED;
                break;
            case "Wheat Thin":
                crustName = WHEAT_THIN_CRUST;
                break;
            case "Cheese Burst":
                crustName = CHEESE_BURST;
                break;
            case "Fresh Pan Pizza":
                crustName = FRESH_PAN_PIZZA;
                break;
        }
        return crustName;
    }

}
