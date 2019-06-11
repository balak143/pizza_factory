package com.pizza.validator.order;

import com.pizza.exception.ApplicationException;
import com.pizza.exception.ThrowingConsumer;
import com.pizza.model.order.PizzaOrderModel;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.sides.AbstractSidesModel;
import com.pizza.validator.pizza.PizzaModelValidator;
import com.pizza.validator.sides.SidesModelValidator;

import java.util.List;

public class KalyaniPizzaStoreOrderModelValidator
    implements PizzaOrderModelValidator<PizzaOrderModel> {
  private PizzaModelValidator pizzaModelValidator;
  private SidesModelValidator sidesModelValidator;

  public KalyaniPizzaStoreOrderModelValidator(
      PizzaModelValidator pizzaModelValidator, SidesModelValidator sidesModelValidator) {
    this.pizzaModelValidator = pizzaModelValidator;
    this.sidesModelValidator = sidesModelValidator;
  }

  @Override
  public void validate(PizzaOrderModel pizzaOrderModel) throws ApplicationException {
    validatePizzaModels(pizzaOrderModel.getPizzaModels());
    validateSidesModes(pizzaOrderModel.getSidesModels());
  }

  private void validateSidesModes(List<AbstractSidesModel> sidesModels)
      throws ApplicationException {
    if (this.sidesModelValidator == null) {
      throw new ApplicationException("Sides Validator model is required ");
    }
    sidesModels.stream().forEach(sidesModelValidator::validate);
  }

  private void validatePizzaModels(List<AbstractPizzaModel> pizzaModels)
      throws ApplicationException {
    if (pizzaModels == null && pizzaModels.isEmpty()) {
      throw new ApplicationException("Pizza model not found ");
    }
    if (this.pizzaModelValidator == null) {
      throw new ApplicationException("Pizza Validator model is not set  ");
    }
    pizzaModels.stream()
        .forEach(
            abstractPizzaModel -> {
              try {
                pizzaModelValidator.validate(abstractPizzaModel);
              } catch (ApplicationException ex) {
                ThrowingConsumer.sneakyThrow(ex);
              }
            });
  }
}
