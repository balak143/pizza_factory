package com.pizza.model.order;

import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.sides.AbstractSidesModel;

import java.util.List;

public interface PizzaOrderModel {
  List<AbstractPizzaModel> getPizzaModels();

  List<AbstractSidesModel> getSidesModels();
}
