package com.pizza.command;

import com.pizza.builder.BuildContext;
import com.pizza.model.cost.PizzaOrderCostModel;
import com.pizza.model.order.PizzaOrderModel;

import java.util.Date;

public class PizzaOrderCostCommand implements Command {
    @Override
    public void execute(CommandContext context) {
        PizzaOrderModel pizzaOrderModel = context.getPizzaOrderModel();
        PizzaOrderCostModel pizzaOrderCostModel = new PizzaOrderCostModel(pizzaOrderModel);
        pizzaOrderCostModel.cost(new Date());

    }
}
