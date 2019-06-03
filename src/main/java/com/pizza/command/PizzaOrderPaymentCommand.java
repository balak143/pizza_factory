package com.pizza.command;

import com.pizza.model.order.PizzaOrderModel;

public class PizzaOrderPaymentCommand implements Command {
    PizzaOrderModel pizzaOrderModel;

    @Override
    public boolean execute(Context context) {
        return true;
    }
}
