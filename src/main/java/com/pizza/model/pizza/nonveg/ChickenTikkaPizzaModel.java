package com.pizza.model.pizza.nonveg;

import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.PizzaName;

public class ChickenTikkaPizzaModel extends AbstractPizzaModel implements NonVegetarianPizzaModel {
    public ChickenTikkaPizzaModel() {
        this.name = PizzaName.CHICKEN_TIKKA.getName();
    }

    @Override
    public IngredientType getPizzaType() {
        return IngredientType.NON_VEG;
    }
}
