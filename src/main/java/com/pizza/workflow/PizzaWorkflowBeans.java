package com.pizza.workflow;

import com.pizza.command.Command;
import com.pizza.command.InventoryUpdateCommand;
import com.pizza.command.PizzaOrderCostCommand;
import com.pizza.command.PizzaOrderModelBuilderCommand;
import com.pizza.command.PizzaOrderValidatorCommand;
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

    public List<Command> pizzaInventoryUpdate() {
        List<Command> chain = new ArrayList<>();
        chain.addAll(pizzaCreation());
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
