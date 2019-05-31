package com.pizza.model.pizza.veg;

import com.pizza.dao.CostData;
import com.pizza.model.cost.CostModel;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.ingredients.DeluxeVeggiePizzaIngredientsModel;
import com.pizza.utils.Price;

import java.util.Date;
import java.util.List;

public class DeluxeVeggiePizzaModel extends AbstractPizzaModel implements VegetarianPizzaModel {

    @Override
    public IngredientType getPizzaType() {
        return IngredientType.VEG;
    }
}
