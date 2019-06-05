package com.pizza.command;

import com.pizza.builder.BuildContext;
import com.pizza.builder.KalyaniPizzaStoreOrderModelBuilder;
import com.pizza.builder.PizzaModelBuilder;
import com.pizza.builder.SidesModelBuilder;
import com.pizza.builder.factory.PizzaModelBuilderFactory;
import com.pizza.builder.factory.SidesModelBuilderFactory;
import com.pizza.exception.ApplicationException;
import com.pizza.exception.ThrowingConsumer;
import com.pizza.input.PizzaOrderInputData;
import com.pizza.model.order.KalyaniPizzaStoreOrderModel;
import com.pizza.model.order.PizzaOrderModel;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.PizzaModel;
import com.pizza.model.sides.AbstractSidesModel;

import java.util.List;
import java.util.logging.Logger;

public class PizzaOrderModelBuilderCommand implements Command {
    private static Logger logger = Logger.getLogger(PizzaOrderModelBuilderCommand.class.getName());
    @Override
    public boolean execute(Context context) {
        PizzaOrderInputData pizzaOrderInputData = (PizzaOrderInputData)context.getData("PIZZA_ORDER_INPUT");
        KalyaniPizzaStoreOrderModelBuilder orderModelBuilder = new KalyaniPizzaStoreOrderModelBuilder();

        BuildContext buildContext = new BuildContext();
        buildContext.setPizzaOrderInputData(pizzaOrderInputData);

        KalyaniPizzaStoreOrderModel pizzaOrderModel = orderModelBuilder.build(buildContext);
        logger.info(pizzaOrderModel.toString());

        context.setData("PIZZA_ORDER_MODEL", pizzaOrderModel);
        return true;
    }
}
