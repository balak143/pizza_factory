package com.pizza.builder;

import com.pizza.model.order.PizzaOrderModel;

public interface PizzaOrderModelBuilder {
  PizzaOrderModel build(BuildContext context);
}
