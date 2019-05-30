package com.pizza.validator.inventory;

import com.pizza.model.order.PizzaOrderModel;

public interface InventoryValidator {
    void validate(PizzaOrderModel pizzaOrderModel);
}
