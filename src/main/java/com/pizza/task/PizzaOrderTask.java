package com.pizza.task;

import com.pizza.command.Command;
import com.pizza.command.Context;
import com.pizza.input.PizzaOrderInputData;
import com.pizza.workflow.PizzaWorkflowBeans;

import java.util.List;

public class PizzaOrderTask extends PizzaTask {
    private PizzaOrderInputData pizzaOrderInputData;

    public PizzaOrderTask(PizzaOrderInputData pizzaOrderInputData) {
        this.pizzaOrderInputData = pizzaOrderInputData;
    }

    @Override
    protected Object execute() throws Exception {
        PizzaWorkflowBeans workflowBeans = new PizzaWorkflowBeans();
        List<Command> commands = workflowBeans.pizzaOrder();
        Context context = new Context();
        context.setData("PIZZA_ORDER_INPUT", pizzaOrderInputData);
        executeCommands(commands, context);
        return true;
    }
}
