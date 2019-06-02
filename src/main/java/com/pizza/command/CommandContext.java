package com.pizza.command;

import com.pizza.builder.BuildContext;
import com.pizza.model.order.PizzaOrderModel;

public class CommandContext {
    private BuildContext buildContext;
    private PizzaOrderModel pizzaOrderModel;

    public BuildContext getBuildContext() {
        return buildContext;
    }

    public void setBuildContext(BuildContext buildContext) {
        this.buildContext = buildContext;
    }

    public PizzaOrderModel getPizzaOrderModel() {
        return pizzaOrderModel;
    }

    public void setPizzaOrderModel(PizzaOrderModel pizzaOrderModel) {
        this.pizzaOrderModel = pizzaOrderModel;
    }
}
