package com.pizza.command;

import com.pizza.builder.BuildContext;
import com.pizza.model.order.PizzaOrderModel;
import com.pizza.utils.OrderRef;

public class PizzaOrderConfirmationCommand implements Command {

    @Override
    public boolean execute(Context context) {
        PizzaOrderModel pizzaOrderModel = (PizzaOrderModel) context.getData("PIZZA_ORDER_MODEL");
        System.out.println(" Your Order is placed successfully ");
        System.out.println(" Please keep the Order Reference - " + new OrderRef().getReference());
        return true;
    }
}
