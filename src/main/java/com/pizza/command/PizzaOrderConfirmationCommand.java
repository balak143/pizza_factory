package com.pizza.command;

import com.pizza.utils.OrderRef;

import java.util.logging.Logger;

public class PizzaOrderConfirmationCommand implements Command {
  private static final Logger LOGGER =
      Logger.getLogger(PizzaOrderConfirmationCommand.class.getName());

  @Override
  public boolean execute(Context context) {
    LOGGER.info(" Your Order is placed successfully ");
    LOGGER.info(" Please keep the Order Number for reference - " + new OrderRef().getReference());
    return true;
  }
}
