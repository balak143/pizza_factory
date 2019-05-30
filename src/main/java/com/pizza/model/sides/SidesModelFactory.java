package com.pizza.model.sides;

public class SidesModelFactory {
    private static final SidesModelFactory INSTANCE = new SidesModelFactory();

    public static SidesModelFactory getInstance() {
        return INSTANCE;
    }

    public AbstractSidesModel createSidesModel(SidesName toppingName) {
        AbstractSidesModel sidesModel = null;
        switch (toppingName) {
            case COLDD_RINK:
                sidesModel = new ColdDrink();
                break;
            case MOUSSE_CAKE:
                sidesModel = new MousseCake();
                break;
        }

        return sidesModel;
    }
}
