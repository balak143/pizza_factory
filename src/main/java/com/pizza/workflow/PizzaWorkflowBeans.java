package com.pizza.workflow;

import com.pizza.command.*;
import com.pizza.validator.order.PizzaOrderModelValidator;

import java.util.ArrayList;
import java.util.List;

public class PizzaWorkflowBeans {

    public List<Command> pizzaCost() {
        List<Command> chain = new ArrayList<>();
        chain.addAll(pizzaCreation());
        chain.add(new PizzaOrderCostCommand());
        return chain;
    }
    public List<Command> pizzaOrder() {
        List<Command> chain = new ArrayList<>();
        chain.addAll(pizzaInventoryUpdate());
        chain.add(new PizzaOrderPaymentCommand());
        chain.add(new InventoryUpdateCommand());
        chain.add(new PizzaOrderConfirmationCommand());
        return chain;
    }
    public List<Command> pizzaInventoryUpdate() {
        List<Command> chain = new ArrayList<>();
        chain.addAll(pizzaCost());
        chain.add(new InventoryUpdateCommand());
        return chain;
    }

    public List<Command> pizzaCreation() {
        List<Command> chain = new ArrayList<>();
        chain.add(new PizzaOrderModelBuilderCommand());
        chain.add(new PizzaOrderValidatorCommand());
        return chain;
    }
}
