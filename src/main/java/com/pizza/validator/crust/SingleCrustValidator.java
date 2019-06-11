package com.pizza.validator.crust;

import com.pizza.model.pizza.PizzaModel;

import java.util.logging.Logger;

public class SingleCrustValidator implements CrustModelValidator {
  private static final Logger LOGGER = Logger.getLogger(SingleCrustValidator.class.getName());

  @Override
  public void validate(PizzaModel pizzaModel) {
    LOGGER.info("");
  }
}
