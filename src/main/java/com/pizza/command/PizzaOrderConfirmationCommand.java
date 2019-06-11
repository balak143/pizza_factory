package com.pizza.command;

import com.pizza.utils.OrderRef;

public class PizzaOrderConfirmationCommand implements Command {

  @Override
  public boolean execute(Context context) {
    System.out.println(" Your Order is placed successfully ");
    System.out.println(
        " Please keep the Order Number for reference - " + new OrderRef().getReference());
    return true;
  }
}
