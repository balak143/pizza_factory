package com.pizza.task;

import com.pizza.command.Command;
import com.pizza.command.Context;
import com.pizza.input.PizzaOrderInputData;
import com.pizza.utils.Price;
import com.pizza.workflow.PizzaWorkflowBeans;

import java.util.List;

public class PizzaCostTask extends PizzaTask {
  private PizzaOrderInputData pizzaOrderInputData;

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
