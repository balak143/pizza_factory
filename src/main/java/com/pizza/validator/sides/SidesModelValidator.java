package com.pizza.validator.sides;

import com.pizza.model.pizza.PizzaModel;
import com.pizza.model.sides.SidesModel;
import com.pizza.validator.DataModelValidator;

public interface SidesModelValidator<T extends SidesModel> extends DataModelValidator {
    void validate(T t);
}
