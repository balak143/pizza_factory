package com.pizza.order.factory;

import com.pizza.order.model.enums.NONVEGETARIAN;
import com.pizza.order.model.enums.VEGETARIAN;
import com.pizza.order.model.enums.VEGTOPPING;
import com.pizza.order.model.pizza.nonveg.PepperBarbeQueue;
import com.pizza.order.model.pizza.veg.DeluxeVeggie;
import com.pizza.order.model.pizza.Pizza;
import com.pizza.order.model.topping.BlackOlive;
import com.pizza.order.model.topping.ChickenTikka;
import com.pizza.order.model.topping.Topping;

public class PizzaFactory {

    public Pizza createPizza(Enum pizza) {
        if (VEGETARIAN.DeluxeVeggie == pizza) {
            return new DeluxeVeggie();
        } else if (NONVEGETARIAN.PepperBarbecue == pizza) {
            return new PepperBarbeQueue();
        }
        return null;
    }

    public Topping toppings(Enum topping) {
        if (topping instanceof VEGTOPPING &&
                VEGTOPPING.BlackOlive == topping) {
            return new BlackOlive();
        } else if (topping instanceof NONVEGETARIAN &&
                NONVEGETARIAN.ChickenTikka == topping) {
            return new ChickenTikka();
        }
        return null;
    }


    /*@Override
    public double getPrice() {
        return Size.MEDIUM == this.getSize() ? 2.0 : 0.0;
    }*/


}