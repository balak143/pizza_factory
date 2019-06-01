package com.pizza.model.pizza;

public enum Size {
    MEDIUM("Medium"),
    LARGE("Large"),
    REGULAR("Regular");

    private String name;

    Size(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Size of(String name) {
        Size size = null;
        switch (name) {
            case "Medium":
                size = MEDIUM;
                break;
            case "Large":
                size = LARGE;
                break;
            case "Regular":
                size = REGULAR;
                break;
        }
        return size;
    }
}