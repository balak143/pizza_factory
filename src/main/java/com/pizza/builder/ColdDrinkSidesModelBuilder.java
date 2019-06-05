package com.pizza.builder;

import com.pizza.model.sides.ColdDrinkSidesModel;
import com.pizza.model.sides.SidesModelFactory;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.sides.AbstractSidesModel;
import com.pizza.model.sides.SidesName;

public class ColdDrinkSidesModelBuilder extends AbstractSideModelBuilder<ColdDrinkSidesModel>{

    public ColdDrinkSidesModelBuilder(String sidesInputData) {
        super(sidesInputData);
    }

    @Override
    public AbstractSidesModel build(BuildContext context) {
        // call service to get the
        AbstractSidesModel coldDrink = SidesModelFactory.getInstance().createSidesModel(SidesName.valueOf(getSidesInputData()));
        coldDrink.setIngredientModel(buildIngredientModel(getSidesInputData(), IngredientType.BEVERAGES, 100.00, "ML"));
        return coldDrink;
    }
}
