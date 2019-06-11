package com.pizza.command;

import java.util.logging.Logger;

public class PizzaOrderPaymentCommand implements Command {
  private static final Logger LOGGER = Logger.getLogger(PizzaOrderPaymentCommand.class.getName());
  @Override
  public boolean execute(Context context) {
    LOGGER.info(" Payment is being processed....");
    LOGGER.info(" Payment is successful");
    return true;
  }
}
