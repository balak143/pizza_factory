package com.pizza.task;

import com.pizza.command.Command;
import com.pizza.command.Context;
import com.pizza.input.PizzaOrderInputData;
import com.pizza.utils.Price;
import com.pizza.workflow.PizzaWorkflowBeans;

import java.util.List;
import java.util.logging.Logger;

public class PizzaCostTask extends PizzaTask {
  private static final Logger LOGGER = Logger.getLogger(PizzaCostTask.class.getName());

  private PizzaOrderInputData pizzaOrderInputData;

  public PizzaCostTask(PizzaOrderInputData pizzaOrderInputData) {
    this.pizzaOrderInputData = pizzaOrderInputData;
  }

  @Override
  protected Object execute() {
    PizzaWorkflowBeans workflowBeans = new PizzaWorkflowBeans();
    List<Command> commands = workflowBeans.pizzaCost();
    Context context = new Context();
    context.setData("PIZZA_ORDER_INPUT", pizzaOrderInputData);
    executeCommands(commands, context);
    List<Price> prices = (List<Price>) context.getData("ORDER_PRICE");
    LOGGER.info(prices.toString());
    return null;
  }
}
