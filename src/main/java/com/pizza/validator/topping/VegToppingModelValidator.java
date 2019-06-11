package com.pizza.validator.topping;

import com.pizza.model.pizza.PizzaModel;

import java.util.logging.Logger;

public class VegToppingModelValidator implements ToppingModelValidator {
  private static final Logger LOGGER = Logger.getLogger(VegToppingModelValidator.class.getName());

  @Override
  public void validate(PizzaModel pizzaModel) {
    LOGGER.info("Left intended ");
  }
}
