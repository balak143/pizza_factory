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
        if (name == null) {
            throw new RuntimeException("Please provide Pizza size");
        }
        Size size = null;
        switch (name) {
            case "Medium":
                return MEDIUM;
            case "Large":
                return LARGE;
            case "Regular":
                return REGULAR;
        }
        throw new RuntimeException(" Size - '" + name + "'  is not valid");
    }
}