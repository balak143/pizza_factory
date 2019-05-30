package com.pizza.model.crust;

public enum CRUST  {
    NewHandTossed("New Hand Tossed"),
    WheatThinCrust("Wheat Thin"),
    CheeseBurst("Cheese Burst"),
    FreshPanPizza("FreshPanPizza");
    String name;
    CRUST(String name) {
        this.name = name;
    }

    public String getName() {
    return this.name;
    }

}
