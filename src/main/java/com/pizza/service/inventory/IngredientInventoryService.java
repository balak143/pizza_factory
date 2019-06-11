package com.pizza.service.inventory;

import com.pizza.dao.InventoryData;
import com.pizza.dao.InventoryDataKey;
import com.pizza.grid.GridManager;
import com.pizza.grid.GridType;
import com.pizza.grid.InventoryMemoryGrid;
import com.pizza.model.ingredient.IngredientModel;

public class IngredientInventoryService implements InventoryService {
  @Override
  public InventoryData getInventory(IngredientModel model) {
    InventoryMemoryGrid inventoryMemoryGrid =
        GridManager.getInstance().get(GridType.INVENTORY, InventoryMemoryGrid.class);
    return
        inventoryMemoryGrid.getData(new InventoryDataKey(model.getProductCode()));
  }

  @Override
  public void updateInventory(IngredientModel model) {
    InventoryMemoryGrid inventoryMemoryGrid =
        GridManager.getInstance().get(GridType.INVENTORY, InventoryMemoryGrid.class);
    inventoryMemoryGrid.updateData(
        new InventoryDataKey(model.getProductCode()),
        new InventoryData(model.getProductCode(), model.getRequiredQty(), model.getQtyUom()));
  }
}
