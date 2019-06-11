package com.pizza.command;

import com.pizza.builder.BuildContext;
import com.pizza.builder.DominosPizzaStoreOrderModelBuilder;
import com.pizza.input.PizzaOrderInputData;
import com.pizza.model.order.DominosPizzaStoreOrderModel;

import java.util.logging.Logger;

public class PizzaOrderModelBuilderCommand implements Command {
  private static final Logger LOGGER = Logger.getLogger(PizzaOrderModelBuilderCommand.class.getName());

  @Override
  public boolean execute(Context context) {
    PizzaOrderInputData pizzaOrderInputData =
        (PizzaOrderInputData) context.getData("PIZZA_ORDER_INPUT");
    DominosPizzaStoreOrderModelBuilder orderModelBuilder = new DominosPizzaStoreOrderModelBuilder();

    BuildContext buildContext = new BuildContext();
    buildContext.setPizzaOrderInputData(pizzaOrderInputData);

    DominosPizzaStoreOrderModel pizzaOrderModel = orderModelBuilder.build(buildContext);
    LOGGER.info(pizzaOrderModel.toString());

    context.setData("PIZZA_ORDER_MODEL", pizzaOrderModel);
    return true;
  }
}
