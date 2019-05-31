package com.pizza.builder;

import com.pizza.model.ingredient.IngredientModel;
import com.pizza.model.ingredient.IngredientType;

public abstract class AbstractSideModelBuilder implements SidesModelBuilder {
    private String sidesInputData;

    public AbstractSideModelBuilder(String sidesInputData) {
        this.sidesInputData = sidesInputData;
    }

    public String getSidesInputData() {
        return sidesInputData;
    }

    protected IngredientModel buildIngredientModel(String productName, IngredientType type, double qty, String uomCode) {
        return new IngredientModel(productName, type, qty, uomCode);
    }
}
