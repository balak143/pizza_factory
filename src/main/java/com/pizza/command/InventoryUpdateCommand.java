package com.pizza.command;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.model.order.PizzaOrderModel;
import com.pizza.model.pizza.ingredients.AbstractPizzaIngredientsModel;
import com.pizza.service.inventory.IngredientInventoryService;
import com.pizza.service.inventory.InventoryService;

public class InventoryUpdateCommand implements Command {
  private InventoryService inventoryService = null;

  public InventoryUpdateCommand() {
    inventoryService = new IngredientInventoryService();
  }

  public InventoryUpdateCommand(InventoryService inventoryService) {
    this.inventoryService = inventoryService;
  }

  @Override
  public boolean execute(Context context) {
    PizzaOrderModel pizzaOrderModel = (PizzaOrderModel) context.getData("PIZZA_ORDER_MODEL");
    pizzaOrderModel
        .getPizzaModels()
        .forEach(
            abstractPizzaModel -> {
              AbstractPizzaIngredientsModel pizzaIngredientsModel =
                  abstractPizzaModel.getPizzaIngredientsModel();
              pizzaIngredientsModel
                  .getIngredients()
                  .forEach(ingredientModel -> inventoryService.updateInventory(ingredientModel));
            });
    pizzaOrderModel
        .getSidesModels()
        .forEach(
            abstractPizzaModel -> {
              IngredientModel ingredientModel = abstractPizzaModel.getIngredientModel();
              inventoryService.updateInventory(ingredientModel);
            });
    return true;
  }
}
