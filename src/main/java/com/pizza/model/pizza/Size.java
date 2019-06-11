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
      throw new IllegalArgumentException("Please provide Pizza size");
    }
    switch (name) {
      case "Medium":
        return MEDIUM;
      case "Large":
        return LARGE;
      case "Regular":
        return REGULAR;
      default:
    }
    throw new IllegalArgumentException(" Size - '" + name + "'  is not valid");
  }
}
