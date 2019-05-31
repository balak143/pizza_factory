package com.pizza.validator.pizza;

import com.pizza.exception.ApplicationException;
import com.pizza.model.pizza.veg.DeluxeVeggiePizzaModel;
import com.pizza.validator.crust.CrustModelValidator;
import com.pizza.validator.topping.ToppingModelValidator;

/**
 * Any specific validations for Deluxe Veggies Pizza would go here.
 */
public class DeluxeVeggiePizzaModelValidator extends AbstractPizzaModelValidator<DeluxeVeggiePizzaModel> {
    private ToppingModelValidator toppingModelValidator;
    private CrustModelValidator crustModelValidator;
    public DeluxeVeggiePizzaModelValidator(ToppingModelValidator toppingModelValidator,
                                          CrustModelValidator crustModelValidator) {
        this.toppingModelValidator = toppingModelValidator;
        this.crustModelValidator = crustModelValidator;
    }

    @Override
    public void validate(DeluxeVeggiePizzaModel pizzaModel) throws ApplicationException {
        super.validate(pizzaModel);
    }
}
