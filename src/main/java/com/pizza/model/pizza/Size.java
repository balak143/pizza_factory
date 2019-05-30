package com.pizza.model.pizza;

public enum Size {
    MEDIUM("Medium"),
    LARGE("Large"),
    REGULAR("Regular");

    String name ;
    Size(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}