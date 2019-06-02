package com.pizza.builder;

import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.sides.MousseCakeSidesModel;

public class MousseCakeSidesModelBuilder extends AbstractSideModelBuilder{

    public MousseCakeSidesModelBuilder(String sideInputData) {
        super(sideInputData);
    }

    @Override
    public MousseCakeSidesModel build(BuildContext context) {
        // call service to get the
        MousseCakeSidesModel mousseCakeSidesModel = new MousseCakeSidesModel();
        mousseCakeSidesModel.setIngredientModel(buildIngredientModel(getSidesInputData(), IngredientType.VEG, 50.0, "GRAM"));

        mousseCakeSidesModel.setIngredientModel(null);
        return mousseCakeSidesModel;
    }
}
