package com.pizza.model.sides;

public class SidesModelFactory {
  private static final SidesModelFactory INSTANCE = new SidesModelFactory();

  public static SidesModelFactory getInstance() {
    return INSTANCE;
  }

  public AbstractSidesModel createSidesModel(SidesName toppingName) {
    AbstractSidesModel sidesModel = null;
    if (SidesName.COLD_DRINK == toppingName) {

      sidesModel = new ColdDrinkSidesModel();
    } else if (SidesName.MOUSSE_CAKE == toppingName) {
      sidesModel = new MousseCakeSidesModel();
    }

    return sidesModel;
  }
}
