package com.pizza.command;

import com.pizza.model.order.PizzaOrderModel;

public class PizzaOrderPaymentCommand implements Command {

  @Override
  public boolean execute(Context context) {
    System.out.println(" Payment is being processed....");
    System.out.println(" Payment is successful");
    return true;
  }
}
