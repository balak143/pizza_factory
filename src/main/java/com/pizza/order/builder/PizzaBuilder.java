package com.pizza.order.builder;

import com.pizza.order.factory.PizzaFactory;
import com.pizza.order.model.crust.Crust;
import com.pizza.order.model.enums.Size;
import com.pizza.order.model.pizza.Pizza;
import com.pizza.order.model.topping.Topping;

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

    public PizzaBuilder havingToppings(Topping... toppings) {
        this.pizza.addToppings(toppings);
        return this;
    }

    public Pizza build() {
        return this.pizza;
    }

}
