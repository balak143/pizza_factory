package com.pizza.model.pizza;

public enum PizzaName {
  DELUXE_VEGGIE("Deluxe Veggie"),
  CHEESE_CORN("Cheese And Corn"),
  PANEER_TIKKA("Paneer Tikka"),
  // Non Veg
  NONVEG_SUPREME("Non-Veg Supreme"),
  CHICKEN_TIKKA("Chicken Tikka"),
  PEPPER_BARBECUE("Pepper Barbecue");

  private String name = null;

  PizzaName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public static PizzaName of(String name) {
    if (name == null) {
      throw new IllegalArgumentException("Provide Pizza Name");
    }
    switch (name) {
      case "Deluxe Veggie":
        return DELUXE_VEGGIE;
      case "Cheese And Corn":
        return CHEESE_CORN;
      case "Paneer Tikka":
        return PANEER_TIKKA;
      case "Non-Veg Supreme":
        return NONVEG_SUPREME;
      case "Chicken Tikka":
        return CHICKEN_TIKKA;
      case "Pepper Barbecue":
        return PEPPER_BARBECUE;
    }
    throw new IllegalArgumentException("Pizza - '" + name + "' is not available in store");
  }
}
