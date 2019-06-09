package com.pizza.task;

import com.pizza.grid.CostDataLoader;
import com.pizza.grid.CostMemoryGrid;
import com.pizza.grid.GridManager;
import com.pizza.command.Command;
import com.pizza.command.Context;
import com.pizza.input.PizzaOrderInputData;
import com.pizza.utils.Price;
import com.pizza.workflow.PizzaWorkflowBeans;

import java.util.List;

public class PizzaCostTask extends PizzaTask {
    PizzaOrderInputData pizzaOrderInputData;

    public PizzaCostTask(PizzaOrderInputData pizzaOrderInputData) {
        this.pizzaOrderInputData = pizzaOrderInputData;
    }

    @Override
    protected Object execute() throws Exception {
        PizzaWorkflowBeans workflowBeans = new PizzaWorkflowBeans();
        List<Command> commands = workflowBeans.pizzaCost();
        Context context = new Context();
        context.setData("PIZZA_ORDER_INPUT", pizzaOrderInputData);
        executeCommands(commands, context);
        List<Price> prices = (List<Price>) context.getData("ORDER_PRICE");
        System.out.println(prices);
        return null;
    }


}
