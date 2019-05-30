package com.pizza.validator;

import com.pizza.model.order.PizzaOrderModel;

public class KalyaniPizzaStoreOrderModelValidator implements PizzaOrderModelValidator {
    private PizzaModelValidator pizzaModelValidator;
    private InventoryValidator inventoryValidator;


    @Override
    public void validate(PizzaOrderModel pizzaModel) {

    }
}
