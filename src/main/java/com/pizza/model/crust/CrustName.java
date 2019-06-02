package com.pizza.model.crust;

import com.pizza.exception.ApplicationException;

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

    public static CrustName of(String name) throws ApplicationException {
        CrustName crustName = null;
        switch (name) {
            case "New Hand Tossed":
                return NEW_HAND_TOSSED;
            case "Wheat Thin":
                return  WHEAT_THIN_CRUST;
            case "Cheese Burst":
                return  CHEESE_BURST;
            case "Fresh Pan Pizza":
                crustName = FRESH_PAN_PIZZA;
                break;
        }
        throw new ApplicationException(" Crust - "+name +" is not a valid enum constant");
    }

}
