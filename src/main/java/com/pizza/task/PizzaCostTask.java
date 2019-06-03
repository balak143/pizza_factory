package com.pizza.task;

import com.pizza.cache.CostDataLoader;
import com.pizza.cache.CostMemoryGrid;
import com.pizza.cache.GridManager;
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
        // Initial Grid. ideally this should happen on the Server startup
        CostMemoryGrid costMemoryGrid = new CostMemoryGrid(new CostDataLoader());
        costMemoryGrid.createDataMap();
        GridManager gridManager = GridManager.getInstance();
        gridManager.registerGrid(costMemoryGrid);

        List<Command> commands = workflowBeans.pizzaCost();
        Context context = new Context();
        context.setData("PIZZA_ORDER_INPUT", pizzaOrderInputData);
        executeCommands(commands, context);
        List<Price> prices = (List<Price>) context.getData("ORDER_PRICE");
        System.out.println(prices);
        return null;
    }


}
