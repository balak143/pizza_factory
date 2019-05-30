package com.pizza.builder;

import com.pizza.input.PizzaOrderInputData;

public class BuildContext {
    private PizzaOrderInputData pizzaOrderInputData;

    public PizzaOrderInputData getPizzaOrderInputData() {
        return pizzaOrderInputData;
    }

    public BuildContext setPizzaOrderInputData(PizzaOrderInputData pizzaOrderInputData) {
        this.pizzaOrderInputData = pizzaOrderInputData;
        return this;
    }
}
