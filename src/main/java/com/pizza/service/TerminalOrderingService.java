package com.pizza.service;

import com.pizza.order.PizzaOrder;
import com.pizza.model.enums.OrderType;
import com.pizza.utils.OrderRef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TerminalOrderingService implements OrderingService {
    private List<PizzaOrder> pizzaOrders = new ArrayList<>();
    //private PriceDAO orderDAO = null;
    private OrderType type = null;

    public TerminalOrderingService(PizzaOrder... pizzaOrder) {
        this.pizzaOrders.addAll(Arrays.asList(pizzaOrder));
        type = OrderType.Terminal;
        //orderDAO = new PriceDAO();
    }

    @Override
    public void validateOrder() throws Exception {

    }

    @Override
    public OrderRef placeOrder() {
        return null;
    }

    @Override
    public double calculatePrice() {
        return pizzaOrders.stream().mapToDouble(PizzaOrder::calculateTotal).sum();
    }
}
