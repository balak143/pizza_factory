package com.pizza.service.cost;

import com.pizza.grid.CostMemoryGrid;
import com.pizza.grid.GridManager;
import com.pizza.grid.GridType;
import com.pizza.dao.CostData;
import com.pizza.dao.CostDataKey;
import com.pizza.model.ingredient.IngredientModel;
import com.pizza.utils.Price;

import java.util.Date;

public class IngredientCostService implements CostService {
    @Override
    public Price cost(IngredientModel model, Date date) {
        CostMemoryGrid costMemoryGrid = GridManager.getInstance().get(GridType.COST, CostMemoryGrid.class);
        CostData costData = costMemoryGrid.getData(new CostDataKey(model.getProductCode(), date));
        return new Price(costData.getPrice(), costData.getPriceCcy());
    }
}
