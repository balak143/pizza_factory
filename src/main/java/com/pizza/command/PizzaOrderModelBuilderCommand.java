package com.pizza.command;

import com.pizza.builder.BuildContext;
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

public class PizzaOrderModelBuilderCommand implements Command {
    @Override
    public void execute(CommandContext context) throws ApplicationException {
        KalyaniPizzaStoreOrderModel pizzaOrderModel = new KalyaniPizzaStoreOrderModel();
        BuildContext buildContext = context.getBuildContext();
        PizzaOrderInputData pizzaOrderInputData = buildContext.getPizzaOrderInputData();
        pizzaOrderInputData.getPizzaInputData().forEach(pizzaInputData -> {
                    PizzaModelBuilder modelBuilder = PizzaModelBuilderFactory.getInstance()
                            .getBuilder(pizzaInputData);
                    try {
                        AbstractPizzaModel pizzaModel = modelBuilder.build(buildContext);
                        pizzaOrderModel.addPizzaModel(pizzaModel);
                    } catch (ApplicationException e) {
                        ThrowingConsumer.sneakyThrow(e);
                    }
                }
        );
        pizzaOrderInputData.getSides().forEach(pizzaInputData -> {
                    SidesModelBuilder modelBuilder = SidesModelBuilderFactory.getInstance()
                            .getBuilder(pizzaInputData);
                        AbstractSidesModel pizzaModel = modelBuilder.build(buildContext);
                        pizzaOrderModel.addSidesModel(pizzaModel);
                }
        );
        context.setPizzaOrderModel(pizzaOrderModel);
    }
}
