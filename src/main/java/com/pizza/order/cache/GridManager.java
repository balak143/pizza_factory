package com.pizza.order.cache;

import java.util.HashMap;
import java.util.Map;

public class GridManager {
    Map<GridType, Grid> grids = new HashMap<>();

    private GridManager() {

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
}
