package com.pizza.model.sides;

public enum SIDES //implements ToppingModel
{
    ColdDrink("Cold Drink"),
    MousseCake("Mousse Cake");

    String name;
    SIDES(String name){
        this.name =name;
    }

    public String getName() {
        return name;
    }
};