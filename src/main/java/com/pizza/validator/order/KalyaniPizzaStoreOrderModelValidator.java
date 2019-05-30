package com.pizza.validator.order;

import com.pizza.model.order.PizzaOrderModel;
import com.pizza.model.pizza.PizzaModel;
import com.pizza.model.sides.SidesModel;
import com.pizza.validator.inventory.InventoryValidator;
import com.pizza.validator.order.PizzaOrderModelValidator;
import com.pizza.validator.pizza.PizzaModelValidator;
import com.pizza.validator.sides.SidesValidator;

import java.util.List;

public class KalyaniPizzaStoreOrderModelValidator implements PizzaOrderModelValidator<PizzaOrderModel> {
    private PizzaModelValidator pizzaModelValidator;
    private InventoryValidator inventoryValidator;
    private SidesValidator sidesValidator;

    public KalyaniPizzaStoreOrderModelValidator(PizzaModelValidator pizzaModelValidator,
                                                InventoryValidator inventoryValidator,
                                                SidesValidator sidesValidator) {
        this.pizzaModelValidator = pizzaModelValidator;
        this.inventoryValidator = inventoryValidator;
        this.sidesValidator = sidesValidator;
    }

    @Override
    public void validate(PizzaOrderModel pizzaModel) {
        validatePizzaModels(pizzaModel.getPizzaModels());
        validateSidesModes(pizzaModel.getSidesModels());
        validateInventory();

    }

    private void validateInventory() {
        // Call Inventory Service to Validate the stock
    }


    private void validateSidesModes(List<SidesModel> sidesModels) {
        sidesModels.stream().forEach(sidesValidator::validate);
    }

    private void validatePizzaModels(List<PizzaModel> pizzaModels) {
        pizzaModels.stream().forEach(pizzaModelValidator::validate);
    }


}
