package com.pizza.command;

import com.pizza.model.order.PizzaOrderModel;
import com.pizza.validator.inventory.KalyaniInventoryValidator;

import java.util.logging.Logger;

public class InventoryValidatorCommand implements Command {
    private static Logger logger = Logger.getLogger(InventoryValidatorCommand.class.getName());
    @Override
    public boolean execute(Context context) {
        KalyaniInventoryValidator validator = new KalyaniInventoryValidator();
        PizzaOrderModel pizzaOrderModel = (PizzaOrderModel)context.getData("PIZZA_ORDER_MODEL");
        validator.validate(pizzaOrderModel);
        return true;
    }
}
