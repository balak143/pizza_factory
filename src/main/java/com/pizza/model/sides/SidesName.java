package com.pizza.model.sides;

public enum SidesName {
    COLDD_RINK("Cold Drink"),
    MOUSSE_CAKE("Mousse Cake");

    private String name;

    SidesName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}