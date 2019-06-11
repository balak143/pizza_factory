package com.pizza.validator.inventory;

import com.pizza.dao.InventoryData;
import com.pizza.exception.ApplicationException;
import com.pizza.exception.ThrowingConsumer;
import com.pizza.model.ingredient.IngredientModel;
import com.pizza.model.order.PizzaOrderModel;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.service.inventory.IngredientInventoryService;
import com.pizza.service.inventory.InventoryService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DominosInventoryValidator implements InventoryValidator {
  private InventoryService inventoryService;
  private Map<String, IngredientModel> ingredientsMap = new ConcurrentHashMap<>();

  public DominosInventoryValidator(InventoryService inventoryService) {
    this.inventoryService = inventoryService;
  }

  public DominosInventoryValidator() {
    this.inventoryService = new IngredientInventoryService();
  }

  @Override
  public void validate(PizzaOrderModel pizzaOrderModel) {
    pizzaOrderModel.getPizzaModels().stream()
        .forEach(
            pizzaModel -> {
              checkPizzaIngredientStock(pizzaModel);
              checkToppingIngredientStock(pizzaModel);
            });

    pizzaOrderModel.getSidesModels().stream()
        .forEach(
            sidesModel -> {
              IngredientModel ingredientModel = sidesModel.getIngredientModel();
              accumulateIngredients(ingredientModel);
            });

    ingredientsMap.forEach(
        (s, ingredientModel) -> {
          try {
            validateStock(ingredientModel);
          } catch (ApplicationException e) {
            ThrowingConsumer.sneakyThrow(e);
          }
        });
  }

  private void checkToppingIngredientStock(AbstractPizzaModel abstractPizzaModel) {
    abstractPizzaModel.getToppings().stream()
        .forEach(toppingModel -> accumulateIngredients(toppingModel.getIngredientModel()));
  }

  private void checkPizzaIngredientStock(AbstractPizzaModel abstractPizzaModel) {
    abstractPizzaModel.getPizzaIngredientsModel().getIngredients().stream()
        .forEach(ingredientModel -> accumulateIngredients(ingredientModel));
  }

  /**
   * @param map
   * @param ingredientModel
   */
  public void accumulateIngredients(IngredientModel ingredientModel) {

    String productCode = ingredientModel.getProductCode();
    if (ingredientsMap.containsKey(productCode)) {
      IngredientModel model = ingredientsMap.get(productCode);
      model.setRequiredQty(model.getRequiredQty() + ingredientModel.getRequiredQty());

    } else {
      ingredientsMap.put(
          ingredientModel.getProductCode(),
          new IngredientModel(
              ingredientModel.getProductCode(),
              ingredientModel.getType(),
              ingredientModel.getRequiredQty(),
              ingredientModel.getQtyUom()));
    }
  }

  public void validateStock(IngredientModel ingredientModel) throws ApplicationException {
    InventoryData inventoryData = inventoryService.getInventory(ingredientModel);
    if (inventoryData == null) {
      throw new ApplicationException(
          "Inventory Data is not available for Ingredient - " + ingredientModel.getProductCode());
    }
    if (inventoryData.getStockQty() < ingredientModel.getRequiredQty()) {
      throw new ApplicationException(
          "Required Stock is not available in the inventory for Ingredient - "
              + ingredientModel.getProductCode());
    }
  }

  public InventoryService getInventoryService() {
    return inventoryService;
  }
}
