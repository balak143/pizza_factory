package com.pizza.model.enums;

public enum VEGTOPPING //implements ToppingModel
{
    BlackOlive("Black Olive"),
    Capsicum("Capsicum"),
    Paneer("Paneer"),
    Mushroom("Mushroom"),
    FreshTomato("Fresh Tomato");

    String name;
    VEGTOPPING(String name) {
        this.name = name;
    }

/*
    @Override
    public Double getCost() {
        return PriceDAO.getToppingPrice(this);
    }
*/

    public String getName() {
        return this.name;
    }
}

