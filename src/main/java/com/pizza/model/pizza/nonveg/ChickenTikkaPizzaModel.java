package com.pizza.model.pizza.nonveg;

import com.pizza.dao.CostData;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.ingredients.DeluxeVeggiePizzaIngredientsModel;
import com.pizza.model.pizza.veg.VegetarianPizzaModel;
import com.pizza.utils.Price;

import java.util.Date;
import java.util.List;

public class ChickenTikkaPizzaModel extends AbstractPizzaModel implements NonVegetarianPizzaModel {

    @Override
    public IngredientType getPizzaType() {
        return IngredientType.NON_VEG;
    }
}
