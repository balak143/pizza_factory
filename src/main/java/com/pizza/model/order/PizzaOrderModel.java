package com.pizza.model.order;

import com.pizza.model.cost.CostModel;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.PizzaModel;
import com.pizza.model.sides.AbstractSidesModel;
import com.pizza.model.sides.SidesModel;

import java.util.List;

public interface PizzaOrderModel extends CostModel {
    List<AbstractPizzaModel> getPizzaModels();
    List<AbstractSidesModel> getSidesModels();

}
