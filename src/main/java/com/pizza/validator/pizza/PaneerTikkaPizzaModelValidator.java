package com.pizza.validator.pizza;

import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.PizzaModel;
import com.pizza.model.pizza.veg.DeluxeVeggiePizzaModel;
import com.pizza.model.pizza.veg.PaneerTikkaPizzaModel;
import com.pizza.validator.crust.CrustModelValidator;
import com.pizza.validator.topping.ToppingModelValidator;

public class PaneerTikkaPizzaModelValidator implements PizzaModelValidator<PaneerTikkaPizzaModel> {
    private ToppingModelValidator toppingModelValidator;
    private CrustModelValidator crustModelValidator;
    public PaneerTikkaPizzaModelValidator(ToppingModelValidator toppingModelValidator,
                                          CrustModelValidator crustModelValidator) {
        this.toppingModelValidator = toppingModelValidator;
        this.crustModelValidator = crustModelValidator;
    }

    @Override
    public void validate(PaneerTikkaPizzaModel pizzaModel) {
        validateCrust(pizzaModel);
        validateToppings(pizzaModel);
    }

    private void validateToppings( AbstractPizzaModel pizzaModel) {


    }

    private void validateCrust(AbstractPizzaModel crustModel) {

    }

}
