package com.pizza.builder;

import com.pizza.builder.factory.PizzaModelBuilderFactory;
import com.pizza.builder.factory.SidesModelBuilderFactory;
import com.pizza.command.PizzaOrderValidatorCommand;
import com.pizza.exception.ApplicationException;
import com.pizza.exception.ThrowingConsumer;
import com.pizza.input.PizzaInputData;
import com.pizza.input.PizzaOrderInputData;
import com.pizza.model.order.KalyaniPizzaStoreOrderModel;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.PizzaModel;
import com.pizza.model.sides.AbstractSidesModel;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class KalyaniPizzaStoreOrderModelBuilder implements PizzaOrderModelBuilder {


    @Override
    public KalyaniPizzaStoreOrderModel build(BuildContext buildContext) {
        PizzaOrderInputData pizzaOrderInputData = buildContext.getPizzaOrderInputData();
        KalyaniPizzaStoreOrderModel orderModel = new KalyaniPizzaStoreOrderModel();
        orderModel.setPizzaModels(buildPizzaModel(buildContext, pizzaOrderInputData.getPizzaInputDatas()));
        orderModel.setSidesModels(buildSidesModel(buildContext, pizzaOrderInputData.getSides()));
        return orderModel;
    }

    private List<AbstractPizzaModel> buildPizzaModel(BuildContext buildContext, List<PizzaInputData> pizzaInputDatas) {
        List<AbstractPizzaModel> pizzaModels = new ArrayList<>();
        pizzaInputDatas.forEach(pizzaInputData -> {
                    PizzaModelBuilder modelBuilder = PizzaModelBuilderFactory.getInstance()
                            .getBuilder(pizzaInputData);
                    try {
                        AbstractPizzaModel pizzaModel = modelBuilder.build(buildContext);
                        pizzaModels.add(pizzaModel);
                    } catch (ApplicationException e) {
                        ThrowingConsumer.sneakyThrow(e);
                    }
                }
        );
        return pizzaModels;
    }

    private List<AbstractSidesModel> buildSidesModel(BuildContext buildContext, List<String> sides) {
        List<AbstractSidesModel> sidesModels = new ArrayList<>();
        sides.forEach(side -> {
                    SidesModelBuilder modelBuilder = SidesModelBuilderFactory.getInstance()
                            .getBuilder(side);
                    try {
                        sidesModels.add(modelBuilder.build(buildContext));
                    } catch (ApplicationException e) {
                        ThrowingConsumer.sneakyThrow(e);
                    }
                }
        );
        return sidesModels;
    }
}
