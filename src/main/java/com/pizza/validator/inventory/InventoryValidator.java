package com.pizza.validator.inventory;

import com.pizza.exception.ApplicationException;
import com.pizza.model.order.PizzaOrderModel;
import com.pizza.validator.DataModelValidator;

public interface InventoryValidator extends DataModelValidator{
    void validate(PizzaOrderModel pizzaOrderModel)throws ApplicationException;
}
