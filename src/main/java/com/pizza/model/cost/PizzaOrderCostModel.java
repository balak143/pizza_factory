package com.pizza.model.cost;

import com.pizza.model.order.PizzaOrderModel;
import com.pizza.utils.Price;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PizzaOrderCostModel extends AbstractCostModel {
    private PizzaOrderModel pizzaOrderModel;

    public PizzaOrderCostModel(PizzaOrderModel pizzaOrderModel) {
        this.pizzaOrderModel = pizzaOrderModel;
    }

    @Override
    public List<Price> cost(Date orderDate) {
        List<Price> prices = new ArrayList<>();
        List<Price> pizzaPrices = addPizzasPrices(orderDate);
        PizzaPriceMerger merger = new PizzaPriceMerger();
        Price mergePizzasPrice = merger.merge(pizzaPrices);
        prices.add(mergePizzasPrice);
        List<Price> sidesPrices = addSidesPrices(orderDate);
        Price mergeSidesPrice = merger.merge(sidesPrices);
        prices.add(mergeSidesPrice);
        return prices;
    }

    private List<Price> addPizzasPrices(Date orderDate) {
        List<Price> prices = new ArrayList<>();
        pizzaOrderModel.getPizzaModels().forEach(pizzaModel -> {
            prices.addAll(new PizzaCostModel(pizzaModel).cost(orderDate));
        });
        return prices;
    }

    private List<Price> addSidesPrices(Date orderDate) {
        List<Price> prices = new ArrayList<>();
        pizzaOrderModel.getSidesModels().forEach(sidesModel -> {
            prices.addAll(new SidesCostModel(sidesModel).cost(orderDate));
        });
        return prices;
    }
}
