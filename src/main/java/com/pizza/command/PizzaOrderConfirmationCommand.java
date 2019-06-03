package com.pizza.command;

import com.pizza.builder.BuildContext;
import com.pizza.model.order.PizzaOrderModel;

public class PizzaOrderConfirmationCommand implements Command {

    @Override
    public boolean execute(Context context) {

        return true;
    }
}
