package com.pizza.model.cost;

import com.pizza.model.order.PizzaOrderModel;
import com.pizza.utils.Price;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Order Cost model will have list of Prices
 * 1) At Pizza Level including toppings ..etc
 * 2) At Sides level
 * For simplicity we have kept it separate to report order summary at Pizza and sides separately.
 */
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

    public void setPizzaCostModel(PizzaCostModel pizzaCostModel) {
        this.pizzaCostModel = pizzaCostModel;
    }

    public SidesCostModel getSidesCostModel() {
        return sidesCostModel;
    }

    public void setSidesCostModel(SidesCostModel sidesCostModel) {
        this.sidesCostModel = sidesCostModel;
    }
}
