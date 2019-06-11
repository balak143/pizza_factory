package com.pizza.command;

import com.pizza.model.order.PizzaOrderModel;
import com.pizza.validator.inventory.DominosInventoryValidator;

public class InventoryValidatorCommand implements Command {

  @Override
  public boolean execute(Context context) {
    DominosInventoryValidator validator = new DominosInventoryValidator();
    PizzaOrderModel pizzaOrderModel = (PizzaOrderModel) context.getData("PIZZA_ORDER_MODEL");
    validator.validate(pizzaOrderModel);
    return true;
  }
}
