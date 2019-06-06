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

public class KalyaniInventoryValidator implements InventoryValidator {
    private InventoryService inventoryService;

    public KalyaniInventoryValidator(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public KalyaniInventoryValidator() {
        this.inventoryService = new IngredientInventoryService();
    }

    @Override
    public void validate(PizzaOrderModel pizzaOrderModel) {
        pizzaOrderModel.getPizzaModels().stream().forEach(
                pizzaModel -> {
                    checkPizzaIngredientStock(pizzaModel);
                    checkToppingIngredientStock(pizzaModel);
                }
        );
        pizzaOrderModel.getSidesModels().stream().forEach(
                sidesModel -> {
                    IngredientModel ingredientModel = sidesModel.getIngredientModel();
                    try {
                        validateStock(ingredientModel);
                    } catch (ApplicationException e) {
                        ThrowingConsumer.sneakyThrow(e);
                    }
                }
        );
    }

    private void checkToppingIngredientStock(AbstractPizzaModel abstractPizzaModel) {
        abstractPizzaModel.getToppings().stream().forEach(
                toppingModel -> {
                    try {
                        IngredientModel ingredientModel = toppingModel.getIngredientModel();
                        validateStock(ingredientModel);
                    } catch (ApplicationException e) {
                        ThrowingConsumer.sneakyThrow(e);
                    }
                }
        );
    }

    private void checkPizzaIngredientStock(AbstractPizzaModel abstractPizzaModel) {
        abstractPizzaModel.getPizzaIngredientsModel().getIngredients().stream().forEach(
                ingredientModel -> {
                    try {
                        validateStock(ingredientModel);
                    } catch (ApplicationException e) {
                        ThrowingConsumer.sneakyThrow(e);
                    }
                }
        );
    }

    public void accumulateIngredients(Map<String, IngredientModel> map, IngredientModel ingredientModel) {
        map.compute(ingredientModel.getProductCode(), (s, ingredientModel1) -> {
                    return new IngredientModel(s, ingredientModel1.getType(), (ingredientModel1.getRequiredQty() + ingredientModel.getRequiredQty()),
                            ingredientModel1.getQtyUom());
                }
        );

    }

    public void validateStock(IngredientModel ingredientModel) throws ApplicationException {
        InventoryData inventoryData = inventoryService.getInventory(ingredientModel);
        if (inventoryData == null) {
            throw new ApplicationException("Inventory Data is not available for Ingredient - " + ingredientModel.getProductCode());
        }
        if (inventoryData.getStockQty() < ingredientModel.getRequiredQty()) {
            throw new ApplicationException("Required Stock is not available in the inventory for Ingredient - " + ingredientModel.getProductCode());
        }
    }

    public InventoryService getInventoryService() {
        return inventoryService;
    }
}
