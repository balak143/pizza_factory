package com.pizza.model.crust;

public class CrustModelFactory {
    private static final CrustModelFactory INSTANCE = new CrustModelFactory();

    public static CrustModelFactory getInstance() {
        return INSTANCE;
    }

    public AbstractCrustModel createCrustModel(CrustName crustName) {
        AbstractCrustModel crustModel = null;
        switch (crustName) {
            case CHEESE_BURST:
                crustModel = new CheeseBurstCrustModel();
                break;
            case WHEAT_THIN_CRUST:
                crustModel = new WheatThinCrustModel();
                break;
            case NEW_HAND_TOSSED:
                crustModel = new NewHandTossedCrustModel();
                break;
            case FRESH_PAN_PIZZA:
                crustModel = new FreshPanCrustModel();
                break;
        }

        return crustModel;
    }
}
