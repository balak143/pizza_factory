package com.pizza.validator.order;

import com.pizza.exception.ApplicationException;
import com.pizza.exception.ThrowingConsumer;
import com.pizza.model.order.PizzaOrderModel;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.PizzaModel;
import com.pizza.model.sides.AbstractSidesModel;
import com.pizza.model.sides.SidesModel;
import com.pizza.validator.inventory.InventoryValidator;
import com.pizza.validator.order.PizzaOrderModelValidator;
import com.pizza.validator.pizza.AbstractPizzaModelValidator;
import com.pizza.validator.pizza.PizzaModelValidator;
import com.pizza.validator.sides.SidesValidator;

import java.util.List;

public class KalyaniPizzaStoreOrderModelValidator implements PizzaOrderModelValidator<PizzaOrderModel> {
    private AbstractPizzaModelValidator pizzaModelValidator;
    private InventoryValidator inventoryValidator;
    private SidesValidator sidesValidator;

    public KalyaniPizzaStoreOrderModelValidator(AbstractPizzaModelValidator pizzaModelValidator,
                                                InventoryValidator inventoryValidator,
                                                SidesValidator sidesValidator) {
        this.pizzaModelValidator = pizzaModelValidator;
        this.inventoryValidator = inventoryValidator;
        this.sidesValidator = sidesValidator;
    }

    @Override
    public void validate(PizzaOrderModel pizzaOrderModel) {
        validatePizzaModels(pizzaOrderModel.getPizzaModels());
        validateSidesModes(pizzaOrderModel.getSidesModels());
        validateInventory(pizzaOrderModel);

    }

    private void validateInventory(PizzaOrderModel pizzaOrderModel) {
        // Call Inventory Service to Validate the stock
    }


    private void validateSidesModes(List<AbstractSidesModel> sidesModels) {
        sidesModels.stream().forEach(sidesValidator::validate);
    }

    private void validatePizzaModels(List<AbstractPizzaModel> pizzaModels) {
        pizzaModels.stream().forEach(abstractPizzaModel -> {
            try {
                pizzaModelValidator.validate(abstractPizzaModel);
            }catch (ApplicationException ex){
                ThrowingConsumer.sneakyThrow(ex);
            }
        });
    }

}
