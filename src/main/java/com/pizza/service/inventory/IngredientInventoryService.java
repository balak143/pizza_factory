package com.pizza.service.inventory;

import com.pizza.cache.CostMemoryGrid;
import com.pizza.cache.GridManager;
import com.pizza.cache.GridType;
import com.pizza.cache.InventoryMemoryGrid;
import com.pizza.dao.CostData;
import com.pizza.dao.CostDataKey;
import com.pizza.dao.InventoryData;
import com.pizza.dao.InventoryDataKey;
import com.pizza.model.ingredient.IngredientModel;
import com.pizza.utils.Price;

import java.util.Date;

public class IngredientInventoryService implements InventoryService {
    @Override
    public InventoryData inventory(IngredientModel model) {
        InventoryMemoryGrid inventoryMemoryGrid = GridManager.getInstance().get(GridType.INVENTORY, InventoryMemoryGrid.class);
        InventoryData inventoryData = inventoryMemoryGrid.getData(new InventoryDataKey(model.getProductCode()));
        return inventoryData;
    }
}
