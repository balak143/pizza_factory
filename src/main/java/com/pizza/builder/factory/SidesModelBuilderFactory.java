package com.pizza.builder.factory;

import com.pizza.builder.ColdDrinkSidesModelBuilder;
import com.pizza.builder.MousseCakeSidesModelBuilder;
import com.pizza.builder.SidesModelBuilder;
import com.pizza.model.sides.SidesName;

public class SidesModelBuilderFactory {
  private static SidesModelBuilderFactory INSTANCE = new SidesModelBuilderFactory();

  public static SidesModelBuilderFactory getInstance() {
    return INSTANCE;
  }

  public SidesModelBuilder getBuilder(String name) {
    SidesName sideName = SidesName.of(name);
    SidesModelBuilder sidesModelBuilder = null;
    if (SidesName.COLD_DRINK == sideName) {
      sidesModelBuilder = new ColdDrinkSidesModelBuilder(name);
    } else if (SidesName.MOUSSE_CAKE == sideName) {
      sidesModelBuilder = new MousseCakeSidesModelBuilder(name);
    }
    return sidesModelBuilder;
  }
}
