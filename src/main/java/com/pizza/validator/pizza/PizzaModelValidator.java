package com.pizza.validator.pizza;

import com.pizza.model.pizza.PizzaModel;
import com.pizza.validator.DataModelValidator;

public interface PizzaModelValidator<T extends PizzaModel> extends DataModelValidator {
    void validate(T t);
}
