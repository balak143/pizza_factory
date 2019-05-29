package com.pizza.factory;

import com.pizza.model.topping.BlackOliveToppingModelModel;
import com.pizza.model.topping.ChickenTikka;
import com.pizza.model.topping.ToppingModel;
import com.pizza.model.enums.NONVEGETARIAN;
import com.pizza.model.enums.VEGETARIAN;
import com.pizza.model.enums.VEGTOPPING;
import com.pizza.model.pizza.nonveg.PepperBarbeQueue;
import com.pizza.model.pizza.veg.DeluxeVeggie;

public class PizzaFactory {

    public Pizza createPizza(Enum pizza) {
        if (VEGETARIAN.DeluxeVeggie == pizza) {
            return new DeluxeVeggie();
        } else if (NONVEGETARIAN.PepperBarbecue == pizza) {
            return new PepperBarbeQueue();
        }
        return null;
    }

    public ToppingModel toppings(Enum topping) {
        if (topping instanceof VEGTOPPING &&
                VEGTOPPING.BlackOlive == topping) {
            return new BlackOliveToppingModelModel();
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