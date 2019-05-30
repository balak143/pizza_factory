package com.pizza.model.crust;

public class CrustModelFactory {
    private static final CrustModelFactory INSTANCE = new CrustModelFactory();

    public static CrustModelFactory getInstance() {
        return INSTANCE;
    }

    public AbstractCrustModel createCrustModel(CrustName crustName) {
        AbstractCrustModel crustModel = null;

        if(crustName == CrustName.CHEESEBURST) {
            crustModel = new CheeseBurstCrustModel();
        }

        return crustModel;
    }
}
