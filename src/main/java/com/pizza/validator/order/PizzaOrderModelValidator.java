package com.pizza.validator.order;

import com.pizza.model.order.PizzaOrderModel;
import com.pizza.validator.DataModelValidator;

public interface PizzaOrderModelValidator<T extends PizzaOrderModel> extends DataModelValidator {
    void validate(T t);
}
