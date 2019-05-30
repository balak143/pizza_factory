package com.pizza.builder;

import com.pizza.model.pizza.PizzaModel;
import com.pizza.model.sides.SidesModel;

public interface SidesModelBuilder {
    SidesModel build(BuildContext context);
}
