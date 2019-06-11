package com.pizza.model.pizza.veg;

import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.PizzaName;

public class CheeseAndCornPizzaModel extends AbstractPizzaModel implements VegetarianPizzaModel {
    public CheeseAndCornPizzaModel(){
        this.name = PizzaName.CHEESE_CORN.getName();
    }
    @Override
    public IngredientType getPizzaType() {
        return IngredientType.VEG;
    }
}
