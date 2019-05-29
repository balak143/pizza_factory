package com.pizza.builder;

import com.pizza.factory.PizzaFactory;
import com.pizza.model.topping.ToppingModel;
import com.pizza.model.crust.Crust;
import com.pizza.model.enums.Size;

public class PizzaBuilder {
    Pizza pizza = null;
    PizzaFactory pizzaFactory = null;

    public PizzaBuilder(Enum pizza) {
        pizzaFactory = new PizzaFactory();
        this.pizza = pizzaFactory.createPizza(pizza);
    }

    public PizzaBuilder ofSize(Size size) {
        this.pizza.setSize(size);
        return this;
    }

    public PizzaBuilder withCrust(Crust crust) {
        this.pizza.setCrust(crust);
        return this;
    }

    public PizzaBuilder havingToppings(ToppingModel... toppings) {
        this.pizza.addToppings(toppings);
        return this;
    }

    public Pizza build() {
        return this.pizza;
    }

}
