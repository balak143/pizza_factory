package com.pizza.validator.pizza;

import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.PizzaModel;
import com.pizza.model.pizza.veg.CheeseAndCornPizzaModel;
import com.pizza.model.pizza.veg.DeluxeVeggiePizzaModel;
import com.pizza.validator.crust.CrustModelValidator;
import com.pizza.validator.topping.ToppingModelValidator;

public class CheeseCornPizzaModelValidator implements PizzaModelValidator<CheeseAndCornPizzaModel> {
    private ToppingModelValidator toppingModelValidator;
    private CrustModelValidator crustModelValidator;

    public CheeseCornPizzaModelValidator(ToppingModelValidator toppingModelValidator,
                                           CrustModelValidator crustModelValidator) {
        this.toppingModelValidator = toppingModelValidator;
        this.crustModelValidator = crustModelValidator;
    }

    @Override
    public void validate(CheeseAndCornPizzaModel pizzaModel) {
        validateCrust(pizzaModel);
        validateToppings(pizzaModel);
    }

    private void validateToppings( AbstractPizzaModel pizzaModel) {

    }

    private void validateCrust(AbstractPizzaModel crustModel) {

    }

}
