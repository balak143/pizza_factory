package com.pizza.command;

import com.pizza.builder.BuildContext;
import com.pizza.input.PizzaOrderInputData;
import com.pizza.model.cost.PizzaCostModel;
import com.pizza.model.cost.PizzaOrderCostModel;
import com.pizza.model.order.PizzaOrderModel;
import com.pizza.service.cost.IngredientCostService;
import com.pizza.utils.Price;

import java.util.Date;
import java.util.List;

public class PizzaOrderCostCommand implements Command {
    @Override
    public boolean execute(Context context) {
        PizzaOrderInputData pizzaOrderInputData = (PizzaOrderInputData)context.getData("PIZZA_ORDER_INPUT");
        PizzaOrderModel pizzaOrderModel = (PizzaOrderModel)context.getData("PIZZA_ORDER_MODEL");

        PizzaOrderCostModel pizzaOrderCostModel = new PizzaOrderCostModel(pizzaOrderModel);
        PizzaCostModel pizzaCostModel = new PizzaCostModel();
        pizzaCostModel.setCostService(new IngredientCostService());
        pizzaOrderCostModel.setPizzaCostModel(pizzaCostModel);

        List<Price> prices = pizzaOrderCostModel.cost(pizzaOrderInputData.getOrderDate());

        context.setData("ORDER_PRICE", prices);
        System.out.println(prices);

        return true;
    }
}
