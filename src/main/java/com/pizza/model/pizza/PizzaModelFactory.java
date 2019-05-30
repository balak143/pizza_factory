package com.pizza.model.pizza;

import com.pizza.model.pizza.nonveg.ChickenTikkaPizzaModel;
import com.pizza.model.pizza.nonveg.NonVegSupremePizzaModel;
import com.pizza.model.pizza.nonveg.PepperBarbecueChickenPizzaModel;
import com.pizza.model.pizza.veg.CheeseAndCornPizzaModel;
import com.pizza.model.pizza.veg.DeluxeVeggiePizzaModel;
import com.pizza.model.pizza.veg.PaneerTikkaPizzaModel;

public class PizzaModelFactory {
    private static final PizzaModelFactory INSTANCE = new PizzaModelFactory();

    public static PizzaModelFactory getInstance() {
        return INSTANCE;
    }

    public AbstractPizzaModel createPizzaModel(PizzaName pizzaName) {
        AbstractPizzaModel pizzaModel = null;

        switch (pizzaName) {
            case DELUXE_VEGGIE:
                pizzaModel = new DeluxeVeggiePizzaModel();
                break;
            case CHEESE_CORN:
                pizzaModel = new CheeseAndCornPizzaModel();
                break;
            case PANEER_TIKKA:
                pizzaModel = new PaneerTikkaPizzaModel();
                break;
            case NONVEG_SUPREME:
                pizzaModel = new NonVegSupremePizzaModel();
                break;
            case PEPPER_BARBECUE:
                pizzaModel = new PepperBarbecueChickenPizzaModel();
                break;
            case CHICKEN_TIKKA:
                pizzaModel = new ChickenTikkaPizzaModel();
                break;
        }

        return pizzaModel;
    }
}
