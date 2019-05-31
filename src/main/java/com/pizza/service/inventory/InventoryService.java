package com.pizza.service.inventory;

import com.pizza.dao.InventoryData;
import com.pizza.model.ingredient.IngredientModel;
import com.pizza.utils.Price;

import java.util.Date;

public interface InventoryService {
    InventoryData inventory(IngredientModel model);
}
