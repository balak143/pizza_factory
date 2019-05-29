package com.pizza.order.model.enums;

public enum SIDE //implements Topping
{
    ColdDrink("Cold Drink"),
    MousseCake("Mousse Cake");

    String name;
    SIDE(String name){
        this.name =name;
    }

    public String getName() {
        return name;
    }
};