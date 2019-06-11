package com.pizza.command;

import com.pizza.exception.ApplicationException;
import com.pizza.model.order.PizzaOrderModel;
import com.pizza.validator.order.DonimosPizzaStoreOrderModelValidator;
import com.pizza.validator.pizza.DeluxeVeggiePizzaModelValidator;
import com.pizza.validator.pizza.PizzaModelValidator;
import com.pizza.validator.sides.ColdDrinkSidesModelValidator;
import com.pizza.validator.sides.SidesModelValidator;

import java.util.logging.Logger;

public class PizzaOrderValidatorCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(PizzaOrderValidatorCommand.class.getName());

    @Override
    public boolean execute(Context context) {
        PizzaOrderModel pizzaOrderModel = (PizzaOrderModel) context.getData("PIZZA_ORDER_MODEL");

        PizzaModelValidator pizzaModelValidator = new DeluxeVeggiePizzaModelValidator();
        SidesModelValidator sidesModelValidator = new ColdDrinkSidesModelValidator();
        DonimosPizzaStoreOrderModelValidator validator =
                new DonimosPizzaStoreOrderModelValidator(pizzaModelValidator, sidesModelValidator);
        try {
            validator.validate(pizzaOrderModel);
        } catch (ApplicationException e) {
            LOGGER.info(e.getMessage());
            return false;
        }

        return true;
    }
}
