package com.pizza.validator.crust;

import com.pizza.model.pizza.PizzaModel;
import com.pizza.validator.DataModelValidator;

public interface CrustModelValidator<T extends PizzaModel>  extends DataModelValidator {
    void validate(T t);
}
