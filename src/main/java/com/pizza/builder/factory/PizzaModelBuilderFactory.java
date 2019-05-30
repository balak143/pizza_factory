package com.pizza.builder.factory;

import com.pizza.builder.CheeseCornPizzaModelBuilder;
import com.pizza.builder.DeluxeVeggiePizzaModelBuilder;
import com.pizza.builder.PaneerTikkaPizzaModelBuilder;
import com.pizza.builder.PizzaModelBuilder;
import com.pizza.model.pizza.PizzaName;

public class PizzaModelBuilderFactory {
    public PizzaModelBuilder getBuilder(PizzaName pizzaName){
        PizzaModelBuilder pizzaModelBuilder ;
        switch (pizzaName){
            case PANEER_TIKKA:
                pizzaModelBuilder =  new PaneerTikkaPizzaModelBuilder();
                break;
            case CHEESE_CORN:
                pizzaModelBuilder =  new CheeseCornPizzaModelBuilder();
                break;
            case DELUXE_VEGGIE:
                pizzaModelBuilder =  new DeluxeVeggiePizzaModelBuilder();
                break;
             default:
                 pizzaModelBuilder = new DeluxeVeggiePizzaModelBuilder();
        }
        return pizzaModelBuilder;
    }
}
