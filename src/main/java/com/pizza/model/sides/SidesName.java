package com.pizza.model.sides;

import com.pizza.model.pizza.PizzaName;

public enum SidesName {
    COLD_DRINK("Cold Drink"),
    MOUSSE_CAKE("Mousse Cake");

    private String name;

    SidesName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static SidesName of(String name) {
        if ("Cold Drink".equals(name)) {
            return COLD_DRINK;
        } else if ("Mousse Cake".equals(name)) {
            return MOUSSE_CAKE;
        }
        return null;
    }
}