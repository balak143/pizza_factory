package com.pizza.validator.pizza;

import com.pizza.exception.ApplicationException;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.veg.DeluxeVeggiePizzaModel;
import com.pizza.validator.crust.CrustModelValidator;
import com.pizza.validator.topping.ToppingModelValidator;

/**
 * Any specific validations for Deluxe Veggies Pizza would go here.
 * This will not do anything extra, this can be extended in future
 */
public class DeluxeVeggiePizzaModelValidator extends AbstractPizzaModelValidator<DeluxeVeggiePizzaModel> {
    private ToppingModelValidator toppingModelValidator;
    private CrustModelValidator crustModelValidator;

    @Override
    public CrustModelValidator getCrustModelValidator() {
        return crustModelValidator;
    }

    @Override
    public void setCrustModelValidator(CrustModelValidator crustModelValidator) {
        this.crustModelValidator = crustModelValidator;
    }

    @Override
    public void validate(AbstractPizzaModel pizzaModel) throws ApplicationException {
        super.validate(pizzaModel);
    }

    @Override
    public ToppingModelValidator getToppingModelValidator() {
        return toppingModelValidator;
    }

    @Override
    public void setToppingModelValidator(ToppingModelValidator toppingModelValidator) {
        this.toppingModelValidator = toppingModelValidator;
    }
}
