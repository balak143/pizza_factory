package com.pizza.builder;

import com.pizza.model.pizza.Size;
import com.pizza.model.pizza.ingredients.PaneerTikkaPizzaIngredientsModel;
import com.pizza.model.pizza.veg.PaneerTikkaPizzaModel;
import com.pizza.model.topping.BlackOliveToppingModel;

public class PaneerTikkaPizzaModelBuilder implements PizzaModelBuilder {

    @Override
    public PaneerTikkaPizzaModel build(BuildContext context) {
        PaneerTikkaPizzaModel paneerTikkaPizzaModel = new PaneerTikkaPizzaModel();
        paneerTikkaPizzaModel.setPizzaIngredientsModel(new PaneerTikkaPizzaIngredientsModel());
        paneerTikkaPizzaModel.addToppings(new BlackOliveToppingModel(null));
        paneerTikkaPizzaModel.setSize(Size.LARGE);
        return paneerTikkaPizzaModel;
    }
}
