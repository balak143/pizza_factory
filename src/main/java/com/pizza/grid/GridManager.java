package com.pizza.grid;

import java.util.HashMap;
import java.util.Map;

public class GridManager {
  private static final GridManager INSTANCE = new GridManager();

  private Map<GridType, Grid> grids = new HashMap<>();

  private GridManager() {}

  public static GridManager getInstance() {
    return INSTANCE;
  }

  public void registerGrid(Grid grid) {
    grids.put(grid.getType(), grid);
  }

  public Grid get(GridType gridType) {
    return grids.get(gridType);
  }

  public <T extends Grid> T get(GridType gridType, Class<T> clazz) {
    Grid obj = grids.get(gridType);
    return clazz.cast(obj);
  }
}
