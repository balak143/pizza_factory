package com.pizza.validator;

import com.pizza.model.order.PizzaOrderModel;

public interface PizzaOrderModelValidator extends DataModelValidator {
    void validate(PizzaOrderModel pizzaModel);
}
