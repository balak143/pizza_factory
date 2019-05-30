package com.pizza.builder;

import com.pizza.model.order.PizzaOrderModel;
import com.pizza.model.pizza.PizzaModel;

public interface PizzaOrderModelBuilder {
    PizzaOrderModel build(BuildContext context);
}
