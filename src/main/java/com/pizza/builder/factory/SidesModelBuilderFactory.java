package com.pizza.builder.factory;

import com.pizza.builder.ColdDrinkSidesModelBuilder;
import com.pizza.builder.MousseCakeSidesModelBuilder;
import com.pizza.builder.SidesModelBuilder;
import com.pizza.model.sides.SidesName;

public class SidesModelBuilderFactory {
    public SidesModelBuilder getBuilder(String name) {
        SidesName sideName = SidesName.valueOf(name);
        SidesModelBuilder sidesModelBuilder = null;
        switch (sideName) {
            case COLDD_RINK:
                sidesModelBuilder = new ColdDrinkSidesModelBuilder(name);
                break;
            case MOUSSE_CAKE:
                sidesModelBuilder = new MousseCakeSidesModelBuilder(name);

        }
        return sidesModelBuilder;
    }
}
