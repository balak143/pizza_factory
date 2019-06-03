package com.pizza.command;

import com.pizza.exception.ApplicationException;
import com.pizza.input.PizzaOrderInputData;
import com.pizza.model.order.PizzaOrderModel;

public class PizzaOrderValidatorCommand implements Command {

    @Override
    public boolean execute(Context context) {
        PizzaOrderInputData pizzaOrderInputData = (PizzaOrderInputData)context.getData("PIZZA_ORDER_INPUT");
        PizzaOrderModel pizzaOrderModel = (PizzaOrderModel)context.getData("PIZZA_ORDER_MODEL");

        return true;
    }
}
