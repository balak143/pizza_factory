package com.pizza.command;

import com.pizza.exception.ApplicationException;
import com.pizza.input.PizzaOrderInputData;
import com.pizza.model.order.PizzaOrderModel;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.validator.pizza.PizzaModelValidator;
import com.pizza.validator.pizza.PizzaModelValidatorImpl;

import java.util.List;
import java.util.logging.Logger;

public class PizzaOrderValidatorCommand implements Command {
    private static Logger logger = Logger.getLogger(PizzaOrderValidatorCommand.class.getName());

    @Override
    public boolean execute(Context context) {
        PizzaOrderModel pizzaOrderModel = (PizzaOrderModel) context.getData("PIZZA_ORDER_MODEL");
        PizzaModelValidator pizzaModelValidator = new PizzaModelValidatorImpl();

        List<AbstractPizzaModel> pizzaModels = pizzaOrderModel.getPizzaModels();
        for (AbstractPizzaModel pizzaModel : pizzaModels) {
            try {
                pizzaModelValidator.validate(pizzaModel);
            } catch (ApplicationException e) {
                logger.info(e.getMessage());
                return false;
            }

        }
        return true;
    }
}
