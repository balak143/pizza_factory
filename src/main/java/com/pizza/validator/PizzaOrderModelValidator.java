package com.pizza.validator;

import com.pizza.model.pizza.PizzaModel;
import com.pizza.order.PizzaOrderModel;

public interface PizzaOrderModelValidator extends DataModelValidator {
    void validate(PizzaOrderModel pizzaModel);
}
