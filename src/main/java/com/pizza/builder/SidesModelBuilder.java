package com.pizza.builder;

import com.pizza.model.pizza.PizzaModel;
import com.pizza.model.sides.SidesModel;

public interface SidesModelBuilder {
    <T extends SidesModel> T build(BuildContext context);
}
