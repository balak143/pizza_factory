package com.pizza.builder;

import com.pizza.exception.ApplicationException;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.ingredients.IngredientRequiredQty;
import com.pizza.model.sides.AbstractSidesModel;
import com.pizza.model.sides.MousseCakeSidesModel;
import com.pizza.model.sides.SidesModelFactory;
import com.pizza.model.sides.SidesName;

public class MousseCakeSidesModelBuilder extends AbstractSideModelBuilder<MousseCakeSidesModel>{

    public MousseCakeSidesModelBuilder(String sideInputData) {
        super(sideInputData);
    }

    @Override
    public AbstractSidesModel build(BuildContext context)throws ApplicationException {
        // call service to get the
        SidesName sidesName = SidesName.of(getSidesInputData());
        AbstractSidesModel mousseCakeSidesModel = SidesModelFactory.getInstance().createSidesModel(sidesName);
        IngredientRequiredQty ingredientRequiredQty = getIngredientRequiredQty(sidesName.getName());
        mousseCakeSidesModel.setIngredientModel(buildIngredientModel(ingredientRequiredQty.getName(),
                ingredientRequiredQty.getType(), ingredientRequiredQty.getQty(), ingredientRequiredQty.getQtyUom()));
        return mousseCakeSidesModel;
    }
}
