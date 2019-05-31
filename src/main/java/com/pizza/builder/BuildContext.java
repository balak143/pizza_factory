package com.pizza.builder;

import com.pizza.input.PizzaOrderInputData;

public class BuildContext {
    private PizzaOrderInputData pizzaOrderInputData;

    public PizzaOrderInputData getPizzaOrderInputData() {
        return pizzaOrderInputData;
    }

    public void setPizzaOrderInputData(PizzaOrderInputData pizzaOrderInputData) {
        this.pizzaOrderInputData = pizzaOrderInputData;
    }
}
