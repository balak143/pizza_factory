package com.pizza.service.inventory;

import com.pizza.dao.InventoryData;
import com.pizza.model.ingredient.IngredientModel;

public interface InventoryService {
  InventoryData getInventory(IngredientModel model);

  void updateInventory(IngredientModel model);
}
