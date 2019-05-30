package com.pizza.builder;

import com.pizza.input.PizzaOrderInputData;
import com.pizza.model.pizza.PizzaModel;

public interface PizzaModelBuilder {
    PizzaModel build(BuildContext context);
}
