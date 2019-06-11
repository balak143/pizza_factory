package com.pizza.builder;

import com.pizza.exception.ApplicationException;
import com.pizza.model.ingredient.IngredientModel;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.service.ingredient.IngredientQtyDeriveService;
import com.pizza.model.pizza.ingredients.IngredientRequiredQty;
import com.pizza.model.sides.AbstractSidesModel;

public abstract class AbstractSideModelBuilder<T extends AbstractSidesModel> implements SidesModelBuilder {
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


    protected IngredientRequiredQty getIngredientRequiredQty(String productName) throws ApplicationException {
        IngredientRequiredQty requiredQty = IngredientQtyDeriveService.getInstance().getQty(productName);
        return requiredQty;
    }

}
