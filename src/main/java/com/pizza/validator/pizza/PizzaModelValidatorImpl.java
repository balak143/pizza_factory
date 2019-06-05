package com.pizza.validator.pizza;

import com.pizza.model.pizza.veg.DeluxeVeggiePizzaModel;
import com.pizza.validator.crust.CrustModelValidator;
import com.pizza.validator.topping.ToppingModelValidator;

/**
 * Any specific validations for Deluxe Veggies Pizza would go here.
 */
public class PizzaModelValidatorImpl extends AbstractPizzaModelValidator<DeluxeVeggiePizzaModel> {
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
    public ToppingModelValidator getToppingModelValidator() {
        return toppingModelValidator;
    }

    @Override
    public void setToppingModelValidator(ToppingModelValidator toppingModelValidator) {
        this.toppingModelValidator = toppingModelValidator;
    }
}
