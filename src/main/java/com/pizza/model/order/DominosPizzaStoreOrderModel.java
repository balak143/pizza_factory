package com.pizza.model.order;

import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.sides.AbstractSidesModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DominosPizzaStoreOrderModel implements PizzaOrderModel {
  private List<AbstractPizzaModel> pizzaModels = new ArrayList<>();
  private List<AbstractSidesModel> sidesModels = new ArrayList<>();

  public void addPizzaModel(AbstractPizzaModel... pizzaModels) {
    this.pizzaModels.addAll(Arrays.asList(pizzaModels));
  }

  @Override
  public List<AbstractPizzaModel> getPizzaModels() {
    return this.pizzaModels;
  }

  public void addSidesModel(AbstractSidesModel... sidesModels) {
    this.sidesModels.addAll(Arrays.asList(sidesModels));
  }

  @Override
  public List<AbstractSidesModel> getSidesModels() {
    return this.sidesModels;
  }

  public DominosPizzaStoreOrderModel setPizzaModels(List<AbstractPizzaModel> pizzaModels) {
    this.pizzaModels = pizzaModels;
    return this;
  }

  public DominosPizzaStoreOrderModel setSidesModels(List<AbstractSidesModel> sidesModels) {
    this.sidesModels = sidesModels;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder string = new StringBuilder("List of Pizzas Ordered - ");
    string.append(System.lineSeparator());
    pizzaModels.forEach(
        abstractPizzaModel ->
            string.append(abstractPizzaModel.toString()).append(System.lineSeparator()));
    string.append(System.lineSeparator());
    sidesModels.forEach(sidesModel -> string.append(sidesModel.toString()));
    return string.toString();
  }
}
