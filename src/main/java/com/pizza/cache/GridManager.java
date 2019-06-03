package com.pizza.cache;

import java.util.HashMap;
import java.util.Map;

public class GridManager {
    Map<GridType, Grid> grids = new HashMap<>();

    private GridManager() {
        registerGrid(new CostMemoryGrid());
        registerGrid(new InventoryMemoryGrid());
    }

    public static GridManager getInstance() {
        return new GridManager();
    }

    public void registerGrid(Grid grid) {
        grids.put(grid.getType(), grid);
    }

    public Grid get(GridType gridType) {
        return grids.get(gridType);
    }

    public <T extends Grid> T get(GridType gridType, Class<T> clazz) {
        return clazz.cast(grids.get(gridType));
    }
}
