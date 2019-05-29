package com.pizza.validator;

import com.pizza.model.pizza.PizzaModel;
import com.pizza.order.PizzaOrderModel;

public class KalyaniPizzaStoreOrderModelValidator implements PizzaOrderModelValidator {
    private PizzaModelValidator pizzaModelValidator;
    private InventoryValidator inventoryValidator;


    @Override
    public void validate(PizzaOrderModel pizzaModel) {

    }
}
