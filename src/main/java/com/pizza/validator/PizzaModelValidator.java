package com.pizza.validator;

import com.pizza.model.pizza.PizzaModel;

public interface PizzaModelValidator extends DataModelValidator {
    void validate(PizzaModel pizzaModel);
}
