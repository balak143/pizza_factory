package com.pizza.builder;

import com.pizza.exception.ApplicationException;
import com.pizza.model.pizza.AbstractPizzaModel;

public interface PizzaModelBuilder {
  AbstractPizzaModel build(BuildContext context) throws ApplicationException;
}
