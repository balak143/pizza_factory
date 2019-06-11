package com.pizza.builder;

import com.pizza.exception.ApplicationException;
import com.pizza.model.pizza.ingredients.IngredientRequiredQty;
import com.pizza.model.sides.ColdDrinkSidesModel;
import com.pizza.model.sides.SidesModelFactory;
import com.pizza.model.sides.AbstractSidesModel;
import com.pizza.model.sides.SidesName;

public class ColdDrinkSidesModelBuilder extends AbstractSideModelBuilder<ColdDrinkSidesModel> {

    public ColdDrinkSidesModelBuilder(String sidesInputData) {
        super(sidesInputData);
    }

    @Override
    public AbstractSidesModel build(BuildContext context) throws ApplicationException {
        SidesName sidesName = SidesName.of(getSidesInputData());
        AbstractSidesModel coldDrink = SidesModelFactory.getInstance().createSidesModel(sidesName);
        IngredientRequiredQty ingredientRequiredQty = getIngredientRequiredQty(sidesName.getName());
        coldDrink.setIngredientModel(buildIngredientModel(ingredientRequiredQty.getName(),
                ingredientRequiredQty.getType(), ingredientRequiredQty.getQty(), ingredientRequiredQty.getQtyUom()));
        return coldDrink;
    }
}
