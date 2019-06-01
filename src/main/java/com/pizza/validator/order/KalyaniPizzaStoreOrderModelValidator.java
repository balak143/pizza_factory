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
    private PizzaModelValidator pizzaModelValidator;
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
    public void validate(PizzaOrderModel pizzaOrderModel) throws ApplicationException {
        validatePizzaModels(pizzaOrderModel.getPizzaModels());
        validateSidesModes(pizzaOrderModel.getSidesModels());
        validateInventory(pizzaOrderModel);

    }

    private void validateInventory(PizzaOrderModel pizzaOrderModel)throws ApplicationException {
        if(this.inventoryValidator == null){
            throw new ApplicationException("Inventory Validator model is required ");
        }
       inventoryValidator.validate(pizzaOrderModel);
    }


    private void validateSidesModes(List<AbstractSidesModel> sidesModels)throws ApplicationException {
        if(this.sidesValidator == null){
            throw new ApplicationException("Sides Validator model is required ");
        }
        sidesModels.stream().forEach(sidesValidator::validate);
    }

    private void validatePizzaModels(List<AbstractPizzaModel> pizzaModels) throws ApplicationException {
           if(pizzaModels == null && pizzaModels.isEmpty()){
               throw new ApplicationException("Pizza model not found ");
           }
        if(this.pizzaModelValidator == null){
            throw new ApplicationException("Pizza Validator model is required  ");
        }
        pizzaModels.stream().forEach(abstractPizzaModel -> {
            try {
                pizzaModelValidator.validate(abstractPizzaModel);
            }catch (ApplicationException ex){
                ThrowingConsumer.sneakyThrow(ex);
            }
        });
    }

}
