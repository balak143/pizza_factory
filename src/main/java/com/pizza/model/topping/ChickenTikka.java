package com.pizza.model.topping;

import com.pizza.model.pizza.IngredientType;
import com.pizza.utils.Price;

import java.util.Date;

public class ChickenTikka implements ToppingModel {
    IngredientType type ;

    public ChickenTikka(){
        type = IngredientType.NON_VEG;
    }
    @Override
    public Price cost(Date date) {
        return null;
    }
}
