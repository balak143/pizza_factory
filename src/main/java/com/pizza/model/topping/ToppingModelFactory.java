package com.pizza.model.topping;

public class ToppingModelFactory {
    private static final ToppingModelFactory INSTANCE = new ToppingModelFactory();

    public static ToppingModelFactory getInstance() {
        return INSTANCE;
    }

    public AbstractToppingModel createToppingModel(ToppingName toppingName) {
        AbstractToppingModel toppingModel = null;
        switch (toppingName){
            case BLACK_OLIVE :
                toppingModel = new BlackOliveToppingModel();
                break;
            case CAPSICUM:
                toppingModel = new CapsicumToppingModel();
                break;
            case FRESH_TOMATO:
                toppingModel = new FreshTomatoToppingModel();
                break;
            case EXTRA_CHEESE:
                toppingModel = new ExtraCheeseToppingModel();
                break;
            case MUSHROOM:
                toppingModel = new MushroomToppingModel();
                break;
            case BARBEQUE_CHICKEN:
                toppingModel = new BarbequeChickenToppingModel();
                break;
            case CHICKEN_TIKKA:
                toppingModel = new ChickenTikkaToppingModel();
                break;
            case GRILLED_CHICKEN:
                toppingModel = new GrilledChickenToppingModel();
                break;
            default:

        }

        return toppingModel;
    }
}
