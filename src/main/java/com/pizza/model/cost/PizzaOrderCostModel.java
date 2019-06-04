package com.pizza.model.cost;

import com.pizza.model.order.PizzaOrderModel;
import com.pizza.utils.Price;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PizzaOrderCostModel extends AbstractCostModel {
    private PizzaOrderModel pizzaOrderModel;

    private PizzaCostModel pizzaCostModel;
    private SidesCostModel sidesCostModel;

    public PizzaOrderCostModel(PizzaOrderModel pizzaOrderModel) {
        this.pizzaOrderModel = pizzaOrderModel;
    }

    @Override
    public List<Price> cost(Date orderDate) {
        List<Price> prices = new ArrayList<>();
        List<Price> pizzaPrices = addPizzasPrices(orderDate);

        PizzaPriceMerger merger = new PizzaPriceMerger();
        pizzaPrices = merger.merge(pizzaPrices);

        prices.addAll(pizzaPrices);

        List<Price> sidesPrices = addSidesPrices(orderDate);
        sidesPrices = merger.merge(sidesPrices);

        prices.addAll(sidesPrices);
        return prices;
    }

    private List<Price> addPizzasPrices(Date orderDate) {
        List<Price> prices = new ArrayList<>();
        pizzaOrderModel.getPizzaModels().forEach(pizzaModel -> {
            pizzaCostModel.setPizzaModel(pizzaModel);
            prices.addAll(pizzaCostModel.cost(orderDate));
        });
        return prices;
    }

    private List<Price> addSidesPrices(Date orderDate) {

        List<Price> prices = new ArrayList<>();
        pizzaOrderModel.getSidesModels().forEach(sidesModel -> {
            sidesCostModel.setSidesModel(sidesModel);
            prices.addAll(sidesCostModel.cost(orderDate));
        });
        return prices;
    }

    public PizzaCostModel getPizzaCostModel() {
        return pizzaCostModel;
    }

    public PizzaOrderCostModel setPizzaCostModel(PizzaCostModel pizzaCostModel) {
        this.pizzaCostModel = pizzaCostModel;
        return this;
    }

    public SidesCostModel getSidesCostModel() {
        return sidesCostModel;
    }

    public PizzaOrderCostModel setSidesCostModel(SidesCostModel sidesCostModel) {
        this.sidesCostModel = sidesCostModel;
        return this;
    }
}
