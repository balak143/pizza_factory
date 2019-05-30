package com.pizza.builder;

import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.sides.MousseCake;

public class MousseCakeSidesModelBuilder extends AbstractSideModelBuilder{

    public MousseCakeSidesModelBuilder(String sideInputData) {
        super(sideInputData);
    }

    @Override
    public MousseCake build(BuildContext context) {
        // call service to get the
        MousseCake mousseCake = new MousseCake();
        mousseCake.setIngredientModel(buildIngredientModel(getSidesInputData(), IngredientType.VEG, 50.0, "GRAM"));

        mousseCake.setIngredientModel(null);
        return mousseCake;
    }
}
