package com.pizza.model.sides;

public class SidesModelFactory {
    private static final SidesModelFactory INSTANCE = new SidesModelFactory();

    public static SidesModelFactory getInstance() {
        return INSTANCE;
    }

    public AbstractSidesModel createSidesModel(SidesName toppingName) {
        AbstractSidesModel sidesModel = null;
        switch (toppingName) {
            case COLD_DRINK:
                sidesModel = new ColdDrinkSidesModel();
                break;
            case MOUSSE_CAKE:
                sidesModel = new MousseCakeSidesModel();
                break;
        }

        return sidesModel;
    }
}
