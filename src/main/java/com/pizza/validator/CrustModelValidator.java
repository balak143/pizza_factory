package com.pizza.validator;

import com.pizza.model.pizza.PizzaModel;

public interface CrustModelValidator extends DataModelValidator {
    void validate(PizzaModel pizzaModel);
}
