package com.pizza.model.crust;

public enum CrustName {
    NEWHANDTOSSED("New Hand Tossed"),
    WHEATTHINCRUST("Wheat Thin"),
    CHEESEBURST("Cheese Burst"),
    FRESHPANPIZZA("FreshPanCrustModel");

    private String name = null;

    CrustName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
