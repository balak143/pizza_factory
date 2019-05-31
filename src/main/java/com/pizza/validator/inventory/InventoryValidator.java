package com.pizza.validator.inventory;

import com.pizza.model.order.PizzaOrderModel;
import com.pizza.validator.DataModelValidator;

public interface InventoryValidator extends DataModelValidator{
    void validate(PizzaOrderModel pizzaOrderModel);
}
