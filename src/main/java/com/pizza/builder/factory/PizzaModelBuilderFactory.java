package com.pizza.builder.factory;

import com.pizza.builder.CheeseCornPizzaModelBuilder;
import com.pizza.builder.ChickenTikkaPizzaModelBuilder;
import com.pizza.builder.DeluxeVeggiePizzaModelBuilder;
import com.pizza.builder.NonVegSupremePizzaModelBuilder;
import com.pizza.builder.PaneerTikkaPizzaModelBuilder;
import com.pizza.builder.PepperBarbecueChickenPizzaModelBuilder;
import com.pizza.builder.PizzaModelBuilder;
import com.pizza.input.PizzaInputData;
import com.pizza.model.pizza.PizzaName;

public class PizzaModelBuilderFactory {
    private static PizzaModelBuilderFactory INSTANCE = new PizzaModelBuilderFactory();

    public static PizzaModelBuilderFactory getInstance() {
        return INSTANCE;
    }

    public PizzaModelBuilder getBuilder(PizzaInputData pizza) {
        PizzaName pizzaName = PizzaName.of(pizza.getName());
        PizzaModelBuilder pizzaModelBuilder = null;
        switch (pizzaName) {
            case PANEER_TIKKA:
                pizzaModelBuilder = new PaneerTikkaPizzaModelBuilder(pizza);
                break;
            case CHEESE_CORN:
                pizzaModelBuilder = new CheeseCornPizzaModelBuilder(pizza);
                break;
            case DELUXE_VEGGIE:
                pizzaModelBuilder = new DeluxeVeggiePizzaModelBuilder(pizza);
                break;
            case CHICKEN_TIKKA:
                pizzaModelBuilder = new ChickenTikkaPizzaModelBuilder(pizza);
                break;
            case PEPPER_BARBECUE:
                pizzaModelBuilder = new PepperBarbecueChickenPizzaModelBuilder(pizza);
                break;
            case NONVEG_SUPREME:
                pizzaModelBuilder = new NonVegSupremePizzaModelBuilder(pizza);
                break;
            default:
                pizzaModelBuilder = new DeluxeVeggiePizzaModelBuilder(pizza);
        }
        return pizzaModelBuilder;
    }
}
