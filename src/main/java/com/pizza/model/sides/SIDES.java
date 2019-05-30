package com.pizza.model.sides;

public enum SIDES //implements ToppingModel
{
    COLDD_RINK("Cold Drink"),
    MOUSSE_CAKE("Mousse Cake");

    String name;
    SIDES(String name){
        this.name =name;
    }

    public String getName() {
        return name;
    }
};