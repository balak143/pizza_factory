package com.pizza.builder;

import com.pizza.model.pizza.PizzaModel;

public interface PizzaOrderModelBuilder {
    PizzaModel build(BuildContext context);
}
