package com.pizza.validator.topping;

import com.pizza.model.pizza.PizzaModel;
import com.pizza.validator.DataModelValidator;

public interface ToppingModelValidator<T extends PizzaModel>  extends DataModelValidator{
    void validate(T t);
}
