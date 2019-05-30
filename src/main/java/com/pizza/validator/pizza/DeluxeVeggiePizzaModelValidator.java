package com.pizza.validator.pizza;

import com.pizza.model.crust.CrustModel;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.PizzaModel;
import com.pizza.model.pizza.veg.DeluxeVeggiePizzaModel;
import com.pizza.model.pizza.veg.VegetarianPizzaModel;
import com.pizza.model.topping.ToppingModel;
import com.pizza.validator.crust.CrustModelValidator;
import com.pizza.validator.pizza.PizzaModelValidator;
import com.pizza.validator.topping.ToppingModelValidator;

import java.util.List;

public class DeluxeVeggiePizzaModelValidator implements PizzaModelValidator<DeluxeVeggiePizzaModel> {
    private ToppingModelValidator toppingModelValidator;
    private CrustModelValidator crustModelValidator;

    public DeluxeVeggiePizzaModelValidator(ToppingModelValidator toppingModelValidator,
                                           CrustModelValidator crustModelValidator) {
        this.toppingModelValidator = toppingModelValidator;
        this.crustModelValidator = crustModelValidator;
    }

    @Override
    public void validate(DeluxeVeggiePizzaModel pizzaModel) {
        validateCrust(pizzaModel);
        validateToppings(pizzaModel);
    }

    private void validateToppings( AbstractPizzaModel pizzaModel) {
        if(pizzaModel instanceof VegetarianPizzaModel){
            //pizzaModel.getToppings().
        }

    }

    private void validateCrust(AbstractPizzaModel crustModel) {

    }


}
